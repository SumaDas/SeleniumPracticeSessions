package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsDemo {
	static WebDriver driver;

	public static void main(String[] args) {

		String browserName = "chrome";
		String Url = "https://www.spicejet.com";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);

		By loginMenu = By.linkText("LOGIN / SIGNUP");
		By spiceClubMembers = By.linkText("SpiceClub Members");
		By memberLogin = By.linkText("Member Login");

		// eleUtil.doMoveToElementAndClick(loginMenu);
		//eleUtil.doMoveToElement(loginMenu);
		//eleUtil.doMoveToElement(spiceClubMembers);
		//eleUtil.doMoveToElementAndClick(memberLogin);

		eleUtil.doClickOnSubMenu(loginMenu, spiceClubMembers, memberLogin);
	}

}
