package com.briup.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Properties;

import com.briup.bean.Environment;
import com.briup.util.ConnectionFactory;
import com.briup.util.Log;
import com.briup.util.LogImpl;

public class DBStoreImpl implements DBStore{
   private Connection connection;
   private PreparedStatement ps;
   private int batchSize;
   private static Log log=new LogImpl();
   public void init(Properties properties) throws Exception {
	   batchSize=Integer.parseInt(properties.getProperty("batchSize"));
	}
	public void saveDb(Collection<Environment> coll) throws Exception {
		try {
			log.info("开始连接数据库");
			connection=ConnectionFactory.getConnection();
			log.info("数据库连接成功"+connection+",开始入库");
			int preDay=0;//用来记录上一次插入的表日期(天数)
			int count=0;//缓存的计数
			for (Environment environment : coll) {
				//获取一个日历实例
				Calendar c = Calendar.getInstance(); 
				c.setTime(environment.getGatherDate());
				//将给定的日期按照指定要求转为指定格式
				int day = c.get(Calendar.DAY_OF_MONTH);//此格式为一个月的第几天
				if(day!=preDay) {
					//当前插入的表和上一次插入的表不一致
					//需要先将之前上一张表未达到缓存次数的数据插入数据库，完成批处理
					//?
					if(ps!=null) {
						ps.executeBatch();//在关闭上一个表的对应的ps对象之前需要将上一个ps对象中缓存的数据插入数据库
						ps.close();//关闭ps对象资源
					}
					//将上一次的插入天数改为当前天数
					preDay=day;
					//将缓存次数清0
					count=0;
					String sql="insert into e_detail_"+day+" values(?,?,?,?,?,?,?,?,?)";
					ps=connection.prepareStatement(sql);
				}
				ps.setString(1, environment.getName()); 
				ps.setString(2, environment.getSendId());
				ps.setString(3, environment.getSmId());
				ps.setString(4, environment.getAddress());
				ps.setInt(5, environment.getCount());
				ps.setString(6, environment.getOrdernumber());
				ps.setInt(7, environment.getStatus());
				ps.setFloat(8, environment.getData());
				ps.setTimestamp(9, environment.getGatherDate()); 
				ps.addBatch();
				count++;
				if(count%batchSize==0) {
					ps.executeBatch();
					ps.clearBatch();
				}
				
			}
			//将剩余的缓存数据插入数据库中
			if(count!=0||count%batchSize!=0){
				ps.executeBatch();
			}
			ps.close();
			connection.commit();//提交事务
			log.info("数据入库成功");
		} catch (Exception e) {
			log.info("数据入库失败");
			connection.rollback();//回滚事务
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
	}
	

}
