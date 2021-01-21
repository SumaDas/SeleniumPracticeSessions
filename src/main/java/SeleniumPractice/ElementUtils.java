package SeleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	// Select select;
	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetAttribute(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}

	public void clickOnElementWithText(By locator, String text) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			if (e.getText().equalsIgnoreCase(text))
				e.click();
			break;
		}
	}

	public void clickElement(By locator, String value) {
		List<WebElement> eleList = getElements(locator);
		System.out.println(eleList.size());

		for (int i = 0; i < eleList.size(); i++) {
			String text = eleList.get(i).getText();
			System.out.println(text);
			if (text.equals(value)) {
				eleList.get(i).click();
				break;
			}

		}
	}

	public boolean checkElementPresent(By locator) {
		if (getElements(locator).size() > 0) {
			return true;
		}
		return false;
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	/******************* DROPDOWN SELECTION ******************************/

	public void doDropDownSelection(By locator, String type, String value) {

		// Select select = new Select(getElement(locator));
		switch (type) {
		case ("index"):
			doSelectByIndex(locator, Integer.parseInt(value));
			break;
		case ("value"):
			doSelectByValue(locator, value);
			break;
		case ("visibleText"):
			doSelectByVisibleText(locator, value);
			break;
		default:
			System.out.println("please pass the correct selection");
			break;
		}

	}

	/**
	 * Select the option at the given index. This is done by examining the "index"
	 * attribute of an element, and not merely by counting.
	 * 
	 * @param locator
	 * @param index   Throws NoSuchElementException If no matching option elements
	 *                are found
	 */
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	/**
	 * Select all options that have a value matching the argument.
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	/**
	 * Select all options that display text matching the argument
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	/**
	 * get the list of dropdown option values
	 * 
	 * @param locator
	 * @return optionsList
	 */
	public List<String> getDropDownOptionsValues(By locator) {
		List<String> optionsValList = new ArrayList<>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValList.add(text);
		}
		return optionsValList;
	}

	/**
	 * Select an option from dropdown with the given value
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}

		}

	}

//*******************ACTIONS CLASS UTILS***************************************
	/**
	 * Move to the specified element using Actions class
	 * 
	 * @param locator Target locator
	 */
	public void doMoveToElement(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).perform();
	}

	/**
	 * Click on an element with using Actions class
	 * 
	 * @param locator Target locator
	 */
	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}

	/**
	 * Performs click and sendkeys on target element
	 * 
	 * @param locator Target locator
	 * @param value   Text to be sent
	 */
	public void doActionsSendkeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}

	/**
	 * Move to the specified Element and Click on it
	 * 
	 * @param locator Target Locator
	 */
	public void doMoveToElementAndClick(By locator) {
		doMoveToElement(locator);
		doActionsClick(locator);
	}

	/**
	 * Move to the specified Element and enter text in it
	 * 
	 * @param locator Target Locator
	 * @param value   Text to be entered
	 */
	public void doMoveToElementAndSendkeys(By locator, String value) {
		doMoveToElement(locator);
		doActionsSendkeys(locator, value);
	}

	/**
	 * Clicks on SrcElement drag and drop on Target element
	 * 
	 * @param srcLocator
	 * @param targetLocator
	 */
	public void doActionsDragAndDrop(By srcLocator, By targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getElement(srcLocator), getElement(targetLocator)).perform();
	}

	/**
	 * Clicks on Sub Menu
	 * 
	 * @param parentMenu
	 * @param firstSubMenu
	 */
	public void doClickOnSubMenu(By parentMenu, By firstSubMenu) {
		doMoveToElement(parentMenu);
		doMoveToElementAndClick(firstSubMenu);
	}

	/**
	 * Clicks on second Sub Menu
	 * 
	 * @param parentMenu
	 * @param firstSubMenu
	 * @param secondSubMenu
	 */
	public void doClickOnSubMenu(By parentMenu, By firstSubMenu, By secondSubMenu) {
		doMoveToElement(parentMenu);
		doMoveToElement(firstSubMenu);
		doMoveToElementAndClick(secondSubMenu);
	}

	/*********** FRAME METHODS **********/

	/**
	 * If the frame is available it switches the given driver to the specified frame
	 * 
	 * @param frameLocator used to find the frame (id or name)
	 * @param timeOut
	 * @return WebDriver instance after frame has been switched
	 */
	public WebDriver waitForFrameToBeAvailableAndSwitchToIt(String frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	/**
	 * If the frame is available it switches the given driver to the specified
	 * frameIndex.
	 * 
	 * @param frameLocator used to find the frame (index)
	 * @param timeOut
	 * @return
	 */
	public WebDriver waitForFrameToBeAvailableAndSwitchToIt(int frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	/**
	 * If the frame is available it switches the given driver to the specified
	 * webelement
	 * 
	 * @param frameLocator used to find the frame (webelement)
	 * @param timeOut
	 * @return
	 */
	public WebDriver waitForFrameToBeAvailableAndSwitchToIt(WebElement frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	/**
	 * If the frame is available it switches the given driver to the specified
	 * frame.
	 * 
	 * @param locator used to find the frame
	 * @param timeOut
	 * @return WebDriver instance after frame has been switched
	 */
	public WebDriver waitForFrameToBeAvailableAndSwitchToIt(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	/**
	 * Switches to the element that currently has focus within the document
	 * currently "switched to", or the body element if this cannot be detected.
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/*************** WebTable Methods ********************************/

	/**
	 * This method will get each cell data in web table
	 * 
	 * @param locator
	 * @return List<String>
	 */
	public List<String> getAllCellDataInTable(By locator) {
		List<WebElement> dataList = getElements(locator);
		List<String> textList = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {
			// System.out.println();
			String text = dataList.get(i).getText();
			textList.add(text);
		}
		return textList;
	}

	/**
	 * This method will display cell data / column data depending on locator, in
	 * multiple pages
	 * 
	 * @param locator
	 * @param nextPage      button
	 * @param numberOfPages
	 */

	public void getMultiplePageCellData(By locator, By nextPage, int numberOfPages) {
		for (int i = 1; i <= numberOfPages; i++) {
			System.out.println("-------------------Page ----> " + i);
			List<String> cellDataList = getAllCellDataInTable(locator);
			cellDataList.stream().forEach(ele -> System.out.println(ele));
			doClick(nextPage);
		}
	}

	/********************* WAIT UTILS ***************************/

	public List<WebElement> visiblityOfAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void getPageElementsText(By locator, int timeOut) {
		visiblityOfAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
	}

	/**
	 * An expectation for checking that an element, known to be present on the DOM
	 * of a page, is visible. Visibility means that the element is not only
	 * displayed but also has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	/**
	 * An expectation for the URL of the current page to contain specific text.
	 * 
	 * @param urlValue - the fraction of the url that the page should be on
	 * @param timeOut
	 * @return true when the URL contains the text
	 */

	public boolean waitForUrlToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(urlValue));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator used to find the element
	 * @param timeOut
	 * @return the WebElement once it is located
	 */
	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * An expectation for checking that the title contains a case-sensitive
	 * substring
	 * 
	 * @param title   the fragment of title expected
	 * @param timeOut
	 * @return title of page
	 */
	public String waitForTtileToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param locator
	 * @param timeOut
	 */
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	/**
	 * Wait until an element is no longer attached to the DOM.
	 * 
	 * @param locator of the element to wait for.
	 * @param timeOut
	 * @return false if the element is still attached to the DOM, true otherwise
	 */
	public boolean waitForStaleElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.stalenessOf(getElement(locator)));
	}

	/**
	 * An expectation for checking that the title contains a case-sensitive
	 * substring
	 * 
	 * @param title
	 * @param timeOut
	 * @return title of page
	 */

	public String waitForTitleToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	/*************** ALERT METHODS *********************/

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptJSAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public void dismissJSAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	/*************** FLUENTWAIT METHODS *********************/

	/**
	 * this method is checking the presence of element using FluentWait
	 * 
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return
	 */
	public WebElement waitForElementWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * this method is checking the presence of element using FluentWait
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementWithFluentWait(By locator, int timeOut) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/******************* JS METHODS **************/

	/**
	 * This method will check the page is fully loaded or not
	 * 
	 * @param timeOut
	 */
	public void jsWaitForPageLoad(int timeOut) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String jsCommand = "return document.readyState";
		if (jse.executeScript(jsCommand).toString().equals("complete")) {
			System.out.println("page is fully loaded");
			return;
		}

		for (int i = 0; i < timeOut; i++) {
			try {
				Thread.sleep(500);

				if (jse.executeScript(jsCommand).toString().equals("complete")) {
					System.out.println("page is fully loaded");
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
