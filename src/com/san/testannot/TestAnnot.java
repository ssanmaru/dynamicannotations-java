package com.san.testannot;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class TestAnnot {


	public static void main(String[] args) throws Exception {
		Class<?> myClass= Class.forName("com.san.testannot.AnnotationEx");
		Method meth = myClass.getMethod("testMethod", null);
		SampleAnnot annEx = meth.getAnnotation(SampleAnnot.class);
		System.out.println("The annotation on test method before change is  "+annEx.consumer()+"\t"+annEx.provider());
		SampleAnnot newValues = new AnnotationImpl("I am changed Consumer", "I am changed provider");
		changeAnnotations(AnnotationEx.class,SampleAnnot.class,newValues);
		
	}
	//This WORKS ONLY IN JDK8. there is alternative way to do this in JDK7
	public static void changeAnnotations(Class<?> targetClass,Class<? extends Annotation> annotationClass,Annotation annotValue) throws Exception{

		Class<?> myClass=targetClass;
		Method myMeth = myClass.getMethod("testMethod", null);
		Annotation[] declaredAnnotations = myMeth.getDeclaredAnnotations();	//You need to fetch current annotations
	
		Class<?> superCls=myMeth.getClass().getSuperclass();
		Field declaredAnnot=superCls.getDeclaredField("declaredAnnotations");
		declaredAnnot.setAccessible(true);
		Map<Class<? extends Annotation>, Annotation> map = (Map<Class<? extends Annotation>, Annotation>) declaredAnnot.get(myMeth);
        map.put(annotationClass, annotValue);
       SampleAnnot annotation = targetClass.getMethod("testMethod").getAnnotation(SampleAnnot.class);
       System.out.println("\nThe annotation on test method after change is  "+annotation.consumer()+"\t"+annotation.provider());
        
   	}

}
