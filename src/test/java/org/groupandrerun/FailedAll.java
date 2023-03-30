package org.groupandrerun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class FailedAll  implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class arg1, Constructor arg2, Method arg3) {
		
     IRetryAnalyzer analyzer = annotation.getRetryAnalyzer();
     
     if (analyzer==null) {
    	 
    	 // to trigger iretryanalyzer here using setRetryAnalyer
    	 
    	 annotation.setRetryAnalyzer(Failed.class);
		
	}
		
	}

}
