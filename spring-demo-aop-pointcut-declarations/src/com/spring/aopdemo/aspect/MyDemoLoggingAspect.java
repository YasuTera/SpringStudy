package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//c 指定メソッド前に呼び出し
	//c .. はすべての引数（数値を基本)に対応するワイルドカード
	@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))") //c * ワイルドカード指定で様々なアクセス修飾子, メソッド/クラス名,　戻り値, 引数などを指定できる(アクセス修飾子は省略可)
	private void kamash() {}
	
	//c 指定メソッド前に呼び出し kamashiメソッド実行前に実行
	@Before("kamash()") 
	public void beforeAddAccount() {
		
		System.out.println("=====>>> From beforeAddAccount");
	}
	
	//c 上の@Before後に呼出
	@Before("kamash()")
	public void performApiAnalytics() {
		
		System.out.println("=====>>> From performApiAnalytics()");
	}

}
