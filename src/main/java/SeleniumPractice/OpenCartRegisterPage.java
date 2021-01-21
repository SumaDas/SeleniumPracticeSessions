package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCartRegisterPage {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		String browserName = "chrome";
		String url = "https://demo.opencart.com/index.php?route=account/register";

		WebDriverFactory browser = new WebDriverFactory();
		driver = browser.startBrowser(browserName);
		browser.launchUrl(url);
		browser.getPageTitle();
		ElementUtils eleUtil = new ElementUtils(driver);
		/*By firstName = By.id("input-firstname");
		By lastName = By.name("lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.xpath("//input[@name='password']");
		By passwordConfirm = By.cssSelector("#input-confirm");
		By privacyPolicyCheck = By.xpath("//input[@type='checkbox']");
		By continueBtn = By.className("btn-primary");
		By linksListLocator = By.xpath("//div[@class='list-group']/a");

		
		eleUtil.doSendKeys(firstName, "sumasagar");
		eleUtil.doSendKeys(lastName, "Dasangam");
		eleUtil.doSendKeys(email, "sumadasangam@gmail.com");
		eleUtil.doSendKeys(telephone, "3452432625");

		eleUtil.doSendKeys(password, "test@123");
		eleUtil.doSendKeys(passwordConfirm, "test@123");
		eleUtil.doClick(privacyPolicyCheck);
		String privacyPolicyUrl = eleUtil.doGetAttribute(By.linkText("Privacy Policy"), "href");
		System.out.println("privacy policy url is ");
		System.out.println(privacyPolicyUrl);
		System.out.println("----------clicking on links------------");

		/*
		 * eleUtil.doClick(By.linkText("Login"));
		 * eleUtil.doClick(By.linkText("Register"));
		 * eleUtil.doClick(By.linkText("Forgotten Password"));
		 * eleUtil.doClick(By.linkText("My Account"));
		 * eleUtil.doClick(By.linkText("Address Book"));
		 * eleUtil.doClick(By.linkText("Wish List"));
		 * eleUtil.doClick(By.linkText("Order History"));
		 * eleUtil.doClick(By.linkText("Downloads"));
		 * eleUtil.doClick(By.linkText("Recurring payments"));
		 * eleUtil.doClick(By.linkText("Reward Points"));
		 * eleUtil.doClick(By.linkText("Returns"));
		 * eleUtil.doClick(By.linkText("Transactions"));
		 * eleUtil.doClick(By.linkText("Newsletter"));
		 */

		List<WebElement> linksList = eleUtil.getElements(By.xpath("//div[@class='list-group']/a"));

		for (int i = 0; i < linksList.size(); i++) {
			String text = linksList.get(i).getText();
			if(!text.isEmpty())
			{
			System.out.println(text);
			String eleUrl = linksList.get(i).getAttribute("href");
			System.out.println(eleUrl);
			}
		}

		// eleUtil.doClick(continueBtn);
		// Thread.sleep(4000);
		 browser.closeBrowser();

	}
}
