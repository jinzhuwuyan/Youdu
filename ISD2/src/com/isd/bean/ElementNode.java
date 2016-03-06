package com.isd.bean;

import java.util.HashMap;

public class ElementNode {
	private ElementBean info;

	private HashMap<String, ElementNode> childNodes = null;

	public ElementNode(ElementBean eb) {
		this.info = eb;
		childNodes = new HashMap<String, ElementNode>();
	}

	public ElementNode(BeliefBean eb) {
		this.info = new ElementBean(eb.getUuid(), eb.getName(), eb.getCandV(),
				eb.getPrecursorName(), eb.getPrecursorId(), eb.getHostId());
		childNodes = new HashMap<String, ElementNode>();
	}

	/**
	 * �������ֵõ�ĳһ���ӽڵ�
	 * 
	 * @param name
	 * @return
	 */
	public ElementNode getChild(String name) {
		if (childNodes.containsKey(name)) {
			return childNodes.get(name);
		} else
			return null;
	}

	/**
	 * ���һ���ӽڵ�
	 * 
	 * @param eb
	 */
	public void addChild(ElementNode eb) {
		childNodes.put(eb.getInfo().getName(), eb);
	}

	/**
	 * �����ӽڵ�
	 * 
	 * @param eb
	 */
	public void updateChild(ElementBean eb) {
		if (childNodes.containsKey(eb.getName())) {
			childNodes.remove(eb.getName());
			childNodes.put(eb.getName(), new ElementNode(eb));
		}
	}

	/**
	 * ɾ���ӽڵ�
	 * 
	 * @param eb
	 */
	public void deleteChild(String name) {
		if (childNodes.containsKey(name)) {
			childNodes.remove(name);
		}
	}

	/**
	 * �ж��Ƿ����ӽڵ�
	 * 
	 * @return
	 */
	public boolean containsChild() {
		if (null == childNodes || childNodes.isEmpty()) {
			return false;
		} else
			return true;
	}

	public ElementBean getInfo() {
		return info;
	}

	public void setInfo(ElementBean info) {
		this.info = info;
	}

	public HashMap<String, ElementNode> getChildNodes() {
		return childNodes;
	}

	public void setEnm(HashMap<String, ElementNode> enm) {
		this.childNodes = enm;
	}

}
