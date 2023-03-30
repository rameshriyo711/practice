package org.dataprovider;

import org.emp.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameter extends BaseClass  {
	@DataProvider(name = "res")
	public Object[][] datas() {
		Object [][] obj = new Object[][] {{"Rame@123","Hello123"},{"Kumar@123","Hello123"}};
		
		return obj;}
	
	@Test(dataProvider= "res")
	private void dataProvider(String s1, String s2) throws InterruptedException {
		
		getChromeDriver();
		enterAppUrl("https://www.facebook.com/");
		
		
		WebElement txtUsername = driver.findElement(By.id("email"));
		elementSendKeys(txtUsername, s1);
		
		WebElement txtPassWord = driver.findElement(By.id("pass"));
	    elementSendKeys(txtPassWord, s2);
	
	    
		WebElement btnLogin = driver.findElement(By.name("login"));
		elementClick(btnLogin);
		
		Thread.sleep(2000);
		
		quitWindow();
	}
}
