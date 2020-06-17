package com.briup.client;

import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.util.WossModuleInit;

/*
 * 客户端
 * 与服务器端通信，传递数据
 */
public interface Client extends WossModuleInit{
   public void send(Collection<Environment> coll) throws Exception;
}
