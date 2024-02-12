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

public class Ethara_Venues {

	Logger log = Logger.getLogger(this.getClass().getName());

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	private WebElement menu_button;

	@FindBy(xpath = "(//a[contains(text(),'Venues')])[1]")
	private WebElement venues;

	@FindBy(tagName = "a")
	private List<WebElement> links;

	@FindBy(xpath = "(//div[@class='container'])[4]//a")
	private List<WebElement> venue_lists;

	@FindBy(xpath = "(//div[@class='container'])[4]//a[1]")
	private WebElement Etihad_Park;

	@FindBy(xpath = "//div[@class='ri-select__control css-4w1vf7-control']")
	private WebElement direction_dd;

	@FindBy(xpath = "//div[@class='ri-select__menu-list css-qr46ko']")
	private List<WebElement> options;

	@FindBy(xpath = "//div[@class=\"ri-select__single-value css-bv5e9a-singleValue\"]")
	private WebElement option_name;

	@FindBy(xpath = "//div[@class=\"styles_ri-tab__NVjW0\"]//button")
	private List<WebElement> buttons;

	public Ethara_Venues(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void venuesPage(WebDriver driver) throws InterruptedException, IOException {
		log.info("Clicking on Menu from header");
		menu_button.click();
		Thread.sleep(1500);
		log.info("Clicking on Venues Menu");
		venues.click();
		String current_url = driver.getCurrentUrl();

		URL newurl = new URL(current_url);

		HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
		httpConnect.connect();

		int rescode = httpConnect.getResponseCode();

		if (rescode >= 400) {
			log.info(current_url + " - Page not found (Response code: " + rescode + ")");
		}
	}

	public void checking_links() throws IOException {

		log.info("Testing broken links");
		for (WebElement link : links) {
			String urls = link.getAttribute("href");
			@SuppressWarnings("deprecation")
			URL url = new URL(urls);
			HttpURLConnection httpconnect = (HttpURLConnection) url.openConnection();
			httpconnect.connect();

			int rescode = httpconnect.getResponseCode();
			if (rescode >= 400) {
				log.info(urls + " - Page not found (Response code: " + rescode + ")");
			}
//			else {
//				System.out.print1	AW2	Q3eszzrdln(urls + " - Page found");
//			}

		}
	}

	public void venue_lists(WebDriver driver) throws InterruptedException, IOException {

		log.info("Testing venues");
		for (WebElement venues : venue_lists) {
			String current_url = venues.getAttribute("href");

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

				log.info("Current page title " + driver.getTitle()); // Print the title of the new tab

				driver.close();
				driver.switchTo().window(tabs.get(0));

				Thread.sleep(2000);
			}

		}
	}

	public void etihad_Park_direction(WebDriver driver) throws InterruptedException {
		log.info("Testing Eithat Park venue redirection ");
		Etihad_Park.click();

		String Text = option_name.getText();

		log.info(Text);

		if (Text.equals("ABU DHABI")) {
			for (WebElement Buttons : buttons) {
				Buttons.isDisplayed();
				String abu_button = Buttons.getText();
//				System.out.println(abu_button);
				Thread.sleep(2000);
			}
			driver.findElement(By.xpath("//button[contains(text(),'VIA E12')]")).click();
		}

		direction_dd.click();

		for (WebElement Options : options) {

			String Text1 = Options.getText();

			log.info(Text1);

			Thread.sleep(1500);

			Options.click();

			direction_dd.click();

			Thread.sleep(2000);
//			driver.findElement(By.xpath("//div[@class='ri-select__single-value css-bv5e9a-singleValue']")).click();
			Thread.sleep(1500);
		}
	}
}
