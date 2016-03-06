package com.isd.bean;

public class AgentBean {
	Integer id;
	String name;
	Integer hostId;

	public AgentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgentBean(String name, Integer hostId) {
		super();
		this.name = name;
		this.hostId = hostId;
	}

	public AgentBean(Integer id, String name, Integer hostId) {
		super();
		this.id = id;
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
