package org.emp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameWork2 {
	public static void main(String[] args) throws IOException {
	
	WebDriverManager.chromedriver().setup();

WebDriver driver = new ChromeDriver();
driver.get("https://omrbranch.com/apitestingtraininginchennaiomr");

WebElement countryClk = driver.findElement(By.id("country-list"));
countryClk.click();

Select s = new Select(countryClk);
List<WebElement> options = s.getOptions();

File file = new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\Book1.xlsx");


	Workbook workbook = new XSSFWorkbook();
	
	Sheet sheet = workbook.createSheet("sheet01");
	
	
for (int i = 0; i < options.size(); i++) {
	
	WebElement element = options.get(i);
	String text = element.getText();
	

	Row row = sheet.createRow(i);
	
	Cell cell = row.createCell(0);
	
	cell.setCellValue(text);
	FileOutputStream out = new FileOutputStream(file);
	
	workbook.write(out);
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

}
