package com.spring.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.spring.security.demo")
public class DemoAppConfig {
	
	//Bean’è‹`
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver vRes = new InternalResourceViewResolver();
		vRes.setPrefix("/WEB-INF/view/");
		vRes.setSuffix(".jsp");
		
		return vRes;
	}

}
