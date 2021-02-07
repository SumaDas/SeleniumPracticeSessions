package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalenderHandling {
	static ElementUtils eleUtil;	
	public static void main(String[] args){
		WebDriver driver;
		String browserName = "chrome";
		String url = "https://www.goibibo.com/";
		String monthYear = "september 2021";
		String day = "17";
		By departure = By.id("departureCalendar");
		By monthYearLocator = By.cssSelector("div.DayPicker-Caption");
		By dayLocator = By.cssSelector("div.calDate");
		By nextNavBtn = By.className("DayPicker-NavButton--next");

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(url);
		String title = wf.getPageTitle();
		System.out.println("page title is : " + title);

		eleUtil = new ElementUtils(driver);
		eleUtil.doClick(departure);

		while (!(eleUtil.getElement(monthYearLocator).getText()).equalsIgnoreCase(monthYear)) {
			eleUtil.doClick(nextNavBtn);
		}
		selectDay(dayLocator, day);
	}

	public static void selectDay(By locator, String day) {
		List<WebElement> dayList = eleUtil.getElements(locator);
		for (WebElement e : dayList) {
			String dayText = e.getText();
			if (dayText.equals(day)) {
				e.click();
				break;
			}
		}
	}

}
