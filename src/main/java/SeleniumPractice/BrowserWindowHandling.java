package SeleniumPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowHandling {

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
		String parentWindowId = driver.getWindowHandle();
		System.out.println("parent window id is : " + parentWindowId);
		eleUtil.doClick(fbImage);
		eleUtil.doClick(linkedInImage);
		eleUtil.doClick(twitterImage);
		eleUtil.doClick(youTubeImage);
		Set<String> allWindowIds = driver.getWindowHandles();

		Iterator<String> ite = allWindowIds.iterator();
		parentWindowId = ite.next();
		while (ite.hasNext()) {
			String childWindowId = ite.next();
			System.out.println("child window id is : " + childWindowId);
			driver.switchTo().window(childWindowId);
			System.out.println("Child window title is : " + wf.getPageTitle());
			wf.closeBrowser();
		}
		wf.quitBrowser();
	}
}
