package org.emp;

import java.time.Duration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
//	private static final WebElement WebElement = null;
	 
	public static WebDriver driver;
	
	public static  void getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		
	}
	public static void getEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
	}
	
	public static void enterAppUrl(String url) {
		driver.get(url);
	}
	
	public static void maximizeWindow() {
		driver.manage().window().maximize();

	}
	
	public static  void elementSendKeys(WebElement element,String text) {
	    element.sendKeys(text);
	}
	
	public void elementSendKeysJs (WebElement element,String text) {
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arugument[0].setattribute('value','"+text+"')",element);
	    	
	}
	
	private void clickByJs() {
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("argument[o].click(), element");
		
	}
	
	public  void elementClick(WebElement element) {
	    element.click();
	}
	public void elementClear(WebElement element) {
	    element.clear();;
	}
	public static String getAppTittle(){
		String title = driver.getTitle();
		return title;
	    
	}
	public void closeWindow() {
	    driver.close();
	}
	
	public static void quitWindow() {
	    driver.quit();
	}
	public  String elementGetText(WebElement element){
		String text = element.getText();
		return text.trim();
	}
	
//	99% value
	public static  String elementGetAttribute(WebElement element){
		String attribute = element.getAttribute("value");
		return attribute.trim();
	}
//	remaining 1% 
	public  String elementGetAttribute(WebElement element,String attributeName){
		String attribute = element.getAttribute(attributeName);
		return attribute.trim();
	}
	
	public WebElement findelementById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;	
	}
	
	public WebElement findelementByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}
	
	public WebElement findelementByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}
	public WebElement findelementByXpath(String attributevalue) {
		WebElement element = driver.findElement(By.xpath(attributevalue));
		return element;
	}
	
	public void rightClick() {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}
	
	public void selectOptionByText(WebElement element,String text){
		Select Select = new Select(element);
		Select.selectByVisibleText(text);
	}
	
	
	public void SelectoptionByValue(WebElement element,String valve){
		Select Select = new Select(element);
		Select.selectByValue(valve);
	}
	
	public void selectOptionByIndex(WebElement element,int index){
		Select Select = new Select(element);
		Select.selectByIndex(index);
	}
	private void deeSelectAll(WebElement element) {
		Select select =  new Select(element);
		select.deselectAll();
	}
	
	public Alert alertAccept() {	
		Alert alert = driver.switchTo().alert();		
		alert.accept();
		return alert;	
	}
	public Alert alertDismiss() {	
		Alert alert = driver.switchTo().alert();		
		alert.dismiss();
		return alert;	
	}
	
	private void alertSendKeys(WebElement element,String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys("value");
	}
	
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
				
	}
	
	public void refreshPage() {	
		driver.navigate().refresh();
	}
	
	public void back() {	
		driver.navigate().back();
	}
	
	public void forward() {	
		driver.navigate().forward();
	}
	
	public void deSelectoptionByText(WebElement element,String text){
		Select Select = new Select(element);
		Select.deselectByVisibleText(text);
	}
	
	public void deSelectoptionByAttribute(WebElement element,String valve){
		Select Select = new Select(element);
		Select.deselectByValue(valve);
	}
	
	public void deSelectoptionByIndex(WebElement element,int index){
		Select Select = new Select(element);
		Select.deselectByIndex(index);
	}
	
	public void deSelectAll(WebElement element){
		Select Select = new Select(element);
		Select.deselectAll();
	}
	
	public boolean isDisplayed(WebElement element) {
		boolean c = element.isDisplayed();
		return c;
		}
	
	public boolean isEnabled(WebElement element) {
		boolean c = element.isEnabled();
		return c;
		
	}
	
    public boolean isSelected(WebElement element) {
		boolean c = element.isSelected();
		return c;
		
	}
	
   public void implicityWait() {

	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	   
   }

      public void writeCellData(String sheetName, int rownum, int cellnum,String data) throws IOException {
    	  File file = new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\Book1.xlsx");
    	  FileInputStream fileinputstream = new FileInputStream(file);
    	  Workbook workbook = new XSSFWorkbook(fileinputstream);
    	  Sheet sheet = workbook.getSheet("Sheet1");
    	  Row row = sheet.getRow(rownum);
    	  Cell cell = row.createCell(cellnum);
    	  cell.setCellValue(data);
    	  FileOutputStream fileoutputstream = new FileOutputStream(file);
    	  workbook.write(fileoutputstream);
	  
	  
    }
	
	public void updateCellData(String sheetName,int rownum,int cellnum,String oldData,String newData)throws IOException {
		
		File file=new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\Book1.xlsx");
	    FileInputStream fileInputStream=new FileInputStream(file);	
	    Workbook workbook=new XSSFWorkbook(fileInputStream);
	    Sheet sheet = workbook.getSheet("Sheet1");
	    Row row = sheet.getRow(rownum);
	    Cell cell = row.getCell(cellnum);
	    
	    String value=cell.getStringCellValue();
	    if (value.equals(oldData)) {
	    	cell.setCellValue(newData);
	    }
	    FileOutputStream fileOutputStream=new FileOutputStream(file);
	    workbook.write(fileOutputStream);	
		}
	
	public String getCellValue (String sheetName,int rownum,int cellnum)throws IOException {
		
		String res=" ";
		File file=new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\Book1.xlsx");
	    FileInputStream fileInputStream=new FileInputStream(file);	
	    Workbook workbook=new XSSFWorkbook(fileInputStream);
	    Sheet sheet = workbook.getSheet("Sheet1");
	    Row row = sheet.getRow(rownum);
	    Cell cell = row.getCell(cellnum);
	    CellType type = cell.getCellType();
	    
 		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			  if (DateUtil.isCellDateFormatted(cell)) {
				  Date dateCellValue = cell.getDateCellValue();
				  SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
				  res  = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check==numericCellValue) {
					res = String.valueOf(numericCellValue);
				} else {
                   res = String.valueOf(check);
				}
             break;
			}
		default:
			break;
		}
		return res;      	
	}












}