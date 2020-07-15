package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Home;
import Write.Writeexcel;

public class Test1 {

	WebDriver driver;
	
	
	@BeforeMethod
	public void add()
	{
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void Naukri() throws Exception
	{
		Home Hp=new Home(driver);
		Hp.sendkeys();
		
		Writeexcel We=new Writeexcel(driver);
		We.write();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
