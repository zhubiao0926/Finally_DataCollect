package com.briup.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.briup.client.Client;
import com.briup.client.Gather;
import com.briup.server.DBStore;
import com.briup.server.Server;

public class ConfigurationImpl implements Configuration{
	//存储解析以及反射的实例化对象
   private Map<String, WossModuleInit> map=new HashMap<String, WossModuleInit>();
   private Properties properties=new Properties();//存储三级标签及文本内容
    public ConfigurationImpl() {
	this("src/main/java/config.xml");
   }
    public ConfigurationImpl(String path) {
    	try {
			//1.获取解析对象,解析配置文件
			SAXReader reader=new SAXReader();
			//2.解析xml文件，将XML文件以document文档树形式加载到内存中
			Document document = reader.read(path);
			//3.获取根节点
			Element root = document.getRootElement();
			//4.获取所有的二级标签
			List<Element> elements= root.elements();
			//5.遍历集合获取属性值
			for (Element e : elements) {
				//获取属性节点的属性值
				 String value = e.attributeValue("class"); 
				 //6.获取镜像所对应的实例对象
				 Object newInstance = Class.forName(value).newInstance();
				 //7.map中存放对象
				 if(newInstance instanceof WossModuleInit) {
					map.put(e.getName(),(WossModuleInit)newInstance);
				 }
				 //8.读取三级标签，获取文本内容
				 List<Element> elements2=e.elements();
				 for (Element e2 : elements2) {
					 properties.setProperty(e2.getName(), e2.getTextTrim());
				}
				 ((WossModuleInit)newInstance).init(properties);
			}
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	public Log getLogger() throws Exception {
		return (Log) map.get("Log");
	}

	public Server getServer() throws Exception {
		return (Server) map.get("Server");
	}

	public Client getClient() throws Exception {
		return (Client) map.get("Client");
	}

	public DBStore getDbStore() throws Exception {
		return (DBStore) map.get("DBStore");
	}

	public Gather getGather() throws Exception {
		return (Gather) map.get("Gather");
	}

}
