package com.isd.bean;

import java.util.HashMap;

public class BeliefBean {

	private Integer id;
	private String uuid;
	private String name;
	private HashMap<String, String[]> CandV = new HashMap<String, String[]>();
	private String precursorId;
	private String precursorName;
	private int hostId;

	public BeliefBean() {
		// TODO Auto-generated constructor stub
	}

	public BeliefBean(int hostId) {
		super();
		this.hostId = hostId;
	}

	public BeliefBean(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public BeliefBean(String name, int hostId) {
		super();
		this.name = name;
		this.hostId = hostId;
	}

	public BeliefBean(String name, HashMap<String, String[]> candV) {
		super();
		this.name = name;
		CandV = candV;
	}

	/**
	 * 
	 * @param name
	 * @param CandV
	 *            HashMap<String, String[]>,第一个参数属性名,第二个参数的第一个元素属性值，第二个元素值类型
	 * @param hostId
	 */
	public BeliefBean(int id, String uuid, String name,
			HashMap<String, String[]> CandV, String precursorName,
			String precursorId, int hostId) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.CandV = CandV;
		this.hostId = hostId;
		this.precursorId = precursorId;
		this.precursorName = precursorName;
	}

	public HashMap<String, String[]> getCandV() {
		return CandV;
	}

	public void setCandV(HashMap<String, String[]> CandV) {
		this.CandV = CandV;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrecursorId() {
		return precursorId;
	}

	public void setPrecursorId(String precursor) {
		this.precursorId = precursor.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHostId() {
		return hostId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public String getPrecursorName() {
		return precursorName;
	}

	public void setPrecursorName(String precursorName) {
		this.precursorName = precursorName;
	}

	public void setPrecursorNameAndId(String precursorName, String precursorId) {
		this.precursorName = precursorName;
		this.precursorId = precursorId;
	}

}
