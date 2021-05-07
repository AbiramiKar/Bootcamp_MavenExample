package junitTstCases;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\Eclipse\\eclipse-workspace\\eclipse-workspace\\webdriversampleAbirami\\drivers_latest\\version90\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@Test
	public void seleniumTest() {
		
		driver.get("http://www.google.com");
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
	}
	
	@Test
	public void javaTest() {
		
		driver.get("http://www.google.com");
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("java");
		searchBox.submit();
	}
	
	@After
	public void tearDown()
	{
		driver.close();
		
	}
	

}
