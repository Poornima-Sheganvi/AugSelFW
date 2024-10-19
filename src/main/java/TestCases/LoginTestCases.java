package TestCases;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.InvokeBroswer;
import POMLocaters.HomePageLocaters;
import POMLocaters.LoginPageLocaters;

public class LoginTestCases extends InvokeBroswer {

	// BeforeMethod
	@Test(description = "Verify Login page GUI elements", groups = "Regression")
	public void verifyLoginElements() throws InterruptedException {
		try {
			// validate title
			String actTitle = driver.getTitle();
			System.out.println(actTitle);
			Assert.assertEquals(actTitle, "Swag Labs");

			String acturl = driver.getCurrentUrl();
			Assert.assertEquals(acturl, prop.getProperty("url"));

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	// AfterMethod

	@Test(description = "Verify Login functionality with valid credentials", groups = "Regression")
	public void verifyValidCrentials() {
		try {
			LoginPageLocaters loginPageLocaters = new LoginPageLocaters(driver);
			Map<String, Boolean> preChechMap = loginPageLocaters.fetchLoginPageElements();
			Assert.assertTrue(preChechMap.get("isusernameDisplayed"));
			Assert.assertTrue(preChechMap.get("ispwdDisplayed"));
			Assert.assertTrue(preChechMap.get("isloginButtonDisplayed"));

			loginPageLocaters.login(prop.getProperty("username"), prop.getProperty("password"));
			HomePageLocaters homePageLocaters = new HomePageLocaters(driver);
			boolean isMenuDisplayed = homePageLocaters.isMenuDisplayed();
			Assert.assertTrue(isMenuDisplayed);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Test(description = "Verify Login page with invalid crentials from Data provider", 
			dataProvider = "Invalid TestData for Login page", 
			dataProviderClass = Utilies.TestDataProvider.class)
	public void verifyInvalidCrentials(String name, String pwd) throws InterruptedException {
		// valid name, invalid pwd
		// invalid name, valid pwd
		// invalid name, invalid pwd
		LoginPageLocaters loginPageLocaters = new LoginPageLocaters(driver);
		loginPageLocaters.login(name, pwd);
		String actErrorMsg = loginPageLocaters.fetchErrorMsg();
		Assert.assertEquals(actErrorMsg, "Epic sadface: Username and password do not match any user in this service");
		Thread.sleep(2000);
	}

//	@Test(description="Verify Login page with invalid name, valid pwd")
//	public void verifyInvalidCrentials2() throws InterruptedException {
//		LoginPageLocaters loginPageLocaters = new LoginPageLocaters(driver);
//		loginPageLocaters.login("hgfjshdgfjh", prop.getProperty("password"));
//		String actErrorMsg=loginPageLocaters.fetchErrorMsg();
//		Assert.assertEquals(actErrorMsg, "Epic sadface: Username and password do not match any user in this service");
//	}
//	
//	@Test(description="Verify Login page with invalid name, invalid pwd")
//	public void verifyInvalidCrentials3() throws InterruptedException {
//		LoginPageLocaters loginPageLocaters = new LoginPageLocaters(driver);
//		loginPageLocaters.login("besant@gmail.com", "88768sfdf@123");
//		String actErrorMsg=loginPageLocaters.fetchErrorMsg();
//		Assert.assertEquals(actErrorMsg, "Epic sadface: Username and password do not match any user in this service");
//	}

	@Test(description = "Verify Login page with blank data")
	public void verifyBlankCredentials() throws InterruptedException {
		LoginPageLocaters loginPageLocaters = new LoginPageLocaters(driver);
		loginPageLocaters.login("", "");
		String actErrorMsg = loginPageLocaters.fetchErrorMsg();
		Assert.assertEquals(actErrorMsg, "Epic sadface: Username is required");
	}

}
