package com.isd.dao;

import java.util.Set;
import java.util.Map.Entry;

import com.isd.bean.YouduFunctionBean;

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
	public boolean SimpleYouduFunction(YouduFunctionBean ConditionBean, YouduFunctionBean GoalBean){
		double GoalSum = 0;//需要被比较的基元
		double ConditionSum = 0;
		int size = 1;
		Set<Entry<String, String[]>> conditionsets = ConditionBean.getElements();
		Set<Entry<String, String[]>> goalsets = GoalBean.getElements();
		if(GoalBean.getElements().size() > 0)
			for(Entry<String, String[]> goalset : goalsets)
				for(Entry<String, String[]>  conditionset : conditionsets)
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
	public double SimpleYouduFunction_Value(YouduFunctionBean ConditionBean, YouduFunctionBean GoalBean){
		double GoalSum = 0;//需要被比较的基元
		double ConditionSum = 0;
		int size = 1;
		Set<Entry<String, String[]>> conditionsets = ConditionBean.getElements();
		Set<Entry<String, String[]>> goalsets = GoalBean.getElements();
		if(GoalBean.getElements().size() > 0)
			for(Entry<String, String[]>  conditionset : conditionsets)
				for(Entry<String, String[]> goalset : goalsets)
					if(goalset.getKey().equals(conditionset.getKey()))
						{
							GoalSum += Double.valueOf(goalset.getValue()[0]);
							ConditionSum += Double.valueOf(conditionset.getValue()[0]);
							size++;
							break;
						}

		return Double.valueOf((ConditionSum / (size --)));
		
	}
	
}
