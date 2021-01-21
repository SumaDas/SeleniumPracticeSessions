package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleFooterLinks {
static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "https://www.google.com/";
		
		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);
		
		ElementUtils eleUtil = new ElementUtils(driver);
		List<WebElement> footerLinks1 = eleUtil.getElements(By.xpath("//div[@class='fbar']//a"));
		for(WebElement e : footerLinks1)
		{
			if(e.isDisplayed())
				System.out.println(e.getText());
		}
		wf.closeBrowser();
	}

}
