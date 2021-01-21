package SeleniumPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertDemo {
	static WebDriver driver;
	public static void main(String[] args) {
	
		String browserName = "chrome";
		String Url = "https://mail.rediff.com/cgi-bin/login.cgi";

		WebDriverFactory wf = new WebDriverFactory();
		driver = wf.startBrowser(browserName);
		wf.launchUrl(Url);

		ElementUtils eleUtil = new ElementUtils(driver);

		eleUtil.doClick(By.name("proceed"));
		
		eleUtil.waitForAlert(10);
		String text = eleUtil.getAlertText(10);
				
		System.out.println(text);
		
		//eleUtil.acceptJSAlert(10);
		eleUtil.dismissJSAlert(10);
		
		eleUtil.switchToDefaultContent();
		
		
		
		

	}

}
