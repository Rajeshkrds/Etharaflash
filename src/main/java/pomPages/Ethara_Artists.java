package pomPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ethara_Artists {

	Logger log = Logger.getLogger(this.getClass().getName());

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	private WebElement menu_button;

	@FindBy(xpath = "(//a[contains(text(),'Artists')])[1]")
	private WebElement artists;

	@FindBy(tagName = "a")
	private List<WebElement> links;

	@FindBy(xpath = "//a[contains(text(),'More Info')]")
	private WebElement moreInfo;

	@FindBy(xpath = "//a[contains(text(),'READ THE Q&A')]")
	private WebElement read_button;

	@FindBy(xpath = "(//div[@class='styles_ec-inside__YLDUv']//article)[1]")
	private WebElement artists_listing;

	@FindBy(xpath = "class=\"ytp-play-button ytp-button\"")
	private WebElement youtube_play_pausebutton;

	@FindBy(xpath = "//div[@class='PreviewPlayButton_circularContainer__IPZte']")
	private WebElement spotify_play_pause_button;

	public Ethara_Artists(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void artists_page() throws InterruptedException {
		log.info("Clicking on Menu from header");
		menu_button.click();
		Thread.sleep(1500);
		log.info("Clicking on Artists menu ");
		artists.click();
	}

	public void check_links() throws IOException, InterruptedException {

		log.info("Checking for broken links");
		for (WebElement Link : links) {
			String url = Link.getAttribute("href");
			URL newurl = new URL(url);

			HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
			httpConnect.connect();

			int rescode = httpConnect.getResponseCode();

			if (rescode >= 400) {
				log.info(url + " - Page not found (Response code: " + rescode + ")");
			}
		}

	}

	public void checking_CTA(WebDriver driver) {

		log.info("Cliking on MOre Info CTA");
		moreInfo.click();
		log.info("Getting Page Title " + driver.getTitle());
		driver.navigate().back();

		read_button.click();
		log.info("Getting Page Title " + driver.getTitle());
		driver.navigate().back();

	}

	public void artists_details_page(WebDriver driver) throws IOException, InterruptedException {
		artists_listing.click();
		System.out.println(driver.getTitle());

		check_links();
		// Switching to youtube
		driver.switchTo().frame(0);
		youtube_play_pausebutton.click();
		Thread.sleep(2000);
		youtube_play_pausebutton.click();

		// Switching back to normal page
		driver.switchTo().defaultContent();

		// Switching to spotify
		driver.switchTo().frame(1);
		spotify_play_pause_button.click();
		Thread.sleep(2000);
		spotify_play_pause_button.click();

		driver.switchTo().defaultContent();

	}
}
