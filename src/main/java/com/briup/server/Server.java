package com.briup.server;

import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.util.WossModuleInit;

/*
 * 服务器端
 * 和客户端交互，接受客户端传送的数据
 */
public interface Server extends WossModuleInit{
     public Collection<Environment> reciver() throws Exception;
     //关闭资源
     public void shutdown();
}
