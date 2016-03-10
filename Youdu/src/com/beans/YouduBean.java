package com.beans;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class YouduBean {
	public static String GOAL = "goal";
	public static String CONDITION = "condition";
	String BeanName;
	String Attribute;//用于表示其是目标基元(YouduBean.GOAL)还是条件基元(YouduBean.CONDITION)
	HashMap<String, String[]> Elements;
	//一系列Bean的属性,string[0]为属性k值，string[1]为权值
	String YouduValue;//用于存储优度值
	public String getYouduValue() {
		return YouduValue;
	}
	public void setYouduValue(String youduValue) {
		YouduValue = youduValue;
	}
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
	public HashMap<String, String[]> getElements() {
		return Elements;
	}
	public void setElements(HashMap<String, String[]> elements) {
		Elements = elements;
	}
//	public Set<Entry<String, String[]>> getElements() {
//		return Elements;
//	}
//	public void setElements(Set<Entry<String, String[]>> elements) {
//		Elements = elements;
//	}

}
