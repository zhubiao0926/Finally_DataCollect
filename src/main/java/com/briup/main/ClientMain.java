package com.briup.main;

import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.client.Client;
import com.briup.client.ClientImpl;
import com.briup.client.Gather;
import com.briup.client.GatherImpl;
import com.briup.util.ConfigurationImpl;

/*
 * 客户端主入口
 */
public class ClientMain {
	public static void main(String[] args) {
		/*
		 * try { Gather gather=new GatherImpl(); Collection<Environment> list =
		 * gather.gather(); Client client=new ClientImpl(); client.send(list); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		try {
			ConfigurationImpl ci = new ConfigurationImpl();
			Collection<Environment> list =ci.getGather().gather();
			ci.getClient().send(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
