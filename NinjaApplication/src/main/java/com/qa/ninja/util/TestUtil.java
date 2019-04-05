package com.qa.ninja.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	public String userName;
	public String pwd;

	public void readExcelFile()
	{
		try
		{
			String projectPath = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(projectPath + "\\Excel\\User_data.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet("Sheet2");
			int noOfRows = sheet.getLastRowNum() +1;
			System.out.println("No of rows in Excel sheet : " + noOfRows);
			
			for(int i =1; i<noOfRows; i++)
			{
				String user = sheet.getRow(i).getCell(0).getStringCellValue();
				userName = user;
				System.out.println("User name is : " +  userName);
			
				String pass = sheet.getRow(i).getCell(1).getStringCellValue();
				pwd = pass;
				System.out.println("Password is : " +  pwd);
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
