package Utilies;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	
	@DataProvider(name = "Invalid TestData for Login page")
	public String[][] invalidTestData() {
	 return new String[][] {
	   { "standard_user", "8768768sfdf" },
	   { "hgfjshdgfjh", "secret_sauce"},
	   {"besant@gmail.com", "88768sfdf@123"},
	 };
	}

}
