package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteMail {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "https://www.gmail.com";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);
		
		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.doSendKeys(By.name("identifier"), "ravikanth.uppara@gmail.com");
		eleUtil.doClick(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		
		

	}

}
