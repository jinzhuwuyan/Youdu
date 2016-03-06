package com.isd.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

import com.isd.bean.YouduBean;
import com.isd.youdu.GetInfomation;
public class test {
	/**
	 * 显示基元信息
	 * @author shamaowei
	 * @return void 
	 * @param elementset
	 */
	public static void ShowInformation(Set<Entry<String, String[]>>  elementset){
		for(Entry<String, String[]> element : elementset)
		{
			System.out.println("基元属性名：" + element.getKey()
					+ "    基元属性值："
					+ element.getValue()[0] 
					+ "    基元属性类型："
					+ element.getValue()[1]);
		}
	}
	/**
	 * 获取目标基元的属性集合
	 * @param EG_Name
	 * @return 特定目标基元的属性集合
	 */
	public Set<Entry<String, String[]>> Get_EG_Elements(String EG_Name){
		Iterator EG = new GetInfomation().GetEGBean().iterator();
		while(EG.hasNext())
		{
			YouduBean beliefs = (YouduBean)EG.next();
			if(EG_Name.equals
					(
					beliefs.getBeanName()
					))
				return beliefs.getElements();
		}
		return null;
	}
	/**
	 * 获取条件基元的属性集合
	 * @param EC_Name
	 * @return 特定条件基元的属性集合
	 */
	public Set<Entry<String, String[]>> Get_EC_Elements(String EC_Name){
		Iterator EC = new GetInfomation().GetECBean().iterator();
		while(EC.hasNext())
		{
			YouduBean beliefs = (YouduBean)EC.next();
			if(EC_Name.equals
					(
					beliefs.getBeanName()
					))
				return beliefs.getElements();
		}
		return null;
	}
	
	

	/**
	 * 获取目标基元中特定属性的值
	 * @param EG_Name 		目标基元名
	 * @param ElementsName	属性名
	 * @return 				double
	 */
	public double Get_EG_ElementsValue(String EG_Name,String ElementsName){
		Set<Entry<String, String[]>> EGsets = this.Get_EG_Elements(EG_Name);
		for(Entry<String, String[]> EGset : EGsets)
		{
			if(EGset.getKey().equals(ElementsName))
			{
				System.out.println("ElementsName "+EGset.getKey()
								+  "ElementsValue"+EGset.getValue()[0]);
				return Double.valueOf(EGset.getValue()[0]);
			}
		}
		return 0;
	}
	
	@Test
	public void test() {
		this.Get_EG_ElementsValue("elephant", "age");
		this.Get_EG_ElementsValue("elephant", "height");
		this.Get_EG_ElementsValue("elephant", "heavy");

	}
	
}
