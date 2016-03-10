package com.action;

import java.util.Map;

import com.daos.YouduFunctionDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class YouduAction extends ActionSupport{
	private String jsonString;

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		ActionContext ac= ActionContext.getContext(); //获得ActionContext对象

		String YouduString = new YouduFunctionDao().YouduFunction(getJsonString());	
//		String YouduString = new YouduFunctionDao().YouduFunction((String) ac.get("YouduString"));	

		ac.put("YouduString", YouduString);
		
		return "success";
	}
}
