package org.emp;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class  AdactinExcelOrderId {
	
		public void booking() throws IOException, InterruptedException {

			BaseClass baseclass=new BaseClass();
			
			BaseClass.getChromeDriver();
			BaseClass.enterAppUrl("https://adactinhotelapp.com/");
			
			
			WebElement txtUserName = baseclass.findelementById("username");			
			String name = baseclass.getCellValue("Sheet1", 1, 0);			
			BaseClass.elementSendKeys(txtUserName, name);			
			
			WebElement txtPassword = baseclass.findelementById("password");
			String password = baseclass.getCellValue("Sheet1", 1, 1);			
	        BaseClass.elementSendKeys(txtPassword, password);
	        
	        WebElement btnLogin = baseclass.findelementById("login");	        
	        baseclass.elementClick(btnLogin);
	        
	        WebElement drplocation = baseclass.findelementById("location");	        
	        String drplocationvalue = baseclass.getCellValue("Sheet1", 1, 2);	        
	        baseclass.selectOptionByText(drplocation, drplocationvalue);
	        
	        WebElement drpHotel = baseclass.findelementById("hotels");	        
	        String drpHotelvalue = baseclass.getCellValue("Sheet1", 1, 3);	        
	        baseclass.selectOptionByText(drpHotel, drpHotelvalue);
	        
	        WebElement drproomtype = baseclass.findelementById("room_type");	        
	        String drproomtypevalue = baseclass.getCellValue("Sheet1", 1, 4);	        
	        baseclass.selectOptionByText(drproomtype, drproomtypevalue);
	        
	        WebElement drproomno = baseclass.findelementById("room_nos");	        
	        String drproomnovalue = baseclass.getCellValue("Sheet1", 1, 5);	        
	        baseclass.selectOptionByText(drproomno, drproomnovalue);
	        
	        WebElement btnsearch = baseclass.findelementById("Submit");	        
	        baseclass.elementClick(btnsearch);
	        
	        WebElement btnRadio = baseclass.findelementById("radiobutton_0");	        
	        baseclass.elementClick(btnRadio);
	        
	        WebElement btnContinue = baseclass.findelementById("continue");	        
	        baseclass.elementClick(btnContinue);
	        
	        WebElement txtFirst = baseclass.findelementById("first_name");	        
			String txtFirstname = baseclass.getCellValue("Sheet1", 1, 9);			
			BaseClass.elementSendKeys(txtFirst, txtFirstname);
			
			WebElement txtLast = baseclass.findelementById("last_name");			
			String txtLastname = baseclass.getCellValue("Sheet1", 1, 10);			
			BaseClass.elementSendKeys(txtLast, txtLastname);
			
			WebElement txtaddress = baseclass.findelementById("address");			
			String txtaddressname = baseclass.getCellValue("Sheet1", 1, 11);
			BaseClass.elementSendKeys(txtaddress, txtaddressname);
			
			WebElement txtccno = baseclass.findelementById("cc_num");
			String txtccnoname = baseclass.getCellValue("Sheet1", 1, 12);
			BaseClass.elementSendKeys(txtccno, txtccnoname);
			
			WebElement drpcctype = baseclass.findelementById("cc_type");
	        String drpcctypevalue = baseclass.getCellValue("Sheet1", 1, 13);
	        baseclass.selectOptionByText(drpcctype, drpcctypevalue);
	        
	        WebElement drpccExpMonth = baseclass.findelementById("cc_exp_month");
	        String drpccExpMonthvalue = baseclass.getCellValue("Sheet1", 1, 14);
	        baseclass.selectOptionByText(drpccExpMonth, drpccExpMonthvalue);
	        
	        WebElement drpccExpYear = baseclass.findelementById("cc_exp_year");
	        baseclass.selectOptionByIndex(drpccExpYear, 12);
	        
	        WebElement txtcvv = baseclass.findelementById("cc_cvv");
			String txtcvvname = baseclass.getCellValue("Sheet1", 1, 16);
			BaseClass.elementSendKeys(txtcvv, txtcvvname);
			
			WebElement btnBooknow = baseclass.findelementById("book_now");
	        baseclass.elementClick(btnBooknow);
	        
	        Thread.sleep(11000);
	   
            WebElement element1 = baseclass.findelementById("order_no");
            String getAttribute = BaseClass.elementGetAttribute(element1);
            baseclass.writeCellData("Sheet1", 1, 17, getAttribute);
       
            System.out.println(getAttribute);
		}
		
		public static void main(String[] args) throws IOException, InterruptedException {
			AdactinExcelOrderId a=new AdactinExcelOrderId();
			a.booking();
		}
		
	}