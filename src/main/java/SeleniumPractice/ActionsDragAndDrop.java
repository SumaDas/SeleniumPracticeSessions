package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsDragAndDrop {
	static WebDriver driver;
	public static void main(String[] args) {
		
		String browserName = "chrome";
		String Url = "https://jqueryui.com/resources/demos/droppable/default.html";
		
		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);
		
		By srcLocator = By.xpath("//div[@id='draggable']");
		By targetLocator = By.xpath("//div[@id='droppable']");
		eleUtil.doActionsDragAndDrop(srcLocator,targetLocator);

	}

}
