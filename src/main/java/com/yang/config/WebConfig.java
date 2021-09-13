package com.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yang.aop.AdminInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.html");
		WebMvcConfigurer.super.addViewControllers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册TestInterceptor拦截器
		InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
		registration.addPathPatterns("/**"); // 所有路径都被拦截
		registration.excludePathPatterns( // 添加不拦截路径
				"/login", // 登录
				"/user/login", // html静态资源
				"/layuiAdmin/*.js", // js静态资源
				"/**/*.css", // css静态资源
				"/**/*.woff", "/**/*.ttf");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
