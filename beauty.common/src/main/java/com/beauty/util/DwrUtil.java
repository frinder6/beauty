package com.beauty.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.directwebremoting.*;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created on 2016/2/25.
 */
public class DwrUtil {

    private static Logger logger = Logger.getLogger(DwrUtil.class);

    /**
     * 初始化session
     *
     * @param userId
     */
    public static void init(String userId) {
        logger.debug("dwr...............init..............begin !");
        logger.info("dwr................init..............userId..............[ ".concat(userId).concat(" ]!"));
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
                String userId = StringUtil.valueOf(session.getAttribute("CURRENT_USER_ACCOUNT"));
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
     * 向客户端推送消息
     *
     * @param userId
     * @param message
     */
    public static void sendMessage(String userId, Object message) {
        logger.info("dwr................send..............userId..............[ ".concat(userId).concat(" ]!"));
        final String _userId = userId;
        final String _message = JSON.toJSONString(message);
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


