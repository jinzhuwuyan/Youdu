package com.isd.bean;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;


public class YouduFunctionBean {
	public static String GOAL = "goal";
	public static String CONDITION = "condition";
	String Attribute;
	Set<Entry<String, String[]>> Elements;
	public String getAttribute() {
		return Attribute;
	}
	public void setAttribute(String attribute) {
		Attribute = attribute;
	}
	public Set<Entry<String, String[]>> getElements() {
		return Elements;
	}
	public void setElements(Set<Entry<String, String[]>> elements) {
		Elements = elements;
	}
	
}
