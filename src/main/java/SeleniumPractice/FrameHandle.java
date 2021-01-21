package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandle {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "http://www.londonfreelance.org/courses/frames/index.html";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);
		System.out.println("Title is : " + wf.getPageTitle());

		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.waitForFrameToBeAvailableAndSwitchToIt(5,10);
		String footerText = eleUtil.doGetText(By.tagName("h2"));
		System.out.println("Footer text is :" + footerText);
		eleUtil.switchToDefaultContent();

		eleUtil.waitForFrameToBeAvailableAndSwitchToIt("main",10);
		String titleText = eleUtil.doGetText(By.tagName("h2"));
		System.out.println("Title text is : " + titleText);
		eleUtil.switchToDefaultContent();

		eleUtil.waitForFrameToBeAvailableAndSwitchToIt(By.name("navbar"),10);
		eleUtil.doClick(By.linkText("Home"));
		// String text = eleUtil.doGetText(By.tagName("h3"));
		// System.out.println(text);
		List<WebElement> linksList = eleUtil.getElements(By.tagName("a"));
		linksList.stream().forEach(ele -> System.out.println(ele.getText()));
		eleUtil.switchToDefaultContent();

		wf.closeBrowser();
	}
}
