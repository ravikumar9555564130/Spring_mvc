package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutExpression {

	// point cut declaration
	@Pointcut("execution(public void com.aop.AcountDAO.addAccount(..))")
	public void addAccountPointcut_1() {
	}

	// point cut declaration
	@Pointcut("execution(public void com.aop.AcountDAO2.addAccount())")
	public void addAccountPointcut_2() {
	}

}
