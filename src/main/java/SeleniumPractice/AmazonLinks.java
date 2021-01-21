package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonLinks {
	
	static WebDriver driver;
	//print all links on page having text
	
	public static void main(String[] args)
	{
		String url = "https://www.amazon.com/";
		String browserName = "chrome";
		
		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(url);
				
		//to get the total links on page having text
		
		ElementUtils eleUtil = new ElementUtils(driver);
		List<WebElement> eleList = eleUtil.getElements(By.tagName("a"));
		//List<WebElement> imgList = eleUtil.getElements(By.tagName("img"));
		
		System.out.println("total number of links on page : "+eleList.size());
		for(int i=0;i<eleList.size();i++)
		{
			String text = eleList.get(i).getText();
			if(!text.isEmpty())
			{
			System.out.println(i+"-->"+text);
			String URL = eleList.get(i).getAttribute("href");
			System.out.println(URL);
			}
			
		}
	}
	

}
