package com.spring.security.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	// <servlet></servlet>内の役割　DemoAppConfig.java内にて設定した画面側ルート画面ファイルディレクトリ指定
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {DemoAppConfig.class};
	}
	
	// <servlet-mapping></servlet-mapping>の役割　URL設定
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
