package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintDropDownSuggestions {

	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "https://www.amazon.com";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.doSendKeys(By.id("twotabsearchtextbox"), "Nintendo");

		List<String> suggestionList = eleUtil.getDropDownOptionsValues(By.xpath("//div[@id='suggestions']/div"));
		for (String s : suggestionList)
			System.out.println(s);

		wf.closeBrowser();
	}

}
