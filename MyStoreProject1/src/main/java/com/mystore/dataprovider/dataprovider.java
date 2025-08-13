package com.mystore.dataprovider;



	import java.util.HashMap;
	import org.testng.annotations.DataProvider;

	import com.mystore.utilities.NewExcelLibrary;

	public class dataprovider{

		 	NewExcelLibrary obj = new NewExcelLibrary("C:\\Users\\manis\\OneDrive\\Documents\\mavenproject\\MyStoreProject1\\exceldata\\TestData.xlsx");

		 //Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		 	@DataProvider(name = "credentials")
		 	public Object[][] getCredentials() {
		 		// Totals rows count
		 		int rows = obj.getRowCount("Credentials");
		 		// Total Columns
		 		int column = obj.getColumnCount("Credentials");
		 		int actRows = rows - 1;

		 		Object[][] data = new Object[actRows][column];

		 		for (int i = 0; i < actRows; i++) {
		 			for (int j = 0; j < column; j++) {
		 				data[i][j] = obj.getCellData("Credentials", j, i + 2);
		 			}
		 		}
		 		return data;
		 	}

		 //Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
		 	@DataProvider(name = "email")
		 	public Object[][] getEmail() {
		 		// Totals rows count
		 		int rows = obj.getRowCount("Email");
		 		// Total Columns
		 		int column = obj.getColumnCount("Email");
		 		int actRows = rows - 1;

		 		Object[][] data = new Object[actRows][column];

		 		for (int i = 0; i < actRows; i++) {
		 			for (int j = 0; j < column; j++) {
		 				data[i][j] = obj.getCellData("Email", j, i + 2);
		 			}
		 		}
		 		return data;
		 	}

		 //Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
		 	@DataProvider(name = "getProduct")
		 	public Object[][] getProduct() {
		 		// Totals rows count
		 		int rows = obj.getRowCount("ProductDetails");
		 		// Total Columns
		 		int column = obj.getColumnCount("ProductDetails");
		 		int actRows = rows - 1;

		 		Object[][] data = new Object[actRows][column];

		 		for (int i = 0; i < actRows; i++) {
		 			for (int j = 0; j < column; j++) {
		 				data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
		 			}
		 		}
		 		return data;
		 	}

		 	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
		 	@DataProvider(name = "searchProduct")
		 	public Object[][] getProductPrice() {
		 		// Totals rows count
		 		int rows = obj.getRowCount("SearchProduct");
		 		// Total Columns
		 		int column = obj.getColumnCount("SearchProduct");
		 		int actRows = rows - 1;

		 		Object[][] data = new Object[actRows][column];

		 		for (int i = 0; i < actRows; i++) {
		 			for (int j = 0; j < column; j++) {
		 				data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
		 			}
		 		}
		 		return data;
		 	}
		 	
		

		 	
		 	
		 	@DataProvider(name = "newAccountCreationData")
		    public Object[][] getRegisterData(String string) {
		        String sheetName = "AccountCreationData";
		        int rows = obj.getRowCount(sheetName);
		        int cols = obj.getColumnCount(sheetName);

		        Object[][] data = new Object[rows - 1][1]; // Skipping header row

		        for (int i = 0; i < rows - 1; i++) {
		            HashMap<String, String> map = new HashMap<>();
		            for (int j = 0; j < cols; j++) {
		                String key = obj.getCellData(sheetName, j, 0); // Header
		                String value = obj.getCellData(sheetName, j, i + 1); // Data
		                map.put(key, value);
		            }
		            data[i][0] = map;
		        }
		        return getRegisterData("AccountCreationData");
		    }
		}