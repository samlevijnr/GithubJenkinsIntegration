package com.gmail.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gmail.constants.ConstantValues;

public class Excel implements ConstantValues{

	public String[][] arrayContainer;

	//constructor
	public Excel() {
		try {
			Load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//retrieve data from Excel file and insert into 2-Dimensional Array
	public void Load() throws IOException{
		File file = new File("./resources/SignIn.xlsx");
		FileInputStream fileStreamed = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fileStreamed);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getLastCellNum();
		arrayContainer = new String[totalRows+1][totalColumns];

		String value = null;
		for (int row = 0; row <= totalRows; row++) {
			for (int col = 0; col < totalColumns; col++) {
				XSSFRow rowNumber = sheet.getRow(row);
				XSSFCell cellNumber = rowNumber.getCell(col);

				value = cellNumber.getStringCellValue();

				//JOptionPane.showMessageDialog(null, value);
				arrayContainer[row][col] = value;
			}
		}

	}
	
}
