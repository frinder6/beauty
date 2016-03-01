package com.beauty.controller;

import com.beauty.util.DwrUtil;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RemoteProxy
public class PushMessageController {


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
		DwrUtil.init(userId);
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
	public void sendServerMessage(String userId, String message) {
		DwrUtil.sendMessage(userId, message);
	}



}
