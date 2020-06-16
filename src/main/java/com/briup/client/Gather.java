package com.briup.client;

import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.util.WossModuleInit;
/*
 * Gather接口规定了采集模块所应实现的方法
 * 针对智能家居信息采集，将采集的信息封装为一个Environment对象的集合返回
 */
public interface Gather extends WossModuleInit{
   public Collection<Environment> gather() throws Exception;
}
