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

public class Ethara_Events {

	Logger log = Logger.getLogger(this.getClass().getName());

	@FindBy(xpath = "//a[contains(text(),'More info')]")
	private List<WebElement> links;

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	private WebElement menu_button;

	@FindBy(xpath = "(//a[contains(text(),'Events')])[1]")
	private WebElement events;

	@FindBy(xpath = "//div[contains(text(),'Event Categories')]")
	private WebElement events_categorires_dd;

	@FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[1]")
	private WebElement events_categorires;

	@FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[2]")
	private WebElement events_location;

	@FindBy(xpath = "(//div[@class=' css-b62m3t-container'])[3]")
	private WebElement events_month;

	@FindBy(xpath = "//div[@class='select__menu-list css-qr46ko']//div")
	private List<WebElement> event_dd_options;

//	@FindBy(xpath = "//div[@class='select__menu-list css-qr46ko']//div")
//	private List<WebElement> event_location_options;
//
//	@FindBy(xpath = "//div[@class='select__menu-list css-qr46ko']//div")
//	private List<WebElement> event_month_options;

	@FindBy(xpath = "//div[@class='styles_el-inside__y3mgU']//article")
	private List<WebElement> events_lists;

	@FindBy(xpath = "(//div[@class='select__indicators css-1wy0on6']//div[1])[1]")
	private WebElement events_close;

	@FindBy(xpath = "(//div[@class='select__indicators css-1wy0on6']//div[1])[2]")
	private WebElement location_close;

	@FindBy(xpath = "(//div[@class='select__indicators css-1wy0on6']//div[1])[3]")
	private WebElement month_close;

	@FindBy(xpath = "//h5[@class=\"styles_light__Z_WKs\"]")
	private List<WebElement> event_name;

	@FindBy(xpath = "//a[contains(@class,'styles_button__HPgMi styles')]")
	private List<WebElement> CTA;

	@FindBy(xpath = "//div[@class='styles_el-inside__y3mgU']//article[1]")
	private WebElement event_detail;

	public Ethara_Events(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void eventPage(WebDriver driver) throws InterruptedException, IOException {
		log.info("Clicking on Menu from header");
		menu_button.click();
		Thread.sleep(2000);
		log.info("Clicking on Event Menu");
		events.click();
		String current_url = driver.getCurrentUrl();

		URL newurl = new URL(current_url);

		HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
		httpConnect.connect();

		int rescode = httpConnect.getResponseCode();

		if (rescode >= 400) {
			log.info(current_url + " - Page not found (Response code: " + rescode + ")");
		}
	}

	public void check_links() throws IOException {

		log.info("Checking for broken links");

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			@SuppressWarnings("deprecation")
			URL newurl = new URL(url);
			HttpURLConnection httpconnect = (HttpURLConnection) newurl.openConnection();
			httpconnect.connect();

			int rescode = httpconnect.getResponseCode();
			if (rescode >= 400) {
				log.info(url + " - Page not found (Response code: " + rescode + ")");
			}

//			else {
//				System.out.println(newurl + " - Page found");
//			}

		}

	}

	public void events_category(WebDriver driver) throws InterruptedException {
		log.info("Testing Event category dropdown");

//		events_categorires_dd.click();
		events_categorires.click();

//		for (WebElement options : event_category_options) {
//
//			String event_type = options.getText();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//div[contains(text(),'" + event_type + "')]")).click();
//			Thread.sleep(2000);
//			System.out.println("Total events in " + event_type + " event category is " + events_lists.size());
//			Thread.sleep(2000);
////			events_categorires_dd.click();
//			events_categorires.click();
//			Thread.sleep(3000);
//		}

		for (int i = 0; i < event_dd_options.size(); i++) {
			String options = event_dd_options.get(i).getText();
//			System.out.println(options);
			driver.findElement(By.xpath("//div[contains(text(),'" + options + "')]")).click();
//			events_categorires_dd.click();
//			System.out.println("Total events in " + options + " is " + events_lists.size());

			log.info("Events available under " + options + " : ");

//			for (WebElement name : event_name) 

			if (events_lists.size() != 0) {
				for (WebElement events : event_name) {
					log.info(events.getText());
				}
			} else {
//					System.out.println(name.getText());
				log.info("No Events Available");
			}
			System.out.println();
			Thread.sleep(2000);
			events_categorires.click();
			Thread.sleep(2000);
		}
		events_close.click();

//		Random rand = new Random();
//		int randoptions = rand.nextInt(event_category_options.size());
//		event_category_options.get(randoptions).click();

	}

	public void events_location(WebDriver driver) throws InterruptedException {
		log.info("Testig Event location dropdown");
		events_location.click();

		for (int i = 0; i < event_dd_options.size(); i++) {
			String options = event_dd_options.get(i).getText();

//			System.out.println(options);
			driver.findElement(By.xpath("//div[contains(text(),'" + options + "')]")).click();
//			events_categorires_dd.click();
//			System.out.println("Total events in " + options + " location is " + events_lists.size());

			log.info("Events available in " + options + " : ");

			if (events_lists.size() != 0) {
				for (WebElement events : event_name) {
					log.info(events.getText());
				}
			} else {

				log.info("No Events Available");
			}

			System.out.println();
			Thread.sleep(2000);
			events_location.click();
			Thread.sleep(2000);
		}

		location_close.click();
	}

	public void eventsmonth(WebDriver driver) throws InterruptedException {
		log.info("Testing Event month dropdown");
		events_month.click();

		for (int i = 0; i < event_dd_options.size(); i++) {
			String options = event_dd_options.get(i).getText();
//			System.out.println(options);
			driver.findElement(By.xpath("//div[contains(text(),'" + options + "')]")).click();
//			events_categorires_dd.click();
//			System.out.println("Total events in " + options + " location is " + events_lists.size());
			log.info("Events available in " + options + " : ");

			if (events_lists.size() != 0) {
				for (WebElement events : event_name) {
					System.out.println(events.getText());
				}
			} else {

				log.info("No Events Available");
			}

			System.out.println();
			Thread.sleep(2000);
			events_month.click();
			Thread.sleep(2000);
		}

		events_month.click();
	}

	public void category_and_location(WebDriver driver) throws InterruptedException {

		log.info("Testing Event category and location funcationality ");

		events_categorires.click();
		for (int i = 0; i < event_dd_options.size(); i++) {
			String category_options = event_dd_options.get(i).getText();
			driver.findElement(By.xpath("//div[contains(text(),'" + category_options + "')]")).click();
			events_location.click();
			for (int j = 0; j < event_dd_options.size(); j++) {
				String location_Options = event_dd_options.get(j).getText();
				driver.findElement(By.xpath("//div[contains(text(),'" + location_Options + "')]")).click();
				log.info("Event available for selected " + category_options + " and " + location_Options);

				if (events_lists.size() != 0) {
					for (WebElement events : event_name) {
						log.info(events.getText());
					}
				} else {

					log.info("No Events Available");
				}
				System.out.println("======================================================================");
				Thread.sleep(500);
				events_location.click();
				Thread.sleep(500);

			}

			Thread.sleep(500);
			events_categorires.click();
			Thread.sleep(500);
		}
	}

	public void category_location_month(WebDriver driver) throws InterruptedException {

		log.info("Testing Event filters funcationality ");

		events_categorires.click();
		for (int i = 0; i < event_dd_options.size(); i++) {
			String category_options = event_dd_options.get(i).getText();
			driver.findElement(By.xpath("//div[contains(text(),'" + category_options + "')]")).click();
			events_location.click();
			for (int j = 0; j < event_dd_options.size(); j++) {
				String location_Options = event_dd_options.get(j).getText();
				driver.findElement(By.xpath("//div[contains(text(),'" + location_Options + "')]")).click();

				events_month.click();
				for (int k = 0; k < event_dd_options.size(); k++) {
					String month_Options = event_dd_options.get(k).getText();
					driver.findElement(By.xpath("//div[contains(text(),'" + month_Options + "')]")).click();
					System.out.println("Event available for selected " + category_options + ", " + location_Options
							+ " and " + month_Options);

					if (events_lists.size() != 0) {
						for (WebElement events : event_name) {
							log.info(events.getText());
						}
					} else {

						log.info("No Events Available");
					}

					System.out.println();
//					Thread.sleep(500);
					events_month.click();
//					Thread.sleep(500);

				}

				log.info("====================================================================================");
//				Thread.sleep(500);
				events_location.click();
//				Thread.sleep(500);

			}
			log.info("====================================================================================");
//			Thread.sleep(500);
			events_categorires.click();
//			Thread.sleep(500);
		}
	}

	public void checking_CTA(WebDriver driver) throws InterruptedException {

		log.info("Testing CTA redirections ");

		for (int i = 0; i < CTA.size(); i++) {
			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", CTA.get(i).getAttribute("href"));

			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));

			Thread.sleep(500);

			log.info("Current page title " + driver.getTitle());
			Thread.sleep(1000);
			driver.close();
			driver.switchTo().window(tabs.get(0));

			Thread.sleep(500);

			CTA = driver.findElements(By.xpath("//a[contains(@class,'styles_button__HPgMi styles')]"));
		}
	}

	public void event_details() throws IOException {
		log.info("Clicking on event and checking for details page");
		event_detail.click();
		check_links();
	}

}
