package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class is used to print column data in web table given by locator
 * 
 * @author Suma
 *
 */
public class WebTablePractice {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "http://demo.automationtesting.in/WebTable.html";
		int numberOfPages = 10;

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);

		By locator = By.cssSelector(".ui-grid-cell.ng-scope.ui-grid-coluiGrid-0005");
		By nextPage = By.cssSelector("button[title='Page forward']");
		
		eleUtil.getMultiplePageCellData(locator,nextPage,numberOfPages);
	}

}
