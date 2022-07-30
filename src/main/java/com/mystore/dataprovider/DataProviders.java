package com.mystore.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;


public class DataProviders {

	//SignIn credentails
	@DataProvider(name="credentail" )
	public Object[][] getCredential() throws Exception {

		FileInputStream file=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace2\\DemoProject\\src\\test\\resources\\Testdata\\TestdataForPractice.xlsx");
		Workbook Book = WorkbookFactory.create(file);
		Sheet sheet = Book.getSheet("Credentials");
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++ ) {
				data[i][j]=(sheet.getRow(i+1).getCell(j)).toString();
			}	
		}
		return data;
	}

	//Products Names
	@DataProvider(name = "Productname")
	public Object[][] getProductNames() throws Throwable {

		FileInputStream file=new FileInputStream("C:\\\\Users\\\\Asus\\\\eclipse-workspace2\\\\DemoProject\\\\src\\\\test\\\\resources\\\\Testdata\\\\TestdataForPractice.xlsx");
		Workbook Book = WorkbookFactory.create(file);
		Sheet sheet = Book.getSheet("SearchProduct");
		Object[][] mydata=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				mydata[i][j]=(sheet.getRow(i+1).getCell(j)).toString();
			}
		}
		return mydata;
	}

	//Products Details
	@DataProvider(name = "ProductDetail")
	public Object[][] getProductDetails() throws Exception {
		FileInputStream file=new FileInputStream("C:\\\\Users\\\\Asus\\\\eclipse-workspace2\\\\DemoProject\\\\src\\\\test\\\\resources\\\\Testdata\\\\TestdataForPractice.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("ProductDetails");
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {

				data[i][j]=(sheet.getRow(i+1).getCell(j)).toString();

			}
		}
		return data;
	}

	//NewAccountCreation Data
	@DataProvider(name = "NewAccountCreation")
	public Object getRegisternationData() throws Throwable {
		DataFormatter formatter=new DataFormatter();
		FileInputStream file=new FileInputStream("C:\\\\Users\\\\Asus\\\\eclipse-workspace2\\\\DemoProject\\\\src\\\\test\\\\resources\\\\Testdata\\\\TestdataForPractice.xlsx");
		Workbook work = WorkbookFactory.create(file);
		Sheet sheet = work.getSheet("AccountCreationData");
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i< sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
                
				data[i][j] =(sheet.getRow(i+1).getCell(j)).toString();
			}
		}
		return data;
	}
	
	//NewAccountCreation Data
	@DataProvider(name = "newAccountCreation")
	public Object[][] getdataforRegistration() {
		NewExcelLibrary obj=new NewExcelLibrary();
		//Total row count
		int row = obj.getRowCount("Sheet1");
		//Total columns count
		int column = obj.getColumnCount("Sheet1");
		int actRows = row-1;
		
		Object[][] data=new Object[actRows][column];
		
		for(int i=0; i<actRows; i++) {
			Map<String, String> hasmap=new HashedMap<>();
			for(int j=0; j<column; j++) {
				data[i][j]=obj.getCellData("Sheet1", j, i+2);
			}
		}
		return data;
	}
	
	//NewAccountCreation Data by using Hashmap
	@DataProvider(name = "newusersCredentails")
	public Object[][] getDataForNewReistrationForm() {
		NewExcelLibrary obj=new NewExcelLibrary();
		
		int row = obj.getRowCount("Sheet1");
		int column = obj.getColumnCount("Sheet1");
		
		int actulaRow = row-1;
		
		Object[][] data=new Object[actulaRow][1];
		
		for(int i=0; i<actulaRow; i++) {
			Map<String, String> hashmap=new HashMap<>();
			for(int j=0; j<column; j++) {
				hashmap.put(obj.getCellData("Sheet1", j, 1), 
						obj.getCellData("Sheet1", j, i+2));
			}
			data[i][0]=hashmap;
		}
		return data;
	}

}
