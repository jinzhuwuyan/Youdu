package com.isd.utils;

import java.lang.reflect.Type;

public class GenericityUtils {
	/**
	 * 
	 * @param 泛型类型
	 * @return 泛型的组件类型
	 * @throws ClassNotFoundException
	 */
	public static Class getComponentType(Type t) throws ClassNotFoundException {
		String type = t.toString();
		if (type.contains("<")) {
			type = type.substring(type.indexOf("<") + 1, type.indexOf(">"));
			if ("java.lang.String".equals(type)) {
				return String.class;
			} else if ("java.lang.Byte".equals(type)) {
				return Byte.class;
			} else if ("java.lang.Short".equals(type)) {
				return Short.class;
			} else if ("java.lang.Integer".equals(type)) {
				return Integer.class;
			} else if ("java.lang.Long".equals(type)) {
				return Long.class;
			} else if ("java.lang.Float".equals(type)) {
				return Float.class;
			} else if ("java.lang.Double".equals(type)) {
				return Double.class;
			} else if ("java.lang.Boolean".equals(type)) {
				return Boolean.class;
			} else if ("java.lang.Character".equals(type)) {
				return Byte.class;
			} else if ("java.lang.Void".equals(type)) {
				return Byte.class;
			} else {
				return Class.forName(type);
			}
		}
		return null;
	}
}
