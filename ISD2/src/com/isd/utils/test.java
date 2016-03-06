package com.isd.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

import com.isd.bean.YouduBean;
import com.isd.youdu.GetInfomation;
public class test {
	/**
	 * ��ʾ��Ԫ��Ϣ
	 * @author shamaowei
	 * @return void 
	 * @param elementset
	 */
	public static void ShowInformation(Set<Entry<String, String[]>>  elementset){
		for(Entry<String, String[]> element : elementset)
		{
			System.out.println("��Ԫ��������" + element.getKey()
					+ "    ��Ԫ����ֵ��"
					+ element.getValue()[0] 
					+ "    ��Ԫ�������ͣ�"
					+ element.getValue()[1]);
		}
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
	
	@Test
	public void test() {
		this.Get_EG_ElementsValue("elephant", "age");
		this.Get_EG_ElementsValue("elephant", "height");
		this.Get_EG_ElementsValue("elephant", "heavy");

	}
	
}
