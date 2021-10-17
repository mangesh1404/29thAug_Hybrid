package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.testBase.TestBase;
import com.utility.ExelUtility;

public class LoginTest extends TestBase {
	WebDriver driver=null;
	LoginPage lp=null;
	public static DashboardPage dp;
	@BeforeSuite
	public void setup() {
		driver= initialization();
		reportInit();
		lp= new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test(priority=2)
	public void loginTest() {
		dp=lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | dashboard");
	}
	@Test
	public void inValidLoginTest() {
		String Uname= ExelUtility.readCell(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx", "login", 2, 0);;
		String Pass= ExelUtility.readCell(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx", "login", 2, 1);
		lp.inValidLogin(Uname, Pass);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
