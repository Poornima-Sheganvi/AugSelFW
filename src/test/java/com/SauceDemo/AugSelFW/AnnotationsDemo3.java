package com.SauceDemo.AugSelFW;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo3 {
	
	@BeforeMethod
	public void openBroswer() {
		System.out.println("Open browser");
	}
	@AfterMethod
	public void closeBroswer() {
		System.out.println("Close browser");
	}
	
	@Test(description="Verify Kart page", priority=2, groups="smoke")
	public void testCase7() {
		System.out.println("test case 7");
	}
	
	@Test(description="Verify Payment page", priority=1, groups="Functional")
	public void testCase8() {
		System.out.println("test case 8");
	}

	@Test(description="Verify Logout", priority=3,  groups={"Regression", "smoke"})
	public void testCase9() {
		System.out.println("test case 9");
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
