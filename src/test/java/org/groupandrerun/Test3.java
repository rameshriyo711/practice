package org.groupandrerun;

import org.testng.annotations.Test;

public class Test3 {
	@Test(groups = "riyo")
	private void tc1() {
		System.out.println("hello");
	}
	
	@Test(groups = "smoke")
	private void tc2() {
   System.out.println("baby");
   
	}

	@Test(groups = "e2e")
	private void tc3() {
		System.out.println("and");
		
	}
	
	@Test(groups ="reg")
	private void tc4() {
		System.out.println("the");
	}
	

}
