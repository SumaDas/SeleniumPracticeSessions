package SeleniumPractice;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonFooterLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		String browserName = "chrome";
		String Url = "https://www.amazon.com/";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);

		List<WebElement> getToKnowUsList = eleUtil
				.getElements(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/div[1]//li/a"));
		for (WebElement e : getToKnowUsList) {
			System.out.println(e.getText());
		}
		System.out.println("-------------------------------------------");

		List<WebElement> makeMoneyWithUsList = eleUtil
				.getElements(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/div[3]//li/a"));
		for (int i = 0; i < makeMoneyWithUsList.size(); i++) {
			String text = makeMoneyWithUsList.get(i).getText();
			System.out.println(text);
		}
		System.out.println("----------------------------------------");

		List<WebElement> paymentProductsList = eleUtil
				.getElements(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/div[5]//li/a"));
		Iterator<WebElement> ite = paymentProductsList.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next().getText());
		}
		System.out.println("------------------------------------");

		List<WebElement> letUsHelpYouList = eleUtil
				.getElements(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/div[7]//li/a"));
		ListIterator<WebElement> li = letUsHelpYouList.listIterator();
		while(li.hasNext())
		{
			System.out.println(li.next().getText());
		}
		
		//wf.closeBrowser();
	}

}
