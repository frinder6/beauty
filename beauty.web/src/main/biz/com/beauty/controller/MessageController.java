package com.beauty.controller;

import com.beauty.entity.BeautyMessage;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.MessageService;
import com.beauty.util.CodeUtil;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

	@RequestMapping(value = "/load/by/account", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> queryByAccount(HttpSession session){
		Map<String, Object> params = new HashMap<>();
		params.put("account", session.getAttribute("CURRENT_USER_ACCOUNT"));
		return this.messageService.selectByAccount(params);
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(BeautyMessage entity) {
		this.messageService.insertSelective(entity);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyMessage entity) {
		this.messageService.updateByPrimaryKeySelective(entity);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.messageService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	@RequestMapping(value = "/mark", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value mark(Value value) {
		if (!value.getValues().isEmpty()) {
			this.messageService.batchMark(value.getValues());
		}
		return new Value(CodeUtil.SUCCESS);
	}

	@RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BeautyMessage load(@RequestParam("id") Long id) {
		return this.messageService.selectByPrimaryKey(id);
	}


}
