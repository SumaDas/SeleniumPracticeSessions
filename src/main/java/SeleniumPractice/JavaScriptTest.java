package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptTest {
public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
//		String title = jsUtil.getTitleByJS();
//		System.out.println(title);
//		
//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
//		
//		if(pageText.contains("Deals & Sales Pipeline")) {
//			System.out.println("PASS");
//		}
		
		//jsUtil.refreshBrowserByJS();
//		jsUtil.drawBorder(loginButton);
		
		//jsUtil.generateAlert("App is launched....");
		
//		WebElement username = driver.findElement(By.name("username"));
//		WebElement password = driver.findElement(By.name("password"));
//		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		
//		jsUtil.flash(username);
//		username.sendKeys("batchautomation");
//		
//		jsUtil.flash(password);
//		password.sendKeys("Test@12345");
//
//		jsUtil.flash(loginButton);
//		loginButton.click();
		
		//jsUtil.getBrowserInfo();
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		WebElement h2Element = driver.findElement(By.xpath("//h2[text()='Handpicked fitness essentials']"));
//		jsUtil.scrollIntoView(h2Element);
		
		//jsUtil.clickElementByJS(element);
		
		WebElement hotelLink = driver.findElement(By.linkText("Hotels"));
		jsUtil.clickElementByJS(hotelLink);
		
		
		
		
	}

}
