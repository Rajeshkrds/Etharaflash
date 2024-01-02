package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class webUtilities {

//	public void scrolldown(WebDriver driver) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,250)", "");
//	}

	public void backward(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public String getPageTitle(WebDriver driver) {
		if (driver != null) {
			return driver.getTitle();
		} else {
			return "Driver is null"; // Handle null driver scenario
		}
	}

	public void delay() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void validation(String actual, String expected) {
		SoftAssert a = new SoftAssert();
		a.assertEquals(actual, expected);
	}

	public void scrolldown(WebDriver driver) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.ARROW_DOWN).perform();
	}
}
