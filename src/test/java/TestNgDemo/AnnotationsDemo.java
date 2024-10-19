package TestNgDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo {
	
	@BeforeMethod
	public void openBroswer() {
		System.out.println("Open browser");
	}
	@AfterMethod
	public void closeBroswer() {
		System.out.println("Close browser");
	}
	
	@Test(description="Verify Login with valid Crentials", priority=2, groups="smoke")
	public void testCase1() {
		System.out.println("test case 1");
	}
	
	@Test(description="Verify Login with invalid Crentials", priority=1, groups="Functional")
	public void testCase2() {
		System.out.println("test case 2");
	}

	@Test(description="Verify Home page successfully selecting an order to cart", priority=3,  groups="Regression")
	public void testCase3() {
		System.out.println("test case 3");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Im before Test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("Im after Test");
	}

}
