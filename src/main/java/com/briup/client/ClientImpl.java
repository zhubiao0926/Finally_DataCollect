package com.briup.client;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

import com.briup.bean.Environment;
import com.briup.util.Log;
import com.briup.util.LogImpl;

public class ClientImpl implements Client{
	private static Log log=new LogImpl();
	private String ip;
	private int port;

	public void init(Properties properties) throws Exception {
		ip=properties.getProperty("ip");
		port=Integer.parseInt(properties.getProperty("port"));
		
	}
    //将采集的数据发送给服务器端
	public void send(Collection<Environment> coll) throws Exception {
		log.info("客户端开始发送数据");
		Socket socket=new Socket(ip, port);
		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(os);
		oos.writeObject(coll);
		oos.flush();
		log.info("客户端发送结束，数据传输成功"); 
	}
	/*
	 * public static void main(String[] args) { try { Gather gather=new
	 * GatherImpl(); Collection<Environment> list = gather.gather(); Client
	 * client=new ClientImpl(); client.send(list); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
	
}
