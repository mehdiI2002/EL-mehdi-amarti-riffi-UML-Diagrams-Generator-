package org.mql.java.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Vector;

public class ClassExtractor {
private Class<?> data ;
private Vector<String> resultFields;
private Vector<String> resultMethods;
	public ClassExtractor(Class<?> data ) {
		this.data = data  ;
		resultFields = new Vector<String>();
		resultMethods = new Vector<String>();
		
	}
	public  Vector<String> extractFields() {
		Field fields[] = data.getDeclaredFields();
		for(Field f : fields) {
		  resultFields.add(f.getName());
			
		}
		return resultFields;
	}
		public  Vector<String> extractMethods(){
			Method methods []= data.getDeclaredMethods(); 
			for(Method m : methods) {
			 resultMethods.add(m.getName());	
		
			}
			return resultMethods;
		}
	

																																																}


