package com.juaracoding.ujianmiggu7;

import org.testng.annotations.Test;

import com.juaracoding.ujianmiggu7.utils.Utils;
import com.juaracoding.ujianminggu7.CatatanKeuangan;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseTestClass {
	
	AndroidDriver<MobileElement> driver;
	ExtentReports reports;
	ExtentTest logger;
	CatatanKeuangan catatanKeuangan;
	
	
	@BeforeTest
	public void initReports() {
		  reports = new ExtentReports(System.getProperty("user.dir")+"/Reporting/TestReport.html", true);
	  }

	@BeforeClass
	public void beforeClass() throws Exception {
	  	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "SM-A505F");
		capabilities.setCapability("uuid", "10.130.200.57:5555");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("appPackage", "com.chad.financialrecord");
		capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }
	
	@BeforeMethod
	public void BeforeMethodTest() {
	catatanKeuangan = new CatatanKeuangan(driver);
	}
  
  @AfterMethod
  public void getResult(ITestResult result)throws IOException {
	  if(result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = Utils.screenShot(driver, result.getMethod().getDescription().replace(" ", "_").toLowerCase());
			logger.log(LogStatus.FAIL, result.getMethod().getDescription()+logger.addScreenCapture(screenShotPath));
		} else {
			logger.log(LogStatus.PASS, result.getMethod().getDescription());
		}
		reports.endTest(logger);
  }

  @AfterClass
  public void CloseApp() {
	  reports.flush();
		reports.close();
		tunggu(1);
		driver.quit();
  }

  public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
