package org.emp;


import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JUnitAssertion extends BaseClass {
	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		getChromeDriver();
		enterAppUrl("https://adactinhotelapp.com/");

	}

	@AfterClass
	public static void afterClass() {
	

	}
	@Test
	public void booking() throws IOException, InterruptedException {
		WebElement txtUserName =findelementById("username");
		String name = getCellValue("Sheet1", 1, 0);
		elementSendKeys(txtUserName, name);
		
		WebElement txtPassword =findelementById("password");
		String password = getCellValue("Sheet1", 1, 1);
        elementSendKeys(txtPassword, password);
        
        WebElement btnLogin =findelementById("login");
        elementClick(btnLogin);
        
        WebElement textLoginSuccessMsg =findelementByClassName("input_show");
        String actLoginSuccessMsg = elementGetAttribute(textLoginSuccessMsg);
       Assert.assertEquals("After login success message", "Hello Rameshriyo711!",actLoginSuccessMsg );
        
        
        WebElement drplocation = findelementById("location");
        String drplocationvalue = getCellValue("Sheet1", 1, 2);
        SelectoptionByValue(drplocation, drplocationvalue);
        
        WebElement drpHotel = findelementById("hotels");
        String drpHotelvalue = getCellValue("Sheet1", 1, 3);
        SelectoptionByValue(drpHotel, drpHotelvalue);
        
        WebElement drproomtype =findelementById("room_type");
        String drproomtypevalue = getCellValue("Sheet1", 1, 4);
        SelectoptionByValue(drproomtype, drproomtypevalue);
        
        WebElement drproomno = findelementById("room_nos");
        String drproomnovalue = getCellValue("Sheet1", 1, 5);
        selectOptionsByText(drproomno, drproomnovalue);
        
        WebElement btnsearch = findelementById("Submit");
        elementClick(btnsearch);
        
        WebElement textSearchhtl =findelementByXpath("//td[@class='login_title']");
        String acttextSearchhtl = elementGetText(textSearchhtl);
        Assert.assertEquals("Verify Select Hotel ", "Select Hotel",acttextSearchhtl);
        
        WebElement btnRadio = findelementById("radiobutton_0");
        elementClick(btnRadio);
        
        WebElement btnContinue =findelementById("continue");
        elementClick(btnContinue);
        
        WebElement textbookhotel =findelementByXpath("(//td[@class='login_title'])[2]");
        String acttextbookhotel = elementGetText(textbookhotel);
        Assert.assertEquals("Verify Book A Hotel", "Book A Hotel",acttextbookhotel);
        
       
        WebElement txtFirst =findelementById("first_name");
		String txtFirstname = getCellValue("Sheet1", 1, 9);
		elementSendKeys(txtFirst, txtFirstname);
		
		WebElement txtLast = findelementById("last_name");
		String txtLastname = getCellValue("Sheet1", 1, 10);
		elementSendKeys(txtLast, txtLastname);
		
		WebElement txtaddress = findelementById("address");
		String txtaddressname = getCellValue("Sheet1", 1, 11);
		elementSendKeys(txtaddress, txtaddressname);
		
		WebElement txtccno = findelementById("cc_num");
		String txtccnoname = getCellValue("Sheet1", 1, 12);
		elementSendKeys(txtccno, txtccnoname);
		
		WebElement drpcctype = findelementById("cc_type");
        String drpcctypevalue = getCellValue("Sheet1", 1, 13);
        SelectoptionByValue(drpcctype, drpcctypevalue);
        
        Thread.sleep(3000);
        
        WebElement drpccExpMonth = findelementById("cc_exp_month");
        String drpccExpMonthvalue = getCellValue("Sheet1", 1, 14);
        selectOptionByText(drpccExpMonth, drpccExpMonthvalue);
        
        WebElement drpccExpYear =findelementById("cc_exp_year");
        selectOptionByIndex(drpccExpYear,11);
        
        WebElement txtcvv = findelementById("cc_cvv");
        String txtCvvValue = getCellValue("Sheet1", 1, 16);
	    elementSendKeys(txtcvv,txtCvvValue );
		
		WebElement btnBooknow = findelementById("book_now");
        elementClick(btnBooknow);
        
        Thread.sleep(9000);
        WebElement txtOrderNo = findelementById("order_no");
        String orderNo = elementGetAttribute(txtOrderNo);
        writeCellData("Sheet1", 1, 17,orderNo );

        WebElement textbookconf =findelementByXpath("//td[@class='login_title']");
        String acttextbookconf = elementGetText(textbookconf);
        Assert.assertEquals("Verify Booking Confirmation", "Booking Confirmation",acttextbookconf);
        
	}

	private void selectOptionsByText(WebElement drproomno, String drproomnovalue) {
		
	}
}


