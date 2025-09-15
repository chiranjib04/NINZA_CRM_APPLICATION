package com.ninza.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelFileUtility {
	
//	Load excel file
	
	public Workbook loadExcelFile(String fis) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fs=new FileInputStream(fis);
		Workbook wb =  WorkbookFactory.create(fs);
		return wb;
	}
	
	public String readDataFromExcelSheet(Workbook wb,String sheetName,int rowNum,int cellNum) throws IOException
	{
		String ReadData=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();	
		return ReadData;
	}
	
	public int getLastRowNum(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./resources/Campaign_TestData_xlsx.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		int lastRowNum=wb.getSheet(sheet).getLastRowNum();
		
		return lastRowNum;
	}

	public List<String> toReadMultipleSetOfData(String sheet,int rowNum,int CellNum) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis=new FileInputStream("./resources/Campaign_TestData_xlsx.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int lastRowNum=wb.getSheet(sheet).getLastRowNum();
		List< String> listData=new ArrayList<String>();
		
		for(int i=1;i<=lastRowNum;i++)
		{
			String singleData =wb.getSheet(sheet).getRow(i).getCell(CellNum).getStringCellValue();
			listData.add(singleData);
		}
		return listData;
	}
}
