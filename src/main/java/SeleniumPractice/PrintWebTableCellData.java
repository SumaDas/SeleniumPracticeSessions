package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintWebTableCellData {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "http://demo.automationtesting.in/WebTable.html";
		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);

		By locator = By.cssSelector(".ui-grid-cell-contents.ng-binding.ng-scope");
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("-------------------Page ----> " + i);
			List<String> cellDataList = eleUtil.getAllCellDataInTable(locator);
			cellDataList.stream().forEach(ele -> System.out.println(ele));
			eleUtil.doClick(By.cssSelector("button[title='Page forward']"));
		}

	}

}
