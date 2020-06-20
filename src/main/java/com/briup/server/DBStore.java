package com.briup.server;

import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.util.WossModuleInit;

/*
 * 入库模块
 * 提供入库规范，将数据存储到数据库中
 */
public interface DBStore extends WossModuleInit{
   public void saveDb(Collection<Environment> coll) throws Exception;
}
