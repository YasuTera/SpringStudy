package com.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.demo")
@PropertySource({ "classpath:application.properties" })
public class DemoAppConfig implements WebMvcConfigurer {

	//ViewResolver�pBean��`

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// RestTemplate�pBean��` �@client REST�̌Ăяo���Ɏg�p
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//webapp/resources�t�@�C���� CSS�@images�ďo�p
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }	
}









