package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTotalImages {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "https://www.amazon.com";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);
		
		ElementUtils eleUtil = new ElementUtils(driver) ;
		List<WebElement> imgList = eleUtil.getElements(By.tagName("img"));
		System.out.println("total number of images : "+imgList.size());
		for(WebElement e : imgList)
		{
			String srcUrl = e.getAttribute("src");
			System.out.println(srcUrl);
		}
		wf.closeBrowser();
	}

}
