package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FreshWorksFooterLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "Chrome";
		String Url = "https://www.freshworks.com/";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);
		List<WebElement> freshworksList = eleUtil.getElements(By.xpath("//div[@class='col-sm-6'][1]/ul/li/a"));
		for (int i = 0; i < freshworksList.size(); i++) {
			System.out.println(freshworksList.get(i).getText());
		}
		System.out.println("-----------------------------------");
		
		List<WebElement> companyList = eleUtil.getElements(By.xpath("//div[@class='col-sm-6'][2]/ul/li/a"));
		for (int i = 0; i < companyList.size(); i++) {
			System.out.println(companyList.get(i).getText());
		}
		System.out.println("--------------------------");
		
		List<WebElement> eventsList = eleUtil.getElements(By.xpath("//div[@class='col-sm-4'][1]//li/a"));
		for (int i = 0; i < eventsList.size(); i++) {
			System.out.println(eventsList.get(i).getText());
		}
		System.out.println("--------------------------");
		
		List<WebElement> caseStudiesList = eleUtil.getElements(By.xpath("//div[@class='col-sm-4'][2]//li/a"));
		for (int i = 0; i < caseStudiesList.size(); i++) {
			System.out.println(caseStudiesList.get(i).getText());
		}
		System.out.println("--------------------------");
		
		List<WebElement> connectWithUsList = eleUtil.getElements(By.xpath("//div[@class='col-sm-4'][3]//li/a"));
		for (int i = 0; i < connectWithUsList.size(); i++) {
			System.out.println(connectWithUsList.get(i).getAttribute("href"));
		}
		//wf.closeBrowser();
	}

}
