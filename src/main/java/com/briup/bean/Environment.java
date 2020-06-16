package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/*
 * 信息类
 */
public class Environment implements Serializable{
	//环境种类名称
	private String name;
	//电脑端id
	private String sendId;
	//树莓派id
	private String smId;
	//板子模块id
	private String qmId;
    //传感器id
	private String address;
	//传感器个数
	private int count;
	//指令标号
	private String ordernumber;
	//状态
	private int status;
	//环境值
	private float data;
	//采集时间
	private Timestamp gatherDate;
	
	public Environment() {
		super();
	}


	public Environment(String name, String sendId, String smId, String qmId, String address, int count,
			String ordernumber, int status, float data, Timestamp gatherDate) {
		super();
		this.name = name;
		this.sendId = sendId;
		this.smId = smId;
		this.qmId = qmId;
		this.address = address;
		this.count = count;
		this.ordernumber = ordernumber;
		this.status = status;
		this.data = data;
		this.gatherDate = gatherDate;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getSmId() {
		return smId;
	}

	public void setSmId(String smId) {
		this.smId = smId;
	}

	public String getQmId() {
		return qmId;
	}

	public void setQmId(String qmId) {
		this.qmId = qmId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}

	public Timestamp getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Timestamp gatherDate) {
		this.gatherDate = gatherDate;
	}

	@Override
	public String toString() {
		return "Environment [name=" + name + ", sendId=" + sendId + ", smId=" + smId + ", qmId=" + qmId + ", address="
				+ address + ", count=" + count + ", ordernumber=" + ordernumber + ", status=" + status + ", data="
				+ data + ", gatherDate=" + gatherDate + "]";
	}
	
	

}
