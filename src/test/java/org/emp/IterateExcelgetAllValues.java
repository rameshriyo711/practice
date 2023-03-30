package org.emp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IterateExcelGetAllValues{

	public static void main(String[] args) throws IOException  {
		
		File file = new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\exceltask1.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet("STUDENDS DATAS");
		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				
				Cell cell = row.getCell(j);
				
				CellType type = cell.getCellType();
				
				switch (type) {
			case STRING:
					
			String value = cell.getStringCellValue();
			System.out.println(value);
					
					break;
					
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
						String string = format.format(dateCellValue);
						System.out.println(string);
						
						}else {
					
					double d = cell.getNumericCellValue();
					BigDecimal decimal = new BigDecimal(d);
					String string = decimal.toString();
					System.out.println(string);
					break;
						}
				
				default:
					break;
				}
				
				
				
			}
			
		}
		
		}

}
