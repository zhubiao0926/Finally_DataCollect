package com.briup.util;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogImpl implements Log {
	private static Logger logger;
	public void init(Properties properties) throws Exception {
		logger=Logger.getRootLogger();
        PropertyConfigurator.configure(properties.getProperty("log4j-properties"));
	}
	public void debug(String message) {
		logger.debug(message);

	}

	public void info(String message) {
		logger.info(message);

	}

	public void warn(String message) {
		logger.warn(message);

	}

	public void error(String message) {
		logger.error(message);

	}

	public void fatal(String message) {
		logger.fatal(message);

	}

	

}
