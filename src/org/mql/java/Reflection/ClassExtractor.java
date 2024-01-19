package org.mql.java.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Vector;

public class ClassExtractor {
private Class<?> data ;
private Vector<Field> resultFields;
private Vector<Method> resultMethods;

	public ClassExtractor(Class<?> data ) {
		this.data = data  ;
 		resultFields = new Vector<>();
		resultMethods = new Vector<>();	
	}
	public   Vector<Field> extractFields() {
		Field fields[] = data.getDeclaredFields();
		for(Field f : fields) {
		  resultFields.add(f);
		}
		return  resultFields;
	}
	public  Vector<Method> extractMethods(){
			Method methods []= data.getDeclaredMethods(); 
			for(Method m : methods) {
			 resultMethods.add(m);	
		
			}
			return resultMethods;
		}	
		
	

																																																}


