package testngTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoPageTest {
	
	ExtentTest extentTest;
	ExtentReports reports;
	ExtentHtmlReporter htmlReport;
	
	@BeforeTest
	public void setupExtent() {
		reports = new ExtentReports();
		htmlReport = new ExtentHtmlReporter("C:\\Users\\di606341\\OneDrive - Sprint\\BootCamp_Selenium\\Demo Sites\\Reports\\extentReport.html");
		reports.attachReporter(htmlReport);
		htmlReport.setAppendExisting(true);
		
	}
	
	
	WebDriver driver;
	@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\Eclipse\\eclipse-workspace\\eclipse-workspace\\webdriversampleAbirami\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
  @Test(groups= {"featureTwo"})
  public void searchPhone() {
	  
	  driver.get("https://demo.opencart.com");
		
		WebElement searchBtn = driver.findElement(By.xpath("//input[@name='search']"));
		searchBtn.sendKeys("phone");
		searchBtn.sendKeys(Keys.ENTER);
  }
  
 
//  @AfterMethod
//  public void tearDown(ITestResult result)throws IOExecption
//  {
//	  if(ITestResult.FAILURE == result.getStatus()) {
//		  extentTest.fail(result.getName());
//		  String screenshotPath = Utility.getScreenshot(driver);
//		  extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//	  } 
//	  driver.close();
//  }
}
