package com.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import com.beans.YouduBean;
import com.daos.YouduFunctionDao;

public class YouduFunctionTest {
	/**
	 * 测试数据
	 * @return ArrayList
	 */
	public static ArrayList<YouduBean> getArrayList(){
		YouduBean  bean1 = new YouduBean();
		bean1.setBeanName("yan");
		bean1.setAttribute(YouduBean.CONDITION);
		/**
		 * 1
		 */
		HashMap<String,String[]> map1 = new HashMap<String,String[]>();
		Vector<String>	s1 = new Vector<String>();
		s1.add(0, "1.6");//k值
		s1.add(1, "0.5");//权重
		String[] ss1 = s1.toArray(new String[s1.size()]);
		map1.put("s1", ss1);
		
		/**
		 * 2
		 */
		Vector<String>	s2 = new Vector<String>();
		s2.add(0, "0.2");//k值
		s2.add(1, "0.5");//权重
		String[] ss2 = s2.toArray(new String[s2.size()]);
		map1.put("s2", ss2);
//		Set<Entry<String,String[]>> entry1 = map1.entrySet();
		
		bean1.setElements(map1);
		//设置优度值
//		new YouduFunctionDao().setYouduBeanValue(bean1);
		bean1.setYouduValue("-100");
		/**
		 * 3
		 */
		HashMap<String,String[]> map2 = new HashMap<String,String[]>();
		YouduBean  bean2 = new YouduBean();
		bean2.setBeanName("si");
		bean2.setAttribute(YouduBean.CONDITION);
		Vector<String>	s3 = new Vector<String>();
		s3.add(0, "-0.5");//k值
		s3.add(1, "0.5");//权重
		String[] ss3 = s3.toArray(new String[s3.size()]);
		map2.put("jinzhu", ss3);
		/**
		 * 4
		 */
		Vector<String>	s4 = new Vector<String>();
		s4.add(0, "2.0");//k值
		s4.add(1, "0.5");//权重
		String[] ss4 = s4.toArray(new String[s4.size()]);
		map2.put("wuyan", ss4);
//		Set<Entry<String,String[]>> entry2 = map2.entrySet();
		bean2.setElements(map2);
		//设置优度值
//		new YouduFunctionDao().setYouduBeanValue(bean2);
		bean2.setYouduValue("-100");
		//------------------------------------------------------------------//
		
		ArrayList<YouduBean> list = new ArrayList<YouduBean>();
		
		list.add(bean1);
		list.add(bean2);
		return list;
	}
public static void main(String[] args) {
	ArrayList<YouduBean> beans = getArrayList();
	YouduFunctionDao dao = new YouduFunctionDao();
	System.out.println(
			dao.YouduFunction(
			dao.transform(
			beans)));
}
}
