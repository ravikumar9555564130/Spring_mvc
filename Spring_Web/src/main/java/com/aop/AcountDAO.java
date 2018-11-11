package com.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AcountDAO {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public void addAccount(Account account) {

		logger.info("here my DB work in  in AcountDAO :: addAccount");

	}

}
