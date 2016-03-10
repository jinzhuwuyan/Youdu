package com.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.junit.Test;

import com.beans.YouduBean;
import com.daos.YouduFunctionDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class JosnTest {
public ArrayList<YouduBean> getArrayList(){
	YouduBean  bean1 = new YouduBean();
	bean1.setBeanName("yan");
	bean1.setAttribute(YouduBean.CONDITION);
	/**
	 * 1
	 */
	HashMap<String,String[]> map1 = new HashMap<String,String[]>();
	Vector<String>	s1 = new Vector<String>();
	s1.add(0, "1.6");//kֵ
	s1.add(1, "0.5");//Ȩ��
	String[] ss1 = s1.toArray(new String[s1.size()]);
	map1.put("s1", ss1);
	
	/**
	 * 2
	 */
	Vector<String>	s2 = new Vector<String>();
	s2.add(0, "0.2");//kֵ
	s2.add(1, "0.5");//Ȩ��
	String[] ss2 = s2.toArray(new String[s2.size()]);
	map1.put("s2", ss2);
//	Set<Entry<String,String[]>> entry1 = map1.entrySet();
	
	bean1.setElements(map1);
	new YouduFunctionDao().setYouduBeanValue(bean1);
	/**
	 * 3
	 */
	HashMap<String,String[]> map2 = new HashMap<String,String[]>();
	YouduBean  bean2 = new YouduBean();
	bean2.setBeanName("si");
	bean2.setAttribute(YouduBean.CONDITION);
	Vector<String>	s3 = new Vector<String>();
	s3.add(0, "-0.5");//kֵ
	s3.add(1, "0.5");//Ȩ��
	String[] ss3 = s3.toArray(new String[s3.size()]);
	map2.put("jinzhu", ss3);
	/**
	 * 4
	 */
	Vector<String>	s4 = new Vector<String>();
	s4.add(0, "2.0");//kֵ
	s4.add(1, "0.5");//Ȩ��
	String[] ss4 = s4.toArray(new String[s4.size()]);
	map2.put("wuyan", ss4);
//	Set<Entry<String,String[]>> entry2 = map2.entrySet();
	bean2.setElements(map2);
	new YouduFunctionDao().setYouduBeanValue(bean2);
	//------------------------------------------------------------------//
	
	ArrayList<YouduBean> list = new ArrayList<YouduBean>();
	
	list.add(bean1);
	list.add(bean2);
	return list;
}
//@Test
/**
 * ��test����gsonתjson�ַ����Ƿ�֧��map.entry()����������Set<Entry<String,String[]>>
 * ֤����û�취���ʽ�YouduBean��Elements����������ת��Ϊ�򵥵�HashMap
 */
public void test1(){
	Map<String,String[]> map1 = new HashMap<String,String[]>();
	Vector<String>	s1 = new Vector<String>();
	s1.add(0, "1.6");//kֵ
	s1.add(1, "0.5");//Ȩ��
	String[] ss1 = s1.toArray(new String[s1.size()]);
	map1.put("s1", ss1);
	
	/**
	 * 2
	 */
	Vector<String>	s2 = new Vector<String>();
	s2.add(0, "0.2");//kֵ
	s2.add(1, "0.5");//Ȩ��
	String[] ss2 = s2.toArray(new String[s2.size()]);
	map1.put("s2", ss2);
	Gson gg = new Gson();
	String ss = gg.toJson(map1);
	System.out.println(ss);
}
@Test
/**
 * ����beanת��Ϊjsonstring���ʹ�jsonstringת����bean
 * ע�⣬ת����json���ͱ�����json��֧�ֵ����ͣ�����Set<Entry<String,String[]>>��֧��
 * ����HashMap<String,String[]>֧��
 */
	public void test() {

		List<YouduBean> Youdulist = new YouduFunctionDao().getYouduBeanList(this.getArrayList());
		Gson gson = new Gson();
		String s = gson.toJson(Youdulist);
		System.out.println(s);

		List<YouduBean> beans = gson.fromJson(s, new TypeToken<List<YouduBean>>(){}.getType());
		
//		for(int i = 0; i < beans.size(); i++ )
//		{
//			
//			YouduBean bean = beans.get(i);
//			System.out.println("--------------------------------");
//			System.out.println(bean.getBeanName());
//			System.out.println(bean.getYouduValue());
//			System.out.println("*************************************");
//		}
		
		for(int i = 0; i < beans.size(); i++ )
		{
			for(Entry<String, String[]> entry : beans.get(i).getElements().entrySet())
				{
					System.out.println("Element Name ");
					System.out.println(entry.getKey());
					System.out.println("kֵ");
					System.out.println(entry.getValue()[0]);
					System.out.println("�Ŷ�ֵ");
					System.out.println(entry.getValue()[1]);
				}
		
		}	

		
		
	}

}
