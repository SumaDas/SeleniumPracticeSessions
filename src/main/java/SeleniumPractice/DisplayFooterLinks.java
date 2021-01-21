package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisplayFooterLinks {
	static WebDriver driver;

	public static void main(String[] args) {

		String browserName = "chrome";
		String Url = "https://www.amazon.com/";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);

		List<WebElement> footerList = eleUtil
				.getElements(By.xpath("//div[@class='navFooterVerticalColumn navAccessibility']//a"));
		for (WebElement e : footerList) {
			System.out.println(e.getText());
		}
		
	}

}
