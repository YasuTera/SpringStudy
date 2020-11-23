package com.spring.security.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	// <servlet></servlet>���̖����@DemoAppConfig.java���ɂĐݒ肵����ʑ����[�g��ʃt�@�C���f�B���N�g���w��
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {DemoAppConfig.class};
	}
	
	// <servlet-mapping></servlet-mapping>�̖����@URL�ݒ�
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
