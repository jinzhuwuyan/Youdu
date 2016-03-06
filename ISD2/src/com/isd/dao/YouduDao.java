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
 * ��ȡĿ���Ԫ���ܸ���
 * @return int
 */
	public int Get_EGElements_Size()
	{
		return EG_belief.size();
	};
	/**
	 * ��ȡ������Ԫ���ܸ���
	 * @return int
	 */
	public int Get_ECElements_Size()
	{
		return EC_belief.size();
	};
	/**
	 * ��ȡ���е�Ŀ���Ԫ������
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
	 * ��ȡ���е�������Ԫ������
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
	 * ��ȡĿ���Ԫ�����Լ���
	 * @param EG_Name
	 * @return �ض�Ŀ���Ԫ�����Լ���
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
	 * ��ȡĿ���Ԫ���ض����Ե�ֵ
	 * @param EG_Name 		Ŀ���Ԫ��
	 * @param ElementsName	������
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
	 * ��ȡ������Ԫ�����Լ���
	 * @param EC_Name
	 * @return �ض�������Ԫ�����Լ���
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
	 * ��ȡ������Ԫ���ض����Ե�ֵ
	 * @param EC_Name 		������Ԫ��
	 * @param ElementsName	������
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
