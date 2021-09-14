package com.yang.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomizeExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handle(Throwable e, Model model) {
		if (e instanceof CustomException) {
			model.addAttribute("message", e.getMessage());
		} else {
			model.addAttribute("message", "服务冒烟了,要不让你稍后再试试");
		}
		return new ModelAndView("error");
	}
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handle1(Throwable e, Model model) {	
		System.out.println(e);
		return new ModelAndView("redirect:error");
	}
	
	@ExceptionHandler(CustomUnauthorizedException.class)
	public ModelAndView handle2(Throwable e, Model model) {	
		System.out.println("未登录CustomUnauthorizedException");
		return new ModelAndView("redirect:/login");
	}
	
	
}
