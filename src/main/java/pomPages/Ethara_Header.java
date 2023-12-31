package pomPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Ethara_Header {

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

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			@SuppressWarnings("deprecation")
			URL newurl = new URL(url);
			HttpURLConnection httpconnect = (HttpURLConnection) newurl.openConnection();
			httpconnect.connect();

			int rescode = httpconnect.getResponseCode();
			if (rescode >= 400) {
				System.out.println(newurl + " - Page not found");
			}

//			else {
//				System.out.println(newurl + " - Page found");
//			}

		}

	}

	public void coming_soon() throws IOException {
		comingsoon_button.click();
		check_links();
	}

	public void contactus_button() throws IOException {
		contactus_button.click();
		check_links();
	}

	public void aboutus_button() throws IOException {
		aboutus_button.click();
		check_links();
	}

	public void close() {
		close_button.click();
	}

	public void menu() {
		menu_button.click();

	}

	public void comingup_category() throws IOException {
		comingup_button.click();
		check_links();
	}

	public void ourpeople() throws IOException {
		ourpeople_button.click();
		check_links();
	}

	public void menuOptions(WebDriver driver) throws InterruptedException {

		for (WebElement options : menuOptions) {
			Thread.sleep(1000);
			String Options = options.getText();

			// Thread.sleep(2000);
			System.out.println(Options);

		}
	}

	// very first try using for and for each loop but it executed for 6 times in 6
	// sets
	public void menuOptionsfun(WebDriver driver) throws InterruptedException {

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

			// Open a new tab using JavaScript to trigger the link in a new tab/window
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])",
					menuOptions.get(i).getAttribute("href"));

			// Switch to the newly opened tab
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1)); // Switch to the last opened tab total size 7-1 = 6
																	// index

			// Perform actions in the new tab
			Thread.sleep(2000);

			System.out.println(driver.getTitle()); // Print the title of the new tab

			driver.close();
			driver.switchTo().window(tabs.get(0));

			Thread.sleep(2000);

			// Redeclaring to avoid stale element exception
			menuOptions = driver.findElements(By.xpath("//div[contains(@class,'styles_nav-item__h4Zei')]//a"));
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

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
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

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		Thread.sleep(2000);

		String Actual_PagTitle_SP = driver.getTitle();
		System.out.println(Actual_PagTitle_SP);
		String Expected_PageTitle_SP = "Ethara | Sustainability Policy";
		a.assertEquals(Actual_PagTitle_SP, Expected_PageTitle_SP);

		driver.close();
		driver.switchTo().window(tabs.get(0));

	}

	public void social_media(WebDriver driver) throws InterruptedException {

		for (int i = 0; i < socialmediaicons.size(); i++) {

			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])",
					socialmediaicons.get(i).getAttribute("href"));

			Thread.sleep(2000);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));
			System.out.println(driver.getCurrentUrl());

			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}

//		
	}

}
