package com.briup.main;

import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.server.DBStoreImpl;
import com.briup.server.Server;
import com.briup.server.ServerImpl;
import com.briup.util.ConfigurationImpl;

/*
 * 服务器端入口
 */
public class ServerMain {
	public static void main(String[] args) {
		/*
		 * try { Server server=new ServerImpl(); Collection<Environment> list =
		 * server.reciver(); //完成入库功能 new DBStoreImpl().saveDb(list); } catch (Exception
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		try {
			ConfigurationImpl ci = new ConfigurationImpl();
			Collection<Environment> coll = ci.getServer().reciver();
			ci.getDbStore().saveDb(coll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
