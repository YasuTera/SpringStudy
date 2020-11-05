package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//c 指定メソッド前に呼び出し
	//c .. はすべての引数（数値を基本)に対応するワイルドカード
	@Before("execution(* com.spring.aopdemo.dao.*.*(..))") //c * ワイルドカード指定で様々なアクセス修飾子, メソッド/クラス名,　戻り値, 引数などを指定できる(アクセス修飾子は省略可)
	public void beforeAddAccount() {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
	}

}
