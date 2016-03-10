package com.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.beans.YouduBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class YouduFunctionDao {
	/**
	 * 简单优度评价函数求均值
	 * 要求优度评价只根据目标基元的属性来评价条件基元的值，
	 * 即使条件基元(ConditionBean)中有属性是目标基元(GoalBean)没有的，也不对其属性进行评价
	 * @param ConditionBean 条件基元的Bean
	 * @param GoalBean 目标基元的Bean
	 * @return boolean 只返回好和坏
	 * @exception 当优度评价的目标基元没有属性时，直接返回false,
	 * 			    当优度评价的目标基元和条件基元的属性都没有相同时，直接返回false
	 */
	public boolean SimpleYouduFunction(YouduBean ConditionBean, YouduBean GoalBean){
		double GoalSum = 0;//需要被比较的基元
		double ConditionSum = 0;
		int size = 1;

		HashMap<String,String[]> conditionsets = ConditionBean.getElements();
		HashMap<String,String[]> goalsets = GoalBean.getElements();
		if(GoalBean.getElements().size() > 0)
			for(Entry<String, String[]> goalset : goalsets.entrySet())
				for(Entry<String, String[]>  conditionset : conditionsets.entrySet())
							if(goalset.getKey().equals(conditionset.getKey()))
							{
							GoalSum += Double.valueOf(goalset.getValue()[0]);
							ConditionSum += Double.valueOf(conditionset.getValue()[0]);
							size++;
							break;
						}
		if(size > 1)
			if((ConditionSum / (size --)) > (GoalSum / (size --)))
				return true;
		return false;
	}
	/**
	 * 返回计算出来的简单优度函数值
	 * 比较的前提是，目标基元与条件基元的属性对应
	 * @param ConditionBean 条件基元
	 * @param GoalBean 目标基元 
	 * @return double 简单优度值
	 */
	public double SimpleYouduFunction_Value(YouduBean ConditionBean, YouduBean GoalBean){
		double GoalSum = 0;//需要被比较的基元
		double ConditionSum = 0;
		int size = 1;
		HashMap<String,String[]> conditionsets = ConditionBean.getElements();
		HashMap<String,String[]> goalsets = GoalBean.getElements();
		if(GoalBean.getElements().size() > 0)
			for(Entry<String, String[]>  conditionset : conditionsets.entrySet())
				for(Entry<String, String[]> goalset : goalsets.entrySet())
					if(goalset.getKey().equals(conditionset.getKey()))
						{
							GoalSum += Double.valueOf(goalset.getValue()[0]);
							ConditionSum += Double.valueOf(conditionset.getValue()[0]);
							size++;
							break;
						}

		return Double.valueOf((ConditionSum / (size --)));
		
	}
	/**
	 * 根据基元的属性值与其属性的权值进行求和运算，并且设置优度值
	 * @param bean 需要调用的基元
	 * @return double
	 */
	public void setYouduBeanValue(YouduBean bean){
		Set<Entry<String, String[]>> elementset = bean.getElements().entrySet();
		double sum = 0;
		for(Entry<String, String[]> set : elementset)
		{
			sum = Double.valueOf(set.getValue()[0])
					* Double.valueOf(set.getValue()[1]);
			
		}
		bean.setYouduValue(String.valueOf(sum));
	}
	/**
	 * 返回已算好优度值的List
	 * @param beans
	 * @return
	 */
	public List<YouduBean> getYouduBeanValue(List<YouduBean> beans){
		for(YouduBean bean : beans)
		{
			setYouduBeanValue(bean);
		}
		return beans;
	}
	/**
	 * 此函数是在已有优度值的基础上，进行排序比较的过程
	 * 
	 * @param beans 输入已经计算好优度值的beans
	 * @return List<YouduBean> 已排好序的bean
	 */
	public List<YouduBean> getYouduBeanList(List<YouduBean> beans){
		List<YouduBean> bean = new ArrayList<YouduBean>();
		double max;//最大值
		String BeanName;//最大值的Bean的名称，用于删除原基元组
		int count = 0;//计算被添加基元的个数
		int countOut = 0;//计算遍历的次数
		int CountBean = 0;//记录被加入新的List中的bean的索引值
		
	
		if(beans.size() > 0)
		{
			max = Double.valueOf(beans.get(0).getYouduValue());
			BeanName = beans.get(0).getBeanName();
			while(beans.size() != 0)
			{
				for(int i=0;i < beans.size(); i++)//遍历输入的Bean
				{
					double bv = Double.valueOf(beans.get(i).getYouduValue());
					if(max < bv)
						{
							max = bv;
							BeanName = beans.get(i).getBeanName();
							CountBean = i;//记录优度值最大值的位置
						}
					
					countOut++;//统计已遍历的数目
					
					if(countOut == beans.size())//当已遍历的数完成时，重置countOut和max
					{
						if(max == Double.valueOf(beans.get(0).getYouduValue()))
							CountBean = 0;//当第一个即为最大值时，记录优度值最大值的位置为0
						bean.add(count, beans.get(CountBean));
						beans.remove(CountBean);//删除优度值最大值的Bean
						count++;//修改被加入的List的指针
						countOut = 0;
						CountBean = 0;
						max = Double.valueOf(beans.get(0).getYouduValue());
					}
				}
				if(beans.size() == 1)//如果大小剩余1,即可直接放入，直接跳出
				{
					bean.add(count, beans.get(0));
					beans.remove(0);
				}
			}
		}else 
			{
				max = 0;
				BeanName = "";
			}
		
	
		return bean;
	}

	/**
	 * 将接收的json字符串转化为Bean
	 * @param jsonstring
	 * @return List<YouduBean>
	 */
	public List<YouduBean> transform(String jsonstring){
		Gson gson = new Gson();
		System.out.println(jsonstring);
		List<YouduBean> beans = gson.fromJson(jsonstring, new TypeToken<List<YouduBean>>(){}.getType());
		return beans;
	}
	/**
	 * 将Bean转化为json字符串
	 * @param beans
	 * @return String
	 */
	public String transform(List<YouduBean> beans)
	{
		Gson gson = new Gson();
		return gson.toJson(beans);
	}
	/**
	 * 优度函数通过输入的json字符串来转换成bean，进行优度计算且排序后，再转换回json字符串返回。
	 * @param jsonString 包含List<YouduBean>的json信息。
	 * @return json字符串(已排序后的List<YouduBean>)
	 */
	public String YouduFunction(String jsonString){
		
		List<YouduBean> beans = this.transform(jsonString);
		return this.transform(
				this.getYouduBeanList(
				this.getYouduBeanValue(
						beans)));
		
	}
	/**
	 * 接收一系列Youdubean构成的List(List<YouduBean>)
	 * 经过优度评价，返回经过排序后的List组
	 * @param beans List<YouduBean>
	 * @return 已优度评价且排序过的List组
	 */
	public List<YouduBean> YouduFunction(List<YouduBean> beans)
	{
		return this.getYouduBeanList(
				this.getYouduBeanValue(beans));
	}
}
