package com.briup.util;

/*
 * 日志模块
 */
public interface Log extends WossModuleInit {
	// 记录Debug级别的日志
	public void debug(String message);

	//记录Info级别的日志
	public void info(String message);

	//记录Warn级别的日志
	public void warn(String message);

	//记录Error级别的日志
	public void error(String message);

	//记录Fatal级别的日志
	public void fatal(String message);
}
