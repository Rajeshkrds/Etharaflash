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

public class Ethara_Artists {

	Logger log = Logger.getLogger(this.getClass().getName());

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	private WebElement menu_button;

	@FindBy(xpath = "(//a[contains(text(),'Regional Artist Spotlight')])[1]")
	private WebElement artists;

	@FindBy(tagName = "a")
	private List<WebElement> links;

	@FindBy(xpath = "//a[contains(text(),'More Info')]")
	private WebElement moreInfo;

	@FindBy(xpath = "//a[contains(text(),'READ THE Q&A')]")
	private WebElement read_button;

	@FindBy(xpath = "(//div[@class='styles_ec-inside__YLDUv']//article)[1]")
	private WebElement artists_card;

	@FindBy(xpath = "class=\"ytp-play-button ytp-button\"")
	private WebElement youtube_play_pausebutton;

	@FindBy(xpath = "//div[@class='PreviewPlayButton_circularContainer__IPZte']")
	private WebElement spotify_play_pause_button;

	@FindBy(xpath = "//div[@class='styles_socialLinks__H_xOq']//a")
	private List<WebElement> socialLinks;

	public Ethara_Artists(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void artists_page(WebDriver driver) throws InterruptedException, IOException {
		log.info("Clicking on Menu from header");
		menu_button.click();
		Thread.sleep(1500);
		log.info("Clicking on Artists menu ");
		artists.click();

		URL pageurl = new URL(driver.getCurrentUrl());
		HttpURLConnection connect = (HttpURLConnection) pageurl.openConnection();
		connect.connect();

		if (connect.getResponseCode() >= 400) {
			log.info("Page not found - (Response Code : " + connect.getResponseCode() + ")");
		}

		else {

			log.info("Artist listing page is displayed ");
			// System.out.println("Landing page displayed");
		}

	}

//	public void check_links() throws IOException, InterruptedException {
//
//		log.info("Checking for broken links");
//		for (WebElement Link : links) {
//			String url = Link.getAttribute("href");
//			URL newurl = new URL(url);
//
//			HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
//			httpConnect.connect();
//
//			int rescode = httpConnect.getResponseCode();
//
//			if (rescode >= 400) {
//				log.info(url + " - Page not found (Response code: " + rescode + ")");
//			}
//		}
//
//	}

	public void checking_CTA(WebDriver driver) throws InterruptedException {

		log.info("Cliking on MOre Info CTA");
		moreInfo.click();
		log.info("Getting Page Title " + driver.getTitle());
		Thread.sleep(1000);
		// driver.navigate().back();

		log.info("Cliking on Read Q&A");
		read_button.click();
		Thread.sleep(1000);
		log.info("Getting Page Title " + driver.getTitle());

		driver.navigate().back();

	}

	public void artists_details_page(WebDriver driver) throws IOException, InterruptedException {
		Thread.sleep(2000);
		artists_card.click();
		log.info(driver.getTitle());

		URL url = new URL(driver.getCurrentUrl());

		HttpURLConnection httpconnect = (HttpURLConnection) url.openConnection();
		httpconnect.connect();

		if (httpconnect.getResponseCode() >= 400) {
			log.info("Page not found - (Response Code : " + httpconnect.getResponseCode() + ")");
		}

		else {
			// check_links();
			// Switching to youtube
			Thread.sleep(2000);

			log.info("Testing socail media pages of artists");
			for (int i = 0; i < socialLinks.size(); i++) {
				String links = socialLinks.get(i).getAttribute("href");

				((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", links);

				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(tabs.size() - 1));

				URL url1 = new URL(links);

				HttpURLConnection httpconnect1 = (HttpURLConnection) url1.openConnection();
				httpconnect1.connect();

				log.info(driver.getTitle());
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(2000);
			}
			Thread.sleep(3000);

			try {
				log.info(" YouTube iframe Present");

				driver.switchTo().frame(0);
//				youtube_play_pausebutton.click();
//				Thread.sleep(2000);
//				youtube_play_pausebutton.click();
//				// Switching back to normal page
				driver.switchTo().defaultContent();

			} catch (org.openqa.selenium.NoSuchElementException e) {
				log.info("No You tube content available");
			}

			try {
				log.info("Testing spotify iframe");

				// Switching to spotify
				driver.switchTo().frame(1);
				spotify_play_pause_button.click();
				Thread.sleep(2000);
				spotify_play_pause_button.click();

				driver.switchTo().defaultContent();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				log.info("Spotify not available for this artist ");
			}

		}

//		
	}
}
