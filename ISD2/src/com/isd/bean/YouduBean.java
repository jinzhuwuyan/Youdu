package com.isd.bean;

import java.util.Map.Entry;
import java.util.Set;

public class YouduBean {
	public static String GOAL = "goal";
	public static String CONDITION = "condition";
	String BeanName;
	String Attribute;
	Set<Entry<String, String[]>> Elements;
	public String getAttribute() {
		return Attribute;
	}
	public void setAttribute(String attribute) {
		Attribute = attribute;
	}

	public String getBeanName() {
		return BeanName;
	}
	public void setBeanName(String beanName) {
		BeanName = beanName;
	}
	public Set<Entry<String, String[]>> getElements() {
		return Elements;
	}
	public void setElements(Set<Entry<String, String[]>> elements) {
		Elements = elements;
	}
}
