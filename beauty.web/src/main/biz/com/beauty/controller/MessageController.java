package com.beauty.controller;

import com.beauty.entity.Page;
import com.beauty.service.MessageService;
import com.beauty.util.DwrUtil;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
@RemoteProxy(name = "MessageController")
public class MessageController {


	@Autowired
	private MessageService messageService;


	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		page.pageToMap(params);
		int count = this.messageService.selectCount(params);
		List<?> list = this.messageService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}


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
