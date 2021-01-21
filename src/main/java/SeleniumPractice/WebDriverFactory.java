package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	WebDriver driver;
	/*public WebDriverFactory(WebDriver driver)
	{
		this.driver = driver;
	}*/
	
	public  WebDriver startBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
			System.out.println("pass the correct browser");
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public void launchUrl(String Url)
	{
		driver.get(Url);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	public void quitBrowser()
	{
		driver.quit();
	}

}
