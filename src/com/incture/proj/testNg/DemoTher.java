package com.incture.proj.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.incture.utility.openBrowser;
import com.incture.utility.actions.GenericActions;
import com.incture.utility.browser.MultipleBrowser;
import com.incture.utility.listener.CustomListeneresImplementation;
import com.incture.utility.reports.ExtentReport;
import com.incture.utility.reports.Report;

import randD.SettersGetters;
@Listeners(CustomListeneresImplementation.class)
public class DemoTher {

WebDriver driver=null;
	


	@BeforeMethod
	public void beforeTest() throws InterruptedException{
		openBrowser ob=new openBrowser();
		System.out.println("beforeTest()");
		
		//	SettersGetters sg=new SettersGetters();
		//  SettersGetters.setBrowserName(nodeIp);
			
			System.out.println(SettersGetters.getBrowserName());
		
			driver=new MultipleBrowser().getBrowserDriver("chrome");
			GenericActions.launchUrl(driver, "https://www.facebook.com/login/");			
		
		//driver=ob.LaunchLocalBrowser("chrome", "https://www.google.com");
	}
	
	//@BeforeMethod
	public  void beforeMethod(){
		System.out.println("beforeMethod()");
		
	}

	@Test
	public void test1(){
		
		dummyMethod();
		
		System.out.println(ExtentReport.getTest().getRunStatus());
		
       Report report=new Report(driver);
       report.info("", "", true);
       System.out.println(ExtentReport.getTest().getRunStatus());
		
		//Assert.assertEquals(true, true);
		System.out.println("test1()");
		SettersGetters sg=new SettersGetters();
		sg.getBrowserName();
		//Report.pass("Step1-- login", "Users is try to login", true);	
		//Report.info("Step2-- Perform", "Users is try to do  Perform", true);	
	}

	@Test
	public void test2(){
		//Assert.assertEquals(true, true);
		System.out.println("test2()");
		//Report.pass("Step1-- login", "Users is try to login", true);	
		//Report.fail("Step2-- Perform", "Users is try to Perform", true);	
	}
	
	
	@Test(enabled = false)
	public void test3(){
		System.out.println("Skipping test3 ....");
		
	}
	
	
	@AfterMethod
	public  void afterMethod(){
		System.out.println("afterMethod()");
	}
	@AfterTest
	public void afterTest() throws InterruptedException{
		//driver.close();
		//driver.quit();
		System.out.println("afterTest()");
	Thread.sleep(6000);
	}
	
	
	
	public void dummyMethod(){
	try{
		
		System.out.println(driver.findElement(By.id("email")).getAttribute("placeholder")==null);
		
		System.out.println();
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}

}
