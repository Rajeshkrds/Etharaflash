package pomPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Ethara_Footer {

	SoftAssert a = new SoftAssert();
	@FindBy(xpath = "//div[@class=\"styles_foot-top__xOKrc\"]/nav//a")
	private List<WebElement> hyperlinks;

	@FindBy(xpath = "(//a[contains(text(),'Terms & Conditions')])[1]")
	private WebElement TandC;

	@FindBy(xpath = "(//a[contains(text(),'Privacy Policy')])[1]")
	private WebElement privacy;

	@FindBy(xpath = "(//a[contains(text(),'Sustainability Policy')])[1]")
	private WebElement Sustainability;

	@FindBy(xpath = "//div[@class='styles_foot-top__xOKrc']/div//a")
	private List<WebElement> socialmediaicons;

	public Ethara_Footer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void get_footerOptions() throws InterruptedException {

		for (WebElement Options : hyperlinks) {
			Thread.sleep(1000);
			String footeroptions = Options.getText();
			System.out.println(footeroptions);

		}
	}

	public void hperlinkFun(WebDriver driver) throws InterruptedException {
		for (int i = 0; i < hyperlinks.size(); i++) {
			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])",
					hyperlinks.get(i).getAttribute("href"));

			ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));

			System.out.println(driver.getTitle());
			Thread.sleep(2000);

			driver.close();
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(2000);

		}
	}

	public void terms_and_conditions(WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", TandC.getAttribute("href"));

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		Thread.sleep(2000);

		String Actual_PagTitle = driver.getTitle();
		System.out.println(Actual_PagTitle);
		String Expected_PageTitle = "Ethara | Terms and Conditions";
		a.assertEquals(Actual_PagTitle, Expected_PageTitle);

		driver.close();
		driver.switchTo().window(tabs.get(0));

	}

	public void privacy(WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", privacy.getAttribute("href"));

		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		Thread.sleep(2000);

		String Actual_PagTitle_PP = driver.getTitle();
		System.out.println(Actual_PagTitle_PP);
		String Expected_PageTitle_PP = "Ethara | Privacy Policy";
		a.assertEquals(Actual_PagTitle_PP, Expected_PageTitle_PP);

		driver.close();
		driver.switchTo().window(tabs.get(0));

	}

	public void sustainability(WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", Sustainability.getAttribute("href"));

		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		Thread.sleep(2000);

		String Actual_PagTitle_SP = driver.getTitle();
		System.out.println(Actual_PagTitle_SP);
		String Expected_PageTitle_SP = "Ethara | Sustainability Policy";
		a.assertEquals(Actual_PagTitle_SP, Expected_PageTitle_SP);

		driver.close();
		driver.switchTo().window(tabs.get(0));

	}

	public void socialmedia(WebDriver driver) throws InterruptedException {
		for (int i = 0; i < socialmediaicons.size(); i++) {
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])",
					socialmediaicons.get(i).getAttribute("href"));

			ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));
			System.out.println(driver.getCurrentUrl());

			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}
}
