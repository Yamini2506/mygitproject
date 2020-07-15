package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

	WebDriver driver=null;
	
	@FindBy(xpath="//*[@id=\"qsbClick\"]/span[1]")
	private WebElement search;
	@FindBy(name="qp")
	private WebElement job;
	@FindBy(name="ql")
	private WebElement location;
	@FindBy(xpath="(//span[@class='smArw'])[1]")
	private WebElement experiencedropdown;
	@FindBy(xpath="(//input[@class='sdTxt w85'])[1]")
	private WebElement experience;
	@FindBy(xpath="(//span[@class='smArw'])[2]")
	private WebElement salarydropdown;
	@FindBy(xpath="(//input[@class='sdTxt w85'])[2]")
	private WebElement salary;
	@FindBy(id="qsbFormBtn")
	private WebElement enter;
	
	public void sendkeys()
	{
		search.click();
		job.sendKeys("java");
		location.sendKeys("chennai");
		experiencedropdown.click();
		experience.click();
		salarydropdown.click();
		salary.click();
		enter.click();
		}
	
	public Home(WebDriver driver)
	{
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		   }

	
}
