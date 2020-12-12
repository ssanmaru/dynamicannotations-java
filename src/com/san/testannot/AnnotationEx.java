package com.san.testannot;

public class AnnotationEx {
	
	@SampleAnnot(consumer="Hello there",provider="Hello provider")
	public void testMethod(){
		System.out.println("I am in test");
	}

}
