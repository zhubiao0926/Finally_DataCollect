package com.briup.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
  private static String driver;
  private static String url;
  private static String username;
  private static String password;
  private static Connection connection;
  private static Properties properties=new Properties();
   static {
	   //加载需要解析的配置文件
	   try {
		   File file=new File("src/main/java/jdbc.properties");
		   FileInputStream fis=new FileInputStream(file);
		   properties.load(fis);
		   driver=properties.getProperty("driver");
		   url=properties.getProperty("url");
		   username=properties.getProperty("username");
		   password=properties.getProperty("password");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   public static Connection getConnection() {
	   try {
		   //加载驱动
		Class.forName(driver);
		//获取连接对象
		connection=DriverManager.getConnection(url, username, password);
		System.out.println(connection);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return connection; 
   }
   public static void main(String[] args) {
	getConnection();
}
}
