package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.Account;

@Order(1)
@Aspect
@Component
public class Logingn {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Before("com.aop.aspect.PointCutExpression.addAccountPointcut_1() || com.aop.aspect.PointCutExpression.addAccountPointcut_2()")
	public void addAccountAdvice(JoinPoint joinpoint) {

		logger.info("@before addAccountAdvice() for method  addAccount()::: Logingn ");

		logger.info("started using joinpint");

		Signature signature = joinpoint.getSignature();
		System.out.println("signature  :: " +signature);
		
		Object[] args = joinpoint.getArgs();
		
		for (Object object : args) {
			
			if(object instanceof Account) {
				Account account = (Account)object;
				System.out.println("account :: " +account);
			}
			
		}
		

	}

}
