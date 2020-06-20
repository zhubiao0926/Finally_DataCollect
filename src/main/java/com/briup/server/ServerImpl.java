package com.briup.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

import com.briup.bean.Environment;
import com.briup.util.Log;
import com.briup.util.LogImpl;

public class ServerImpl implements Server {
	private int port;
	private ServerSocket ss;
	private Socket socket;
	private InputStream is;
	private ObjectInputStream ois;
    private static Log log=new LogImpl();
    public void init(Properties properties) throws Exception {
		port=Integer.parseInt(properties.getProperty("port")); 
		
	}
	public Collection<Environment> reciver() throws Exception {
		log.info("服务器端开启接受数据");
		ss=new ServerSocket(port);
		socket=ss.accept();
		is=socket.getInputStream();
		ois=new ObjectInputStream(is);
		Collection<Environment> coll=(Collection<Environment>) ois.readObject();
		//关闭资源
		shutdown();
		log.info("服务器端已经接收完数据!"); 
		return coll;
	}

	public void shutdown() {
       try {
		if(ois!=null)
			   ois.close();
		if(is!=null)
			   is.close();
		if(ss!=null)
			ss.close();
	} catch (IOException e) {
		log.error("关闭资源失败"); 
		e.printStackTrace();
	}
	}
	/*
	 * public static void main(String[] args) { try { Server server=new
	 * ServerImpl(); Collection<Environment> list = server.reciver();
	 * System.out.println(list.size()); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

	
}
