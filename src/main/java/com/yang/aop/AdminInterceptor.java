package com.yang.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yang.config.token.TokenUtil;
import com.yang.constant.Constant;
import com.yang.exception.CustomUnauthorizedException;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	public static final String TokenName = "Authorization";

	@Autowired
	private TokenUtil tokenUtil;

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		System.out.println("执行了TestInterceptor的preHandle方法");
		String url = request.getRequestURI();
		System.out.println("请求的地址：" + url);
		String token = getToken(request, response, handler);
		if (token == null) {
			throw new CustomUnauthorizedException();
		}
		System.out.println(token);
		boolean b = tokenUtil.verify(token);
		String s = tokenUtil.getClaim(token, Constant.ACCOUNT);

		System.out.println(s);
		return true;
	}

	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		System.out.println("执行了TestInterceptor的postHandle方法");
	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("执行了TestInterceptor的afterCompletion方法");
	}

	protected String getToken(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object handler) {
		// 拿到当前Header中Authorization的AccessToken(Shiro中getAuthzHeader方法已经实现)
		String token = httpRequest.getHeader(TokenName);
		if (token == null) {
			token = httpRequest.getParameter(TokenName);
		}
		return token;
	}

}
