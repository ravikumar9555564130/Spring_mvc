package com.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Propertieshandler {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	Environment env;

	public void readingPropertiesFile() {
		logger.info("readingPropertiesFile :: username ::" + env.getProperty("test.username"));
		logger.info("readingPropertiesFile :: username ::" + env.getProperty("test.password"));

	}
}
