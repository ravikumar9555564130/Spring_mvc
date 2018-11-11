package com.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = { "com.aop" })
@EntityScan(basePackages = { "com.aop" })
@EnableJpaRepositories("com.aop")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringWebApplication {

	private final static Logger logger = LoggerFactory.getLogger(SpringWebApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication
				.run(SpringWebApplication.class, args);

		logger.info("configurableApplicationContext :: " + configurableApplicationContext);

		AcountDAO acountDAO = configurableApplicationContext.getBean(AcountDAO.class);
		Account account = new Account(1, "ravi kumar", 100);
		acountDAO.addAccount(account);

		AcountDAO2 acountDAO2 = configurableApplicationContext.getBean(AcountDAO2.class);
		acountDAO2.addAccount();

	}

}
