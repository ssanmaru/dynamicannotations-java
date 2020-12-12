package com.san.testannot;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SampleAnnot {
	
	String consumer() default "myconsumer";
	String provider() default "sampleprov";

			
}
