package com.briup.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogImpl implements Log {
	private static Logger logger;

	public LogImpl() {
        logger=Logger.getRootLogger();
        PropertyConfigurator.configure("src/main/java/log4j.properties");
	}

	@Override
	public void debug(String message) {
		logger.debug(message);

	}

	@Override
	public void info(String message) {
		logger.info(message);

	}

	@Override
	public void warn(String message) {
		logger.warn(message);

	}

	@Override
	public void error(String message) {
		logger.error(message);

	}

	@Override
	public void fatal(String message) {
		logger.fatal(message);

	}

}
