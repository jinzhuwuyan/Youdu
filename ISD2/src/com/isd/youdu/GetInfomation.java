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
	
	
	
	public static void main(String[] args) {
		

		GetInfomation information = new GetInfomation();
		/**
		* @author shamaowei
		* @Desciption 获取所有目标基元
		*/
		//得到目标基元
				
				System.out.println("目标基元个数"+information.Get_EGElements_Size());
				System.out.println("分别为：");
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
* @Desciption 获取所有条件基元
*/
		//得到条件基元
	System.out.println("条件基元个数"+information.Get_ECElements_Size());
	System.out.println("分别为：");
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

