package com.beauty;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.directwebremoting.Browser;
import org.directwebremoting.Container;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.springframework.stereotype.Controller;

import com.beauty.security.UserInfo;

@Controller
@RemoteProxy(name = "PushMessageController")
public class PushMessageController {

	private Logger logger = Logger.getLogger(getClass());

	/**
	 * 
	 * @Title: init
	 * @Description: TODO(为每个登陆用户创建 ScriptSession)
	 * @author frinder_liu
	 * @param userId
	 * @return void
	 * @date 2015年10月11日 下午2:39:36
	 * @throws
	 */
	@RemoteMethod
	public void init(String userId) {
		logger.debug("dwr...............init..............begin !");
		// 获取 script session
		ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
		// 将登陆用户放入 script session 中
		scriptSession.setAttribute(userId, userId);
		// 获取 dwr 容器
		Container container = ServerContextFactory.get().getContainer();
		// 获取 session 管理器
		ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
		// 添加监听器
		ScriptSessionListener listener = new ScriptSessionListener() {
			public void sessionCreated(ScriptSessionEvent event) {
				// 获取 http session
				HttpSession session = WebContextFactory.get().getSession();
				String userId = ((UserInfo) session.getAttribute("CURRENT_USER")).getName();
				// 将 userId 放到 session 中，为实现精确推送奠基
				event.getSession().setAttribute("userId", userId);
				logger.debug("dwr............a ScriptSession is created!");
			}

			public void sessionDestroyed(ScriptSessionEvent ev) {
				logger.debug("dwr............a ScriptSession is distroyed");
			}
		};
		// 将监听器放入 session 管理器
		manager.addScriptSessionListener(listener);
		logger.debug("dwr...............init..............end !");
	}

	/**
	 * 
	 * @Title: send
	 * @Description: TODO(实现消息发送)
	 * @author frinder_liu
	 * @param userId
	 * @param message
	 * @return void
	 * @date 2015年10月11日 下午2:47:49
	 * @throws
	 */
	@RemoteMethod
	public void sendDwrMessage(String userId, String message) {
		final String _userId = userId;
		final String _message = message;
		// 查找 userId，并实现消息推送
		Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			public boolean match(ScriptSession session) {
				if (session.getAttribute("userId") == null) {
					return false;
				} else {
					return (session.getAttribute("userId").toString()).equalsIgnoreCase(_userId);
				}
			}
		}, new Runnable() {
			private ScriptBuffer script = new ScriptBuffer();

			public void run() {
				script.appendCall("showMessage", _message);
				Collection<ScriptSession> sessions = Browser.getTargetSessions();
				for (ScriptSession scriptSession : sessions) {
					scriptSession.addScript(script);
				}
			}
		});
	}

}
