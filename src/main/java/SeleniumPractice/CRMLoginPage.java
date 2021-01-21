package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMLoginPage {
	WebDriver driver;

	/*public CRMLoginPage(WebDriver driver) {
		this.driver = driver;
	}*/

	By usernameLocator = By.cssSelector("input[name='username']");
	By passwordLocator = By.cssSelector("input[name='password']");
	By loginBtn = By.cssSelector("input[type='submit']");

	String userName = "batchautomation";
	String passWord = "Test@12345";

	ElementUtils eleUtil = new ElementUtils(driver);

	public void enterUserName(By locator, String userName) {
		eleUtil.doSendKeys(usernameLocator, userName);
	}

	public void enterPassWord(By locator, String passWord) {
		eleUtil.doSendKeys(passwordLocator, passWord);
	}

	public void doLogin() {
		enterUserName(usernameLocator, userName);
		enterPassWord(passwordLocator, passWord);
		eleUtil.doClick(loginBtn);
	}

}
