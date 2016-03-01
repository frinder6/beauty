package com.beauty.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/redirect")
public class RedirectController {

	/**
	 * 
	 * @Title: redirect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param redirect
	 * @param type
	 * @return
	 * @return String
	 * @date 2015年4月8日 下午10:49:20
	 * @throws
	 */
	@RequestMapping("/redirect/{redirect}/{type}")
	public String redirect(@PathVariable("redirect") String redirect, @PathVariable("type") String type) {
		redirect = redirect.replaceAll("\\.", "/");
		String ret = "redirect:/%s.%s";
		return String.format(ret, redirect, type);
	}

	/**
	 * 
	 * @Title: forward
	 * @Description: TODO(跳转方法)
	 * @author frinder_liu
	 * @param forward
	 * @return
	 * @return ModelAndView
	 * @date 2015年4月4日 下午1:25:47
	 * @throws
	 */
	@RequestMapping("/forward/{forward}")
	public ModelAndView forward(HttpServletRequest request, @PathVariable("forward") String forward) {
		forward = forward.replaceAll("\\.", "/");
		ModelAndView mv = new ModelAndView(forward);
		String param = request.getParameter("param");
		mv.addObject("param", param);
		return mv;
	}

}
