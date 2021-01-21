package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Freshworkslinks {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browserName = "Chrome";
		String Url = "https://www.freshworks.com/";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);
		List<WebElement> freshworksList = eleUtil
				.getElements(By.xpath("//div[@class='col-md-4 footer-left-section']//a"));
		for (int i = 0; i < freshworksList.size(); i++) {
			System.out.println(freshworksList.get(i).getText());
		}
	}

}
