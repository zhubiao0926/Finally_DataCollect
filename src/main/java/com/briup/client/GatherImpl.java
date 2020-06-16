package com.briup.client;

import java.io.RandomAccessFile;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.briup.bean.Environment;

public class GatherImpl implements Gather{
List<Environment> list=new ArrayList<Environment>();//存放环境数据
	@Override
	public Collection<Environment> gather() throws Exception {
		//1.选择合适的流
		//2.读取文件，进行解析
		   //2.1按照|分割
		   //2.2根据传感器id判断环境类型，16,256,1280
		   //2.3根据公式计算环境值
		   //注意：当判断为16时，要将温度湿度创建为两个Environment对象
		//将采集的数据放到集合中
		RandomAccessFile raf=new RandomAccessFile("src/main/java/radwtmp", "r");
		String str=null; 
		//记录温度和湿度条数
		int count1=0;
		//记录光照强度条数
		int count2=0;
		//记录二氧化碳条数
		int count3=0;
		Environment environment=null;
		String[] split=null;
		while ((str=raf.readLine())!=null) {
			environment=new Environment();//既可以为温度也可以代表关照强度或者二氧化碳
			 split= str.split("[|]");
			 environment.setSendId(split[0]);//电脑端id
			 environment.setSmId(split[1]);//树莓派id
			 environment.setQmId(split[2]);//板子模块id
			 environment.setAddress(split[3]);//传感器id
			 environment.setCount(Integer.parseInt(split[4]));//传感器个数
			 environment.setOrdernumber(split[5]);//指令标号
			 environment.setStatus(Integer.parseInt(split[7]));//状态
			  Long time=new Long(split[8]);
			  Timestamp gatherDate=new Timestamp(time);
			 environment.setGatherDate(gatherDate);//采集时间
			 
			 if ("16".equals(split[3])) {
				 //温度环境值
				 float data=(float)((Integer.valueOf(split[6].substring(0, 4), 16)*0.00268127)-46.85);
				environment.setData(data);
				environment.setName("温度"); 
				list.add(environment);
				//创建湿度对象
				environment=new Environment();
				 environment.setSendId(split[0]);//电脑端id
				 environment.setSmId(split[1]);//树莓派id
				 environment.setQmId(split[2]);//板子模块id
				 environment.setAddress(split[3]);//传感器id
				 environment.setCount(Integer.parseInt(split[4]));//传感器个数
				 environment.setOrdernumber(split[5]);//指令标号
				 environment.setStatus(Integer.parseInt(split[7]));//状态
				  Long time1=new Long(split[8]);
				  Timestamp gatherDate1=new Timestamp(time1);
				 environment.setGatherDate(gatherDate1);//采集时间
				 float data1=(float)((Integer.valueOf(split[6].substring(0, 4), 16)*0.00190735)-6);
				 environment.setData(data1);//湿度环境值
				 environment.setName("湿度");
				 list.add(environment);
				 count1++;
				
			}else{
				//公式
				//判断是光照强度还是二氧化碳浓度
				if("256".equals(split[3])) {
					
				}else {
					
				}
			}
		}
		return null;
	}

}
