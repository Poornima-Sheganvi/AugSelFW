package TestNgDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {
	
	@BeforeMethod
	public void openBroswer() {
		System.out.println("Open browser");
	}
	@AfterMethod
	public void closeBroswer() {
		System.out.println("Close browser");
	}
	
	@Test(description="Verify Kart page", priority=2, groups="smoke")
	public void testCase4() {
		System.out.println("test case 4");
	}
	
	@Test(description="Verify Payment page", priority=1, groups="Functional")
	public void testCase5() {
		System.out.println("test case 5");
	}

	@Test(description="Verify Logout", priority=3,  groups="Regression")
	public void testCase6() {
		System.out.println("test case 6");
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
