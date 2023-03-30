package org.emp;

import java.io.File;
import java.io.FileInputStream;
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

public class ExcelDoubt {

	public String  getCellValue(String sheetName,int rownum,int cellnum, int type)  throws IOException {
	
	
		
//		for q no 1
		
		String res = "   ";
		
		File file = new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\Book1.xlsx");
		
		FileInputStream fileinput = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(fileinput);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		
		Row row = sheet.getRow(1);
		
		
// q no 3			
//		for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
//			Cell cell = row.getCell(i);
//			System.out.println(cell);
//			
//		}
		
//	q no 2	
//		Cell cell = row.getCell(17);
//		
//		String value = cell.getStringCellValue();
//		if (value.equals("cell")) {
//			
//			cell.setCellValue("riyokumar");
//		}
//		FileOutputStream fileoutput = new FileOutputStream(file);
//		workbook.write(fileoutput);
//		System.out.println(value);
//		}

//	 q no 1
		
		Cell cell = row.getCell(0);
		
		CellType cellType = cell.getCellType();
		
		
		switch (cellType) {
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
		
		
	
		
		
		
}}
