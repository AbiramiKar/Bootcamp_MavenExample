package testngTestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.opencsv.CSVReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import net.bytebuddy.jar.asm.ClassReader;

public class DataParam {
	
WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\Eclipse\\eclipse-workspace\\eclipse-workspace\\webdriversampleAbirami\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	//@Parameters({"user_name","pass_word"})
	@Test(dataProvider="loginData")
  public void LoginTest(String uname,String pwd) {
	  driver.get("https://the-internet.herokuapp.com/login");
	  driver.findElement(By.id("username")).sendKeys(uname);
	  driver.findElement(By.id("password")).sendKeys(pwd);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
  }
//	@DataProvider(name="loginData")
//	public Object[][] getData() {
//		return new Object[][] {
//			new Object[] {"admin","admin"},
//			new Object[] {"admin1","admin1"},
//			new Object[] {"tomsmith", "SuperSecretPassword!"}
//		};
//	}
	
	//Using .csv file 
//	@DataProvider(name="loginData")
//	public Object[][] getData() throws IOException{
//		String path= System.getProperty("user.dir")+"\\testData\\LoginData.csv";
//		CSVReader reader = new CSVReader(new FileReader(path));
//		String[] col;
//		ArrayList<Object[]> datalist =new ArrayList<Object[]>();
//		while((col=reader.readNext())!=null) {
//			Object[] record = {col[0], col[1]};
//			datalist.add(record);
//		}
//		reader.close();
//		return datalist.toArray(new Object[datalist.size()][]);
//		
//	}
	
	//Using .json file
	@DataProvider(name="loginData")
	public Object[][] getData() throws IOException, ParseException{
		JSONParser jsonParser = new JSONParser();
		FileReader file= new FileReader(System.getProperty("user.dir")+"\\testData\\LoginData.json");
		Object obj=jsonParser.parse(file);
		JSONObject userJsonObj = (JSONObject) obj;
		JSONArray userLoginArray = (JSONArray) userJsonObj.get("userlogins");
		
		String path= System.getProperty("user.dir")+"\\testData\\LoginData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		String[] col;
		ArrayList<Object[]> datalist =new ArrayList<Object[]>();
		while((col=reader.readNext())!=null) {
			Object[] record = {col[0], col[1]};
			datalist.add(record);
		}
		reader.close();
		return datalist.toArray(new Object[datalist.size()][]);
		
	}
  
  @AfterTest
  public void tearDown()
  {
	 // driver.close();
  }
  
  }

