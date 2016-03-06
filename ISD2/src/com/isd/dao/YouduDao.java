package com.isd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.isd.bean.BeliefBean;
import com.isd.bean.YouduBean;
import com.isd.servise.ElementServise;
import com.isd.youdu.GetInfomation;

public class YouduDao {
	
	ElementServise servise = new ElementServise();
	//EG equals to Elementgoal
	//EC equals to Elementcondition
	
	
	ArrayList<BeliefBean> EG_belief = servise.getAllEG();
	ArrayList<BeliefBean> EC_belief = servise.getAllEC();
	ArrayList<YouduBean> EGBeans = new ArrayList<YouduBean>();
	ArrayList<YouduBean> ECBeans = new ArrayList<YouduBean>();
/**
 * 获取目标基元的总个数
 * @return int
 */
	public int Get_EGElements_Size()
	{
		return EG_belief.size();
	};
	/**
	 * 获取条件基元的总个数
	 * @return int
	 */
	public int Get_ECElements_Size()
	{
		return EC_belief.size();
	};
	/**
	 * 获取所有的目标基元及属性
	 * @return ArrayList<YouduBean>
	 */
	public ArrayList<YouduBean> GetEGBean(){
		for(BeliefBean belief : EG_belief)
		{
			YouduBean bean = new YouduBean();
			bean.setBeanName(belief.getName());
			HashMap<String, String[]> ElementSet = belief.getCandV();
			bean.setElements(ElementSet.entrySet());
			bean.setAttribute(YouduBean.GOAL);
			EGBeans.add(bean);
		}
		return EGBeans;
	}
	/**
	 * 获取所有的条件基元及属性
	 * @return ArrayList<YouduBean>
	 */
	public ArrayList<YouduBean> GetECBean(){
		for(BeliefBean belief : EC_belief)
		{
			YouduBean bean = new YouduBean();
			bean.setBeanName(belief.getName());
			HashMap<String, String[]> ElementSet = belief.getCandV();
			bean.setElements(ElementSet.entrySet());
			bean.setAttribute(YouduBean.CONDITION);
			ECBeans.add(bean);
		}
		return ECBeans;
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
	 * 获取条件基元中特定属性的值
	 * @param EC_Name 		条件基元名
	 * @param ElementsName	属性名
	 * @return 				double
	 */
	public double Get_EC_ElementsValue(String EC_Name,String ElementsName){
		Set<Entry<String, String[]>> ECsets = this.Get_EG_Elements(EC_Name);
		for(Entry<String, String[]> ECset : ECsets)
		{
			if(ECset.getKey().equals(ElementsName))
			{
				System.out.println("ElementsName "+ECset.getKey()
								+"\n"
								+"ElementsValue"
								+ECset.getValue()[0]);
				return Double.valueOf(ECset.getValue()[0]);
			}
		}
		
		return 0;
	}
}
