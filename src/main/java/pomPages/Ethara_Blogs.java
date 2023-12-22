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

public class Ethara_Blogs {

	@FindBy(xpath = "//span[contains(text(),'Menu')]")
	private WebElement menu_button;

	@FindBy(xpath = "(//a[contains(text(),'Blogs')])[1]")
	private WebElement blogs;

	@FindBy(tagName = "a")
	private List<WebElement> links;

	@FindBy(xpath = "(//div[@class=\"container\"])[3]//a")
	private List<WebElement> filters;

	@FindBy(xpath = "//div[@class='styles_bi-grid__uQcRY']//article")
	private List<WebElement> blog_lists;

	@FindBy(xpath = "//a[contains(text(),'Load More')]")
	private WebElement loadMore_button;

	@FindBy(xpath = "//div[@class='styles_bi-grid__uQcRY']//h5")
	private List<WebElement> blog_title;

	@FindBy(xpath = "(//div[@class='styles_bi-grid__uQcRY']//article)[1]")
	private WebElement blog_card;

	public Ethara_Blogs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void blog_page() throws InterruptedException {
		menu_button.click();
		Thread.sleep(1500);
		blogs.click();
	}

	public void check_links() throws IOException, InterruptedException {

		Thread.sleep(5000);
		for (WebElement Link : links) {
			String url = Link.getAttribute("href");
			URL newurl = new URL(url);

			HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
			httpConnect.connect();

			int rescode = httpConnect.getResponseCode();

			if (rescode >= 400) {
				System.out.println(newurl + " - Page not found");
			}
		}

	}

	public void blog_filters(WebDriver driver) throws InterruptedException {

		for (WebElement filterOptions : filters) {
			filterOptions.getText();

			driver.findElement(By.xpath("//a[contains(text(),'" + filterOptions + "')]")).click();

			if (blog_lists.size() != 0) {

				System.out.println("Blogs under " + filterOptions + ":");

				if (loadMore_button.isDisplayed()) {

					loadMore_button.click();

					for (WebElement list : blog_lists) {
						((JavascriptExecutor) driver).executeScript("window.open(arguments[0])",
								list.getAttribute("href"));

						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(tabs.get(tabs.size() - 1));

						Thread.sleep(2000);

						System.out.println(driver.getTitle()); // Print the title of the new tab

						driver.close();
						driver.switchTo().window(tabs.get(0));

						Thread.sleep(2000);
					}
				}

				else {
					for (WebElement list : blog_lists) {
						((JavascriptExecutor) driver).executeScript("window.open(arguments[0])",
								list.getAttribute("href"));

						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(tabs.get(tabs.size() - 1));

						Thread.sleep(2000);

						System.out.println(driver.getTitle()); // Print the title of the new tab
						driver.close();
						driver.switchTo().window(tabs.get(0));

						Thread.sleep(2000);
					}
				}

			} else {
				System.out.println("No blogs availblae under in" + filterOptions);
			}

		}

	}

	public void blog_details() throws IOException, InterruptedException {
		blog_card.click();
		check_links();
	}

}