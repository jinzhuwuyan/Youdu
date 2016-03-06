package com.isd.bean;

import java.util.HashMap;
import java.util.UUID;

public class ElementBean {
	private Integer id;
	private String uuid;
	private String name;
	private HashMap<String, String[]> CandV = new HashMap<String, String[]>();
	private String precursorId;
	private String precursorName;
	private int hostId;

	public ElementBean() {
		uuid = UUID.randomUUID().toString().replace("-", "");
	}

	public ElementBean(int hostId) {
		super();
		this.hostId = hostId;
	}

	public ElementBean(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ElementBean(String name, int hostId) {
		super();
		this.name = name;
		this.hostId = hostId;
	}

	public ElementBean(String name, HashMap<String, String[]> candV) {
		super();
		this.name = name;
		CandV = candV;
	}

	/**
	 * 
	 * @param name
	 * @param CandV
	 *            HashMap<String, String[]>,��һ������������,�ڶ��������ĵ�һ��Ԫ������ֵ���ڶ���Ԫ��ֵ����
	 * @param hostId
	 */
	public ElementBean(String uuid, String name,
			HashMap<String, String[]> CandV, String precursorName,
			String precursorId, int hostId) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.CandV = CandV;
		this.hostId = hostId;
		this.precursorId = precursorId;
		this.precursorName = precursorName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setPrecursorId(String precursorId) {
		this.precursorId = precursorId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHostId() {
		return hostId;
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
