package SeleniumPractice;

import org.openqa.selenium.WebDriver;

public class AuthenticationPopUp {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);
	}

}
