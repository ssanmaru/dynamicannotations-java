package com.san.testannot;

import java.lang.annotation.Annotation;

public class AnnotationImpl implements SampleAnnot{

	private String consumer;
	private String provider;
	
	public AnnotationImpl(String cons, String prov) {
		this.consumer=cons;
		this.provider=prov;
	}
	@Override
	public Class<? extends Annotation> annotationType() {
		return AnnotationImpl.class;
	}

	@Override
	public String consumer() {
		return this.consumer;
	}

	@Override
	public String provider() {
		return this.provider;
	}

//	@Override
//	public String name() {
//		return "test";
//	}

}
