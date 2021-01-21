package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintColData {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		By contactsMenu = By.linkText("CONTACTS");		
		By pageLocator = By.xpath("(//div[@class='pagination']/select[@class='select'])[1]");
		By usernameLocator = By.cssSelector("input[name='username']");
		By passwordLocator = By.cssSelector("input[name='password']");
		By loginBtn = By.cssSelector("input[type='submit']");
		
		String loginTitle = "CRMPRO - CRM software for customer relationship management, sales, and support.";
		String browserName = "chrome";
		String Url = "https://classic.freecrm.com/";
		String userName = "batchautomation";
		String passWord = "Test@12345";
		String frameLocator = "mainpanel";
		String startLocator = "table tr:nth-of-type(";
		String endLocator = ") td[class='datalistrow']:nth-of-type(2)";
		int numberOfPages = 10;
		int timeOut = 10;
		
		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);

		String loginPageTitle = eleUtil.waitForTtileToBe(loginTitle, timeOut);
		System.out.println("Login Page Title :" + loginPageTitle);
		eleUtil.doSendKeys(usernameLocator, userName);
		eleUtil.doSendKeys(passwordLocator, passWord);
		eleUtil.doClick(loginBtn);

		driver = eleUtil.waitForFrameToBeAvailableAndSwitchToIt(frameLocator, timeOut);
		eleUtil.doActionClick(contactsMenu);

		for (int i = 1; i <= numberOfPages; i++) {
			System.out.println("Page---->" + i + "------Data");
			List<String> pageColumnList = getColumnData(startLocator, endLocator);
			pageColumnList.forEach(ele -> System.out.println(ele));
			eleUtil.doClick(pageLocator);
			eleUtil.doSelectByIndex(pageLocator, (i + 1));

		}
	}
	/**
	 * This method gets the column data on specific page
	 * @param startLocator 
	 * @param endLocator
	 * @return List<String>
	 */
	public static List<String> getColumnData(String startLocator, String endLocator) {
		List<String> columnDataList = new ArrayList<>();
		for (int i = 4; i <= 24; i++) {
			By locator = By.cssSelector(startLocator +i+ endLocator);
			String text = getElement(locator).getText();
			columnDataList.add(text);
		}
		return columnDataList;
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
