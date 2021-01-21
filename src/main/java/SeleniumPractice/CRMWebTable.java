package SeleniumPractice;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRMWebTable {
	static WebDriver driver;
	public static void main(String[] args) {		
		
		By usernameLocator = By.cssSelector("input[name='username']");
		By passwordLocator = By.cssSelector("input[name='password']");
		By loginBtn = By.cssSelector("input[type='submit']");
		By contactsMenu = By.linkText("CONTACTS");	
		By rowXpath = By.xpath("(//table[@class='datacard'])[3]//tr/td[2]");
		
		String browserName = "chrome";
		String Url = "https://classic.freecrm.com/";
		String userName = "batchautomation";
		String passWord = "Test@12345";
		String frameLocator = "mainpanel";
		
		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.doSendKeys(usernameLocator, userName);
		eleUtil.doSendKeys(passwordLocator, passWord);
		eleUtil.doClick(loginBtn);

		driver.switchTo().frame(frameLocator);
		
		eleUtil.doActionClick(contactsMenu);
		
		List<WebElement> colList =eleUtil. getElements(rowXpath);
		for(int i=3;i<colList.size();i++)
		{
			String text = colList.get(i).getText();
			System.out.println(text);
		}
	}

	
}
