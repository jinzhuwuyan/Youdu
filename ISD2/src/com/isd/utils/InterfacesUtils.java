package com.isd.utils;

import java.util.Collections;
import java.util.HashSet;

public class InterfacesUtils {
	public static HashSet<Class> interFaceSet = new HashSet<Class>();

	/**
	 * ��ȡ����ʵ�ֵĽӿڣ������Լ�ʵ�ֵ��Լ�����ʵ�ֵ�
	 * 
	 * @param c
	 * @return
	 */
	public static HashSet<Class> getAllInterfaces(Class c) {
		if (c.getInterfaces().length != 0) {
			Collections.addAll(interFaceSet, c.getInterfaces());
		}
		if (c.getSuperclass() != null) {
			getAllInterfaces(c.getSuperclass());
		}

		return interFaceSet;
	}

	/**
	 * �ж�һ�����Ƿ�ʵ��������һ���ӿ�
	 * 
	 * @param o
	 * @param c
	 * @return
	 */
	public static boolean isImplementInterface(Class o, Class c) {
		interFaceSet.clear();
		getAllInterfaces(o);
		if (interFaceSet == null) {
			return false;
		} else
			return interFaceSet.contains(c);
	}
}
