package com.abead.model;

import java.util.Date;

public class LoginLog {
    private int id;
    private String ip;
    private String lastAddress;
    private String lastDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLastAddress() {
		return lastAddress;
	}
	public void setLastAddress(String lastAddress) {
		this.lastAddress = lastAddress;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
}
