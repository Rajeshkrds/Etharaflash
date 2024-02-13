package pomPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Ethara_Header {

	Logger log = Logger.getLogger(this.getClass().getName());

	SoftAssert a = new SoftAssert();
	// public WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Coming soon')]")
	private WebElement comingsoon_button;

	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement contactus_button;

	@FindBy(xpath = "//a[contains(text(),'About us')]")
	private WebElement aboutus_button;

	@FindBy(xpath = "//a[contains(text(),'Book now')]")
	private WebElement comingup_button;

	@FindBy(xpath = "//a[contains(text(),'Our people')]")
	private WebElement ourpeople_button;

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	private WebElement menu_button;

	@FindBy(xpath = "//button[contains(text(),'close')]")
	private WebElement close_button;

	@FindBy(xpath = "//div[contains(@class,'styles_nav-item__h4Zei')]//a")
	private List<WebElement> menuOptions;

	@FindBy(xpath = "(//a[contains(text(),'Terms & Conditions')])[1]")
	private WebElement TandC;

	@FindBy(xpath = "(//a[contains(text(),'Privacy Policy')])[1]")
	private WebElement privacy;

	@FindBy(xpath = "(//a[contains(text(),'Sustainability Policy')])[1]")
	private WebElement Sustainability;

	@FindBy(xpath = "//div[@class='styles_head-foot__wXy2D']//div[1]//a")
	private List<WebElement> socialmediaicons;

	@FindBy(tagName = "a")
	private List<WebElement> links;

	public Ethara_Header(WebDriver driver) {
		// TODO Auto-generated constructor stub
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void check_links() throws IOException {

		log.info("Testing broken link");
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			@SuppressWarnings("deprecation")
			URL newurl = new URL(url);
			HttpURLConnection httpconnect = (HttpURLConnection) newurl.openConnection();
			httpconnect.connect();

			int rescode = httpconnect.getResponseCode();
			if (rescode >= 400) {
				// System.out.println(url + " - Page not found (Response code: " + rescode +
				// ")");

				log.info("Page not found - (Response Code : " + rescode + ")");

			}

//			else {
//				System.out.println(newurl + " - Page found");
//			}

		}

	}

	public void coming_soon() throws IOException {
		log.info("Clicking on Coming soon button in header");
		comingsoon_button.click();
		check_links();
	}

	public void contactus_button() throws IOException {
		log.info("Clicking on contact us button ini header");
		contactus_button.click();
		// check_links();
	}

	public void aboutus_button() throws IOException {
		log.info("Clicking on about us button in header");
		aboutus_button.click();
		// check_links();
	}

	public void close() {
		log.info("Clicking on close button in header ");
		// close_button.click();
	}

	public void menu() {
		log.info("Clicking on Menu button in header ");
		menu_button.click();

	}

	public void comingup_category() throws IOException {
		log.info("Clicking on Comingup button");
		comingup_button.click();
		// check_links();
	}

	public void ourpeople() throws IOException {
		log.info("Clicking on our people button in header ");
		ourpeople_button.click();
		// check_links();
	}

	public void menuOptions(WebDriver driver) throws InterruptedException {

		for (WebElement options : menuOptions) {
			Thread.sleep(1000);
			String Options = options.getText();

			// Thread.sleep(2000);

			log.info(Options);
			// System.out.println(Options);

		}
	}

	// very first try using for and for each loop but it executed for 6 times in 6
	// sets
	public void menuOptionsfun(WebDriver driver) throws InterruptedException, IOException {

		log.info("Testing Menu options");

		// geting all options form menu list
//		for(WebElement options : menuOptions) 
//		{
//			Thread.sleep(2000);
//			String Options = options.getText().toLowerCase();
//			//Thread.sleep(2000);
//			//System.out.println(Options);
//			//String Loptions = Options.toLowerCase();
//			//WebElement Element = driver.findElement(By.xpath("(//a[contains(translate (text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"+Loptions+"')])[1]"));		
////			Actions actions = new Actions(driver);
////			actions.contextClick(Element).perform();
////			actions.sendKeys(Keys.CONTROL, "t").perform();
//			for(int i = 0; i<menuOptions.size();i++)
//			{
//				((JavascriptExecutor)driver).executeScript("window.open(arguments[0])", menuOptions.get(i).getAttribute("href"));
//				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//		        driver.switchTo().window(tabs.get(tabs.size() - 1));
//		        
//		        
//				System.out.println(driver.getTitle());
//				
//				driver.close();
//				driver.switchTo().window(tabs.get(0));
//	//			Thread.sleep(2000);
//	//			driver.navigate().back();
//	//			Thread.sleep(2000);
//	//			menu();
//				Thread.sleep(2000);
//				  menuOptions = driver.findElements(By.xpath("//div[contains(@class,'styles_nav-item__h4Zei')]//a"));

		// second try
//		String currentTab = driver.getWindowHandle(); // Get the current tab handle
//
//	    for (WebElement option : menuOptions) {
//	        Thread.sleep(2000);
//	        String optionText = option.getText().toLowerCase();
//	        
//	        // Open a new tab using JavaScript to trigger the link in a new tab/window
//	        ((JavascriptExecutor)driver).executeScript("window.open(arguments[0])", option.getAttribute("href"));
//	        
//	        // Switch to the newly opened tab
//	        for (String tab : driver.getWindowHandles()) {
//	            if (!tab.equals(currentTab)) {
//	                driver.switchTo().window(tab);
//	                break;
//	            }
//	        }
//
//	        // Perform actions in the new tab
//	        Thread.sleep(2000);
//	        System.out.println(driver.getTitle()); // Print the title of the new tab
//	        
//	        // Optionally close the new tab or switch back to the original tab
//	        // driver.close();
//	        // driver.switchTo().window(currentTab);
//	        
//	        Thread.sleep(2000);
//
//	    }

		// avoiding for each loop to exectue only one time for 6 options
		for (int i = 0; i < menuOptions.size(); i++) {
			Thread.sleep(2000);

			String current_url = menuOptions.get(i).getAttribute("href");

			// Open a new tab using JavaScript to trigger the link in a new tab/window
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", current_url);

			// Switch to the newly opened tab
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1)); // Switch to the last opened tab total size 7-1 = 6
																	// index

			URL newurl = new URL(current_url);

			HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
			httpConnect.connect();

			int rescode = httpConnect.getResponseCode();

			if (rescode >= 400) {
				log.info(current_url + " - Page not found (Response code: " + rescode + ")");
				// System.out.println(current_url + " - Page not found (Response code: " +
				// rescode + ")");
			} else {
				// Perform actions in the new tab
				Thread.sleep(2000);

				// System.out.println(driver.getTitle()); // Print the title of the new tab
				log.info("Getting Page Title " + driver.getTitle());
				driver.close();
				driver.switchTo().window(tabs.get(0));

				Thread.sleep(2000);

				// Redeclaring to avoid stale element exception
				menuOptions = driver.findElements(By.xpath("//div[contains(@class,'styles_nav-item__h4Zei')]//a"));
			}

		}
	}

	public void terms_and_conditions(WebDriver driver) throws InterruptedException, IOException {
		log.info("Testing Terms and conditions");

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
			// System.out.println(current_url + " - Page not found (Response code: " +
			// rescode + ")");
		} else {
			Thread.sleep(2000);

			String Actual_PagTitle = driver.getTitle();
			log.info("Getting Actual Page Title " + Actual_PagTitle);
			// System.out.println(Actual_PagTitle);
			String Expected_PageTitle = "Ethara | Terms and Conditions";
			a.assertEquals(Actual_PagTitle, Expected_PageTitle);

			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}

	public void privacy(WebDriver driver) throws InterruptedException, IOException {
		log.info("Testing privacy policy");
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
			// System.out.println(current_url + " - Page not found (Response code: " +
			// rescode + ")");
		} else {
			Thread.sleep(2000);

			String Actual_PagTitle = driver.getTitle();
			log.info("Getting Actual Page Title " + Actual_PagTitle);
			// System.out.println(Actual_PagTitle);
			String Expected_PageTitle = "Ethara | Privacy Policy";
			a.assertEquals(Actual_PagTitle, Expected_PageTitle);

			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}

	public void sustainability(WebDriver driver) throws InterruptedException, IOException {
		log.info("Testing sustainability ");
		String current_url = Sustainability.getAttribute("href");

		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", current_url);

		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		URL newurl = new URL(current_url);

		HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
		httpConnect.connect();

		int rescode = httpConnect.getResponseCode();

		if (rescode >= 400) {
			log.info(current_url + " - Page not found (Response code: " + rescode + ")");
			// System.out.println(current_url + " - Page not found (Response code: " +
			// rescode + ")");
		} else {
			Thread.sleep(2000);

			String Actual_PagTitle_SP = driver.getTitle();
			log.info("Getting Actual Page Title " + Actual_PagTitle_SP);
			// System.out.println(Actual_PagTitle_SP);
			String Expected_PageTitle_SP = "Ethara | Sustainability Policy";
			a.assertEquals(Actual_PagTitle_SP, Expected_PageTitle_SP);

			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}

	public void socialmedia(WebDriver driver) throws InterruptedException, IOException {

		log.info("Testing social media icons");
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
				// System.out.println(current_url + " - Page not found (Response code: " +
				// rescode + ")");
			} else {
				log.info(driver.getTitle());
				// System.out.println(driver.getTitle());
				Thread.sleep(2000);
				log.info("Getting current Url " + driver.getCurrentUrl());
				// System.out.println(driver.getCurrentUrl());
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(2000);
			}
		}
	}
}
