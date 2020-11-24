package com.spring.security.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.spring.security.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	//cデータ保持用
	@Autowired
	private Environment env;
	
	//for log display
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	//Bean定義
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver vRes = new InternalResourceViewResolver();
		vRes.setPrefix("/WEB-INF/view/");
		vRes.setSuffix(".jsp");
		
		return vRes;
	}
	
	//DB用Bean定義
	@Bean
	public DataSource securtityDataSource() {
		
		//c 接続用変数
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//jdbcラドライバクラス定義
		try {
			
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			
			throw new RuntimeException(exc);
		}
		
		//DB接続ログ表示処理 ※passlogは絶対に書かないこと
		logger.info(">>> jdbc.url =" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user =" + env.getProperty("jdbc.user"));
		
		//set
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));		
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));		
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	//c 同処理省略 String to Integer
	private int getIntProperty(String str) {
		
		String val = env.getProperty(str);
		
		//Int変換
		int StrToInt = Integer.parseInt(val);
		
		return StrToInt;
	}

}
