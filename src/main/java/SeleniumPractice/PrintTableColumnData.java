package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintTableColumnData {
	static WebDriver driver;
	static String userName = "batchautomation";
	static String passWord = "Test@12345";
	public static void main(String[] args) throws InterruptedException {

		
		String loginTitle = "CRMPRO - CRM software for customer relationship management, sales, and support.";
		By usernameLocator = By.cssSelector("input[name='username']");
		By passwordLocator = By.cssSelector("input[name='password']");
		By loginBtn = By.cssSelector("input[type='submit']");
		String frameLocator = "mainpanel";
		By contactsMenu = By.linkText("CONTACTS");
		By columnData = By.xpath("(//table[@class='datacard'])[3]//td[2]");
		By pageLocator = By.xpath("(//div[@class='pagination']/select[@class='select'])[1]");
		int numberOfPages = 10;
		int timeOut = 10;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com");
		driver.manage().window().maximize();

		String loginPageTitle = waitForTtileTOBe(loginTitle, timeOut);
		System.out.println("Login Page Title :" + loginPageTitle);
		doLogin(usernameLocator, passwordLocator, loginBtn);
		driver = waitForFrameToBeAvailableAndSwitchToIt(frameLocator, timeOut);
		doActionsClick(contactsMenu);

		for (int i = 1; i <= numberOfPages; i++) {
			WebElement elepage = waitForElementPresent(pageLocator, timeOut);
			System.out.println("-------------Page " + i + " Data-------------");
			List<String> colList = getColumnData(columnData);
			colList.stream().forEach(ele -> System.out.println(ele));
			doSelectByIndex(pageLocator, (i + 1));
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSwitchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void doLogin(By usernameLocator, By passwordLocator, By loginBtn) {
		doSendKeys(usernameLocator, userName);
		doSendKeys(passwordLocator, passWord);
		doClick(loginBtn);
	}

	public static void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static List<String> getColumnData(By locator) {
		List<WebElement> colList = getElements(locator);
		List<String> columnData = new ArrayList<>();
		for (int i = 3; i < colList.size(); i++) {
			columnData.add(colList.get(i).getText());
		}
		return columnData;
	}

	/********** WAIT UTILS *******************/

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator used to find the element
	 * @param timeOut
	 * @return the WebElement once it is located
	 */
	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * If the frame is available it switches the given driver to the specified frame
	 * 
	 * @param frameLocator used to find the frame (id or name)
	 * @param timeOut
	 * @return WebDriver instance after frame has been switched
	 */
	public static WebDriver waitForFrameToBeAvailableAndSwitchToIt(String frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	/**
	 * An expectation for checking that the title contains a case-sensitive
	 * substring
	 * 
	 * @param title   the fragment of title expected
	 * @param timeOut
	 * @return title of page
	 */
	public static String waitForTtileTOBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

}
