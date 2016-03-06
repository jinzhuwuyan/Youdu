package com.isd.youdu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.isd.bean.YouduBean;
import com.isd.dao.YouduDao;

public class GetInfomation extends YouduDao{
	public GetInfomation(){
		super();
	}
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
	
	
	
	public static void main(String[] args) {
		

		GetInfomation information = new GetInfomation();
		/**
		* @author shamaowei
		* @Desciption ��ȡ����Ŀ���Ԫ
		*/
		//�õ�Ŀ���Ԫ
				
				System.out.println("Ŀ���Ԫ����"+information.Get_EGElements_Size());
				System.out.println("�ֱ�Ϊ��");
				Iterator EG = information.GetEGBean().iterator();
				
				while(EG.hasNext())
				{
					YouduBean belief = (YouduBean)EG.next();
					System.out.println("-----"+belief.getBeanName()+"-----");
					Set<Entry<String, String[]>>  elementset = belief.getElements();
					ShowInformation(elementset);
				}
				
/**
* @author shamaowei
* @Desciption ��ȡ����������Ԫ
*/
		//�õ�������Ԫ
	System.out.println("������Ԫ����"+information.Get_ECElements_Size());
	System.out.println("�ֱ�Ϊ��");
	Iterator EC = information.GetECBean().iterator();
	
	while(EC.hasNext())
	{
		YouduBean beliefs = (YouduBean)EC.next();
		System.out.println("-----"+beliefs.getBeanName()+"-----");
		Set<Entry<String, String[]>>  elementset = beliefs.getElements();
		ShowInformation(elementset);
		}
	}
	
	

}

