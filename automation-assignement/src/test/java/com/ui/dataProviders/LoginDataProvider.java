package com.ui.dataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CsvReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "Login test data provider")
	public Iterator<Object[]> loginDataProvider() {

		Gson gson = new Gson();
		File testDataProvider = new File(System.getProperty("user.dir") + "\\TestData\\LoginData.json");
		FileReader fileReader = null;
		TestData data;
		List<Object[]> dataToReturn = null;
		try {
			fileReader = new FileReader(testDataProvider);
			data = gson.fromJson(fileReader, TestData.class);

			dataToReturn = new ArrayList<Object[]>();
			for (User user : data.getData()) {
				dataToReturn.add(new Object[] { user });
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return dataToReturn.iterator();
	}

	@DataProvider(name = "Login test CSV data provider")
	public Iterator<User> loginCSVDataProvider() {
		return CsvReaderUtility.readCSVFile("LoginData.csv");
	}
	
	@DataProvider(name = "Login test Excel data provider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
	}
}
