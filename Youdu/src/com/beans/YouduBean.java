package com.beans;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class YouduBean {
	public static String GOAL = "goal";
	public static String CONDITION = "condition";
	String BeanName;
	String Attribute;//���ڱ�ʾ����Ŀ���Ԫ(YouduBean.GOAL)����������Ԫ(YouduBean.CONDITION)
	HashMap<String, String[]> Elements;
	//һϵ��Bean������,string[0]Ϊ����kֵ��string[1]ΪȨֵ
	String YouduValue;//���ڴ洢�Ŷ�ֵ
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
