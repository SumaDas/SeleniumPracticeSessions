package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ESPNCricInfoData {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "https://www.espncricinfo.com/series/india-in-australia-2020-21-1223867/australia-vs-india-1st-test-1223869/full-scorecard";
		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);
		By locator = By.xpath("(//a[text()='Virat Kohli'])[1]/../following-sibling::td");

		List<String> playerScroeCardList = eleUtil.getAllCellDataInTable(locator);
		playerScroeCardList.stream().forEach(ele -> System.out.println(ele));

	}

}
