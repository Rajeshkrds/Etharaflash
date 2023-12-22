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

public class Ethara_Venues {

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

	public void venuesPage() throws InterruptedException {
		menu_button.click();
		Thread.sleep(1500);
		venues.click();
	}

	public void checking_links() throws IOException {
		for (WebElement link : links) {
			String urls = link.getAttribute("href");
			@SuppressWarnings("deprecation")
			URL url = new URL(urls);
			HttpURLConnection httpconnect = (HttpURLConnection) url.openConnection();
			httpconnect.connect();

			int rescode = httpconnect.getResponseCode();
			if (rescode >= 400) {
				System.out.println(urls + " - Page not found");
			}
//			else {
//				System.out.println(urls + " - Page found");
//			}

		}
	}

	public void venue_lists(WebDriver driver) throws InterruptedException {

		for (WebElement venues : venue_lists) {

			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", venues.getAttribute("href"));

			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));

			Thread.sleep(2000);

			System.out.println(driver.getTitle()); // Print the title of the new tab

			driver.close();
			driver.switchTo().window(tabs.get(0));

			Thread.sleep(2000);

		}
	}

	public void etihad_Park_direction(WebDriver driver) throws InterruptedException {
		Etihad_Park.click();

		String Text = option_name.getText();

		System.out.println(Text);

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

			System.out.println(Text1);

			Thread.sleep(1500);

			Options.click();

			direction_dd.click();

			Thread.sleep(2000);
//			driver.findElement(By.xpath("//div[@class='ri-select__single-value css-bv5e9a-singleValue']")).click();
			Thread.sleep(1500);
		}
	}
}
