package com.spring.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// User add in memory ���[�U�[�̌����w��
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("Beruf0").password("berufadmin123").roles("EMPLOYEE"))
			.withUser(users.username("Beruf1").password("berufadmin123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("Beruf2").password("berufadmin123").roles("EMPLOYEE", "ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//c �ŏ��ɒN�ł��A�N�Z�X�ł��郉���f�B���O�y�[�W�̎���
		http.authorizeRequests()
			.antMatchers("/").permitAll() //c �ŏ��ɃA�N�Z�X�ł���y�[�W�ɐ擱
			.antMatchers("/employees").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			//.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authUser")
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/") //c ���O�A�E�g��Aroot�y�[�W�Ƀ��_�C���N�g
				.permitAll();
	}

	
	
}
