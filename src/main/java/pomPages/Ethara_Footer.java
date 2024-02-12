package pomPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Ethara_Footer {

	Logger log = Logger.getLogger(this.getClass().getName());

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

		log.info("Testing footer");

		for (WebElement Options : hyperlinks) {
			Thread.sleep(1000);
			String footeroptions = Options.getText();
			log.info(footeroptions);

		}

	}

	public void hperlinkFun(WebDriver driver) throws InterruptedException, IOException {
		log.info("Testing Footer links");
		for (int i = 0; i < hyperlinks.size(); i++) {
			Thread.sleep(2000);
			String current_url = hyperlinks.get(i).getAttribute("href");
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])",
					hyperlinks.get(i).getAttribute("href"));

			ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));

			URL newurl = new URL(current_url);

			HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
			httpConnect.connect();

			int rescode = httpConnect.getResponseCode();

			if (rescode >= 400) {
				log.info(current_url + " - Page not found (Response code: " + rescode + ")");
			} else {
				log.info(driver.getTitle());
				Thread.sleep(2000);

				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(2000);
			}

		}
	}

	public void terms_and_conditions(WebDriver driver) throws InterruptedException, IOException {

		log.info("Clicking on terms and conditions");

		String current_url = TandC.getAttribute("href");

		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", current_url);

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));

		URL newurl = new URL(current_url);

		HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
		httpConnect.connect();

		int rescode = httpConnect.getResponseCode();

		if (rescode >= 400) {
			log.info(current_url + " - Page not found (Response code: " + rescode + ")");
		} else {
			Thread.sleep(2000);

			String Actual_PagTitle = driver.getTitle();
			log.info(Actual_PagTitle);
			String Expected_PageTitle = "Ethara | Terms and Conditions";
			a.assertEquals(Actual_PagTitle, Expected_PageTitle);

			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}

	public void privacy(WebDriver driver) throws InterruptedException, IOException {
		log.info("Clicking on Privacy policy");
		String current_url = privacy.getAttribute("href");

		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", current_url);

		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		URL newurl = new URL(current_url);

		HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
		httpConnect.connect();

		int rescode = httpConnect.getResponseCode();

		if (rescode >= 400) {
			log.info(current_url + " - Page not found (Response code: " + rescode + ")");
		} else {
			Thread.sleep(2000);

			String Actual_PagTitle = driver.getTitle();
			log.info(Actual_PagTitle);
			String Expected_PageTitle = "Ethara | Privacy Policy";
			a.assertEquals(Actual_PagTitle, Expected_PageTitle);

			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}

	public void sustainability(WebDriver driver) throws InterruptedException, IOException {

		log.info("Clicking on Sustainability link");
		String current_url = Sustainability.getAttribute("href");

		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", current_url);

		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		URL newurl = new URL(current_url);

		HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
		httpConnect.connect();

		int rescode = httpConnect.getResponseCode();

		if (rescode >= 400) {
			System.out.println(current_url + " - Page not found (Response code: " + rescode + ")");
		} else {
			Thread.sleep(2000);

			String Actual_PagTitle_SP = driver.getTitle();
			log.info(Actual_PagTitle_SP);
			String Expected_PageTitle_SP = "Ethara | Sustainability Policy";
			a.assertEquals(Actual_PagTitle_SP, Expected_PageTitle_SP);

			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}

	public void socialmedia(WebDriver driver) throws InterruptedException, IOException {

		log.info("Clicking on social media icons");

		for (int i = 0; i < socialmediaicons.size(); i++) {
			String current_url = socialmediaicons.get(i).getAttribute("href");

			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", current_url);

			ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));
			URL newurl = new URL(current_url);

			HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
			httpConnect.connect();

			int rescode = httpConnect.getResponseCode();

			if (rescode >= 400) {
				log.info(current_url + " - Page not found (Response code: " + rescode + ")");
			} else {
				log.info("Current page title " + driver.getTitle());
				Thread.sleep(2000);
				log.info("Current page url " + driver.getCurrentUrl());
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(2000);
			}
		}
	}
}
