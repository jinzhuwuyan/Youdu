package com.isd.dao;

import java.util.Set;
import java.util.Map.Entry;

import com.isd.bean.YouduFunctionBean;

public class YouduFunctionDao {
	/**
	 * ���Ŷ����ۺ������ֵ
	 * Ҫ���Ŷ�����ֻ����Ŀ���Ԫ������������������Ԫ��ֵ��
	 * ��ʹ������Ԫ(ConditionBean)����������Ŀ���Ԫ(GoalBean)û�еģ�Ҳ���������Խ�������
	 * @param ConditionBean ������Ԫ��Bean
	 * @param GoalBean Ŀ���Ԫ��Bean
	 * @return boolean ֻ���غúͻ�
	 * @exception ���Ŷ����۵�Ŀ���Ԫû������ʱ��ֱ�ӷ���false,
	 * 			    ���Ŷ����۵�Ŀ���Ԫ��������Ԫ�����Զ�û����ͬʱ��ֱ�ӷ���false
	 */
	public boolean SimpleYouduFunction(YouduFunctionBean ConditionBean, YouduFunctionBean GoalBean){
		double GoalSum = 0;//��Ҫ���ȽϵĻ�Ԫ
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
	 * ���ؼ�������ļ��ŶȺ���ֵ
	 * �Ƚϵ�ǰ���ǣ�Ŀ���Ԫ��������Ԫ�����Զ�Ӧ
	 * @param ConditionBean ������Ԫ
	 * @param GoalBean Ŀ���Ԫ 
	 * @return double ���Ŷ�ֵ
	 */
	public double SimpleYouduFunction_Value(YouduFunctionBean ConditionBean, YouduFunctionBean GoalBean){
		double GoalSum = 0;//��Ҫ���ȽϵĻ�Ԫ
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
