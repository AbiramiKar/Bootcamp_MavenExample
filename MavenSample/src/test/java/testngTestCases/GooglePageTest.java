package testngTestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GooglePageTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\Eclipse\\eclipse-workspace\\eclipse-workspace\\webdriversampleAbirami\\drivers_latest\\version90\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
 // @Test(priority=1)
	//@Test(groups= {"featureOne"})
	@Test(retryAnalyzer = RetryAnalyzerTest.class)
  public void searchTest() {
	  
	  		driver.get("http://www.google.com");
			
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals("Google",driver.getTitle());
			
			WebElement searchBox=driver.findElement(By.name("q"));
			searchBox.sendKeys("selenium");
			searchBox.submit();
			
			Assert.assertEquals("seleniu - Google Search", driver.getTitle());
			
			softAssert.assertAll();
			System.out.println(" Selenium Test Completed");
	
			
  }
  //@Test(priority=2)
	@Test(groups= {"featureOne"})
  public void CypressTest() {
	  
	  
			driver.get("http://www.google.com");
			WebElement searchBox=driver.findElement(By.name("q"));
			searchBox.sendKeys("Cypress");
			searchBox.submit();
			Assert.assertEquals("Cypress - Google Search", driver.getTitle());
			
  }  
  
  
  //@Test(enabled=false)
  //@Test(enabled=false,alwaysRun=true,dependsOnMethods="searchTest") -->Cypress and search test method will be executed in this test
  //@Test(alwaysRun=true,dependsOnMethods="searchTest")
	@Test(groups= {"featureTwo"})
  public void JavaTest() {
	  
	  
			driver.get("http://www.google.com");
			WebElement searchBox=driver.findElement(By.name("q"));
			searchBox.sendKeys("java");
			searchBox.submit();
			Assert.assertEquals("java - Google Search", driver.getTitle());
			
  }
  
  @AfterTest
  public void tearDown()
  {
	  driver.close();
  }
  
}
