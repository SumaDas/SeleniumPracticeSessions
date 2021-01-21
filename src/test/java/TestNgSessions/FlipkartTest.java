package TestNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartTest extends BaseTest {
	@Test(priority = 1)
	public void flipkartTitleTest() {
		driver.get("https://www.flipkart.com/");
		String title = driver.getTitle();
		System.out.println("page title is :" + title);
		Assert.assertTrue(title.contains("Online Shopping"));
	}

	@Test(priority = 2)
	public void flipkartLogoTest() {
		Assert.assertTrue(driver.findElement(By.className("_2xm1JU")).isDisplayed());
	}
}
