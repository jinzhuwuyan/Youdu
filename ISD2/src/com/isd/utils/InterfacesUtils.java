package com.isd.utils;

import java.util.Collections;
import java.util.HashSet;

public class InterfacesUtils {
	public static HashSet<Class> interFaceSet = new HashSet<Class>();

	/**
	 * 获取所有实现的接口，包括自己实现的以及父类实现的
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
	 * 判断一个类是否实现了另外一个接口
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
