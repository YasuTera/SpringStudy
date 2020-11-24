package com.spring.security.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//add
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//jdbc���p��DB�Ƀ��[�U�ǉ�
		auth.jdbcAuthentication().dataSource(securityDataSource);
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
				.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-deny");
	}

	
	
}
