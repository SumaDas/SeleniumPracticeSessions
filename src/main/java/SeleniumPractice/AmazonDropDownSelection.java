package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonDropDownSelection {
	static WebDriver driver;

	public static void main(String[] args) {

		String browserName = "chrome";
		String Url = "https://www.amazon.com/";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);

		eleUtil.doSendKeys(By.id("twotabsearchtextbox"), "Nintendo");
		
		List<String> li = eleUtil.getDropDownOptionsValues(By.xpath("//div[@id='suggestions']/div"));
		for (String s : li)
			System.out.println(s);
		
		eleUtil.selectDropDownValue(By.xpath("//div[@id='suggestions']/div"), "nintendo switch");

		//wf.closeBrowser();

	}

}
