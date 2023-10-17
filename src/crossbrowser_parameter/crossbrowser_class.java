package crossbrowser_parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossbrowser_class {
	WebDriver driver;
	String url="https://www.facebook.com/";
	 
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser) 
	{
		if(browser.equalsIgnoreCase("firefox")) 
		{		
		System.out.println("Executing on FireFox");
		System.setProperty("webdriver.firefox.driver", "C:\\Users\\reema\\Desktop\\Automation\\geckodriver-v0.33.0-win64 (1)\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		}
	
		else if(browser.equalsIgnoreCase("chrome")) 
		{
			System.out.println("Executing on Chrome");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\reema\\Desktop\\Automation\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.out.println("Executing on Edge");
			System.setProperty("webdriver.edge.driver","C:\\Users\\reema\\Desktop\\Automation\\edgedriver_win64 (1)\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		
		else
			{
				throw new IllegalArgumentException("The Browser Type is undefined");
			}	
	}
	  
	  @Test
	  public void f() 
		{
		  WebElement uname=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		  uname.sendKeys("reenu@hs827y8289.com");
		  WebElement pass=driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		  pass.sendKeys("1234567876537");
		  WebElement login=driver.findElement(By.name("login"));
		  login.click();
		}
		

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }
  

}
