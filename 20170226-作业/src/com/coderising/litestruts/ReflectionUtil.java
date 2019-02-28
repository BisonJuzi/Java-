package com.coderising.litestruts;

/**
 * 根据反射找到变量和方法
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtil {

	public static List<Method> getSetterMethods(Class<?> clz) {		
		return getMethods(clz,"set");		
	}
	
	public static List<Method> getGetterMethods(Class<?> clz) {
		return getMethods(clz,"get");
	}

	public static void setParameters(Object o, Map<String, String> params) {
		
		// 获取所有的setter方法
		List<Method> methods =  getSetterMethods(o.getClass());
		
		// Map<String, String>：属性-属性值，比如：<("name","liujuan"),("password","123456")>
		for(String name : params.keySet() ){
			
			String methodName = "set" + name;
			
			for(Method m: methods){
				
				if(m.getName().equalsIgnoreCase(methodName)){
					try {
						m.invoke(o, params.get(name));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}		
	}
	
	public static Map<String, Object> getParamterMap(Object o) {
		
		Map<String ,Object> params = new HashMap<>();
		
		List<Method> methods = getGetterMethods(o.getClass());
		
		for(Method m : methods){
			
			String methodName = m.getName();
			String name = methodName.replaceFirst("get", "").toLowerCase();
			try {
				Object value = m.invoke(o); // 获取方法m对应的值
				params.put(name, value); // 把属性和其对应get方法的值放入map中
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				
				e.printStackTrace();
			} 
		}		
		return params;
	}
	
	private static List<Method> getMethods(Class<?> clz, String startWithName){
		
		List<Method> methods = new ArrayList<>();
		
		for(Method m : clz.getDeclaredMethods()){			
			if(m.getName().startsWith(startWithName)){				
				methods.add(m);			
			}		
		}		
		return methods;
	}
	
	
	////////////////////////Backup ///////////////////////////////////
	
	public static List<Method> getSetterMethods_V1(Class<?> clz) {
		
		List<Method> methods = new ArrayList<>();
		
		for(Method m : clz.getDeclaredMethods()){			
			if(m.getName().startsWith("set")){				
				methods.add(m);				
			}			
		}		
		return methods;		
	}
}
