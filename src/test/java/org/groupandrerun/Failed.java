package org.groupandrerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Failed  implements IRetryAnalyzer{
	
	int min = 0,max =6;

	public boolean retry(ITestResult arg0) {
		if (min <max) {
			
			min++ ;return true;
			
		}
		
		return false;
	}
	
	
}
