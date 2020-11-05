package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class combineAopExpressions {
	
	//c 指定メソッド前に呼び出し
	//c .. はすべての引数（数値を基本)に対応するワイルドカード
	@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))") //c * ワイルドカード指定で様々なアクセス修飾子, メソッド/クラス名,　戻り値, 引数などを指定できる(アクセス修飾子は省略可)
	public void kamash() {}		
		
	//getter/setter用@Pointcut
	@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
	public void getter() {}
		
	@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
	public void setter() {}
		
	//getter/setter @Pointcut統合
	@Pointcut("kamash() && !(getter() || setter())")
	public void combineNoGetterSetter() {}

}
