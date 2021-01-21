package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonFooterCountryList {
	static WebDriver driver;

	public static void main(String[] args) {

		String browserName = "Chrome";
		String Url = "https://www.amazon.in/";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);
		List<WebElement> countryList = eleUtil
				.getElements(By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine ']//a"));
		for(WebElement e : countryList)
		System.out.println(e.getText());
		
		wf.closeBrowser();
	}

}
