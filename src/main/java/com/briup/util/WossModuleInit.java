package com.briup.util;

import java.util.Properties;

/*
 * 将所需要的配置文件信息传递给该类，得到之后进行初始化操作
 * 在执行真正的子类功能方法之前执行该方法
 */
public interface WossModuleInit {
  public void init(Properties properties) throws Exception;
}
