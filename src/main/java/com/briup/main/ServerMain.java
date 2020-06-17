package com.briup.main;

import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.server.Server;
import com.briup.server.ServerImpl;

/*
 * 服务器端入口
 */
public class ServerMain {
	public static void main(String[] args) {
		try {
			Server server=new ServerImpl();
			Collection<Environment> list = server.reciver();
			System.out.println(list.size());
			//完成入库功能
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
