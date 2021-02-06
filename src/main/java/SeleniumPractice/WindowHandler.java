package SeleniumPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandler {
	
	public static void main(String[] args) {
		WebDriver driver;
		String browserName = "chrome";
		String url = "https://opensource-demo.orangehrmlive.com/";
		By fbImage = By.cssSelector("img[alt='OrangeHRM on Facebook']");
		By twitterImage = By.cssSelector("img[alt='OrangeHRM on twitter']");
		By linkedInImage = By.cssSelector("img[alt='LinkedIn OrangeHRM group']");
		By youTubeImage = By.cssSelector("img[alt='OrangeHRM on youtube']");

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(url);

		String title = wf.getPageTitle();
		System.out.println("page title is : " + title);
		ElementUtils eleUtil = new ElementUtils(driver);

		List<By> childWindowList = new ArrayList<By>();
		childWindowList.add(fbImage);
		childWindowList.add(linkedInImage);
		childWindowList.add(twitterImage);
		childWindowList.add(youTubeImage);

		for (By locator : childWindowList) {
			eleUtil.doClick(locator);
			Set<String> allWindowIds = driver.getWindowHandles();
			Iterator<String> ite = allWindowIds.iterator();

			String parentWindowId = ite.next();
			String parentWindowTitle = wf.getPageTitle();
			System.out.println("Parent window title is :" + parentWindowTitle);

			String childWindowId = ite.next();
			driver.switchTo().window(childWindowId);
			String childWindowTitle = wf.getPageTitle();
			System.out.println("child window title is : " + childWindowTitle);
			wf.closeBrowser();
			driver.switchTo().window(parentWindowId);
			System.out.println("parent window title is :" + driver.getTitle());
		}
		wf.quitBrowser();
	}
}
