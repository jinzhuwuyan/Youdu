package com.isd.bean;

public class UtilBean {
	String name;
	Integer hostId;

	public UtilBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UtilBean(String name, Integer hostId) {
		super();
		this.name = name;
		this.hostId = hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHostId() {
		return hostId;
	}

	public void setHostId(Integer hostId) {
		this.hostId = hostId;
	}

}
