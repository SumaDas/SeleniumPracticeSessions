package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProduct {
	static WebDriver driver;
	public static void main(String[] args) {
		
		String browserName = "chrome";
		String Url = "http://automationpractice.com/index.php";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.doSendKeys(By.id("search_query_top"), "dress");
		List<String> suggestionList = eleUtil.getDropDownOptionsValues(By.xpath("//div[@class='ac_results']//li"));
		for(String s : suggestionList)
			System.out.println(s);
		

	}

}
