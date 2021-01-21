package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMLoginPage {

	

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String browserName = "chrome";
		String Url = "https://www.orangehrm.com/orangehrm-30-day-trial/";

		WebDriverFactory browser = new WebDriverFactory();
		driver = browser.startBrowser(browserName);
		browser.launchUrl(Url);
		String title = browser.getPageTitle();
		System.out.println("page title is : " + title);

		ElementUtils eleUtil = new ElementUtils(driver);

		eleUtil.doSendKeys(By.xpath("//*[@id=\"Form_submitForm_FirstName\"]"), "suma");
		eleUtil.doSendKeys(By.cssSelector("#Form_submitForm_LastName"), "dasangam");
		eleUtil.doSendKeys(By.name("Email"), "abc@gmail.com");
		eleUtil.doSendKeys(By.name("JobTitle"), "QA");
		eleUtil.doDropDownSelection(By.name("NoOfEmployees"), "value", "16 - 20");
		eleUtil.doSendKeys(By.xpath("//*[@id=\"Form_submitForm_CompanyName\"]"), "abc");
		eleUtil.doDropDownSelection(By.xpath("//*[@id=\"Form_submitForm_Industry\"]"), "index", "5");
		eleUtil.doSendKeys(By.cssSelector("#Form_submitForm_Contact"), "2435362737");
		eleUtil.doDropDownSelection(By.name("Country"), "visibleText", "Australia");
		try {
			eleUtil.doClick(By.name("action_submitRequest"));
		} catch (Exception e) {
			System.out.println("exception coming");
			e.printStackTrace();
		}
		browser.closeBrowser();
	}
}
