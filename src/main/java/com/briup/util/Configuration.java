package com.briup.util;
/*
 * 配置类
 */

import com.briup.client.Client;
import com.briup.client.Gather;
import com.briup.server.DBStore;
import com.briup.server.Server;

public interface Configuration {
  //获取日志模块的实例
  public Log getLogger() throws Exception;
  //获取服务器模块实例
  public Server getServer() throws Exception;
  //获取客户端模块实例
  public Client getClient() throws Exception;
  //获取入库模块实例
  public DBStore getDbStore() throws Exception;
  //获取采集模块实例
  public Gather getGather() throws Exception;
}
