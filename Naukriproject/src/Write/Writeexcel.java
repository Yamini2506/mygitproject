package Write;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Writeexcel {

	WebDriver driver=null;
	@FindBy(xpath="//span[@class='org']")
	private WebElement companyname;
	@FindBy(xpath="//a[@id='jdUrl']")
	private WebElement jobtitle; 
	@FindBy(xpath="//span[@class='exp']")
	private WebElement experience;
	@FindBy(xpath="//span[@class='loc']")
	private WebElement location;
	@FindBy(xpath="//span[@class='salary']")
	private WebElement salary;
	
	public Writeexcel(WebDriver driver)
	{
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		   }
	
	public void write() throws Exception
	{
		List<WebElement>companyname=driver.findElements(By.xpath("//span[@class='org']"));
		int size=companyname.size();
		
		List<WebElement>jobtitle=driver.findElements(By.xpath("//a[@id='jdUrl']"));
		int size1=jobtitle.size();
		
		List<WebElement>experience=driver.findElements(By.xpath("//span[@class='exp']"));
		int size2=experience.size();
		
		List<WebElement>location=driver.findElements(By.xpath("//span[@class='loc']"));
		int size3=location.size();
		
		List<WebElement>salary=driver.findElements(By.xpath("//span[@class='salary']"));
		int size4=salary.size();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\RAJKUMAR\\Desktop\\yamini\\Naukri.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sht=wb.createSheet("WalkinDetails");
		sht.createRow(0).createCell(0).setCellValue("Company Name");
		sht.getRow(0).createCell(1).setCellValue("Job Title");
		sht.getRow(0).createCell(2).setCellValue("Experience");
		sht.getRow(0).createCell(3).setCellValue("Location");
		sht.getRow(0).createCell(4).setCellValue("Salary");
		
		for(int i=0;i<=size;i++)
		{
			String name=companyname.get(i).getText();
			String name1=jobtitle.get(i).getText();
			String name2=experience.get(i).getText();
			String name3=location.get(i).getText();
			String name4=salary.get(i).getText();
			
			sht.createRow(i+1).createCell(0).setCellValue(name);
			sht.getRow(i+1).createCell(1).setCellValue(name1);
			sht.getRow(i+1).createCell(2).setCellValue(name2);
			sht.getRow(i+1).createCell(3).setCellValue(name3);
			sht.getRow(i+1).createCell(4).setCellValue(name4);
			
		}
		
		fis.close();
		FileOutputStream fos=new FileOutputStream("C:\\Users\\RAJKUMAR\\Desktop\\yamini\\Naukri.xlsx");
		wb.write(fos);
		wb.close();
	}

}
