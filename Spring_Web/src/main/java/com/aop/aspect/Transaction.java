package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Aspect
@Component
public class Transaction {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Before("com.aop.aspect.PointCutExpression.addAccountPointcut_1() || com.aop.aspect.PointCutExpression.addAccountPointcut_2()")
	public void addAccountAdvice_1() {

		logger.info("@before addAccountAdvice() for method  addAccount()::: Transaction ");

	}

}
