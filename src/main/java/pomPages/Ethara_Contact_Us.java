package pomPages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ethara_Contact_Us {

	Logger log = Logger.getLogger(this.getClass().getName());

	@FindBy(id = "business")
	private WebElement business_radio_button;

	@FindBy(id = "personal")
	private WebElement persoanl_radio_button;

	@FindBy(xpath = "//input[@name='company']")
	private WebElement companyname_tb;

	@FindBy(xpath = "//input[@name='position']")
	private WebElement position_tb;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstname_tb;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastname_tb;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement email_tb;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phone_tb;

	@FindBy(xpath = "//div[@class=' css-lkh0o5-menu']//div//div")
	private List<WebElement> interest_dd;

	@FindBy(xpath = "//div[contains(text(),'Select Your Interest *')]")
	private WebElement share_interest_tb;

//	@FindBy(xpath="//div[contains(text(),'Country Code')]")
	@FindBy(xpath = "(//div[@class=\" css-kl7kjz\"])[1]")
	// @FindBy(xpath="(//div[@class=\" css-1uhm0ny\"])[2]")
	private WebElement countryCode_tb;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> countryCodes;

	@FindBy(xpath = "(//div[@class=\" css-kl7kjz\"])[2]")
	private WebElement country_tb;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> countries;

	@FindBy(xpath = "(//div[@class=\" css-kl7kjz\"])[3]")
	private WebElement Emirates_tb;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> emiratesList;

	@FindBy(xpath = "//button[contains(text(),'Subscribe')]")
	private WebElement subscribe;

	@FindBy(xpath = "//span[contains(text(),'Enter Company name')]")
	private WebElement C_nameErrorMess;

	@FindBy(xpath = "//div[@class=\"grecaptcha-logo\"]")
	private WebElement captacha;

	public Ethara_Contact_Us(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void select_business() {
		log.info("Checking of business contact form");
		if (business_radio_button.isSelected())
			System.out.println("Aleadry select");
		else {
			log.info("Cliking on Business radio button");
			business_radio_button.click();
		}
	}

	public void select_personal() {
		log.info("Checcking of Personal contact form");
		if (persoanl_radio_button.isSelected())
			System.out.println("Aleadry select");
		else {
			log.info("Cliking on Personal radio button");
			persoanl_radio_button.click();
		}
	}

	public void setCompanyName() {
		log.info("Entering Company Name");
		companyname_tb.clear();
		companyname_tb.sendKeys("KRDS");
	}

	public void setPosition() {
		log.info("Entering Position");
		position_tb.clear();
		position_tb.sendKeys("Test");
	}

	public void setUsernames() {
		log.info("Entering First Name");
		firstname_tb.clear();
		firstname_tb.sendKeys("Test");

		log.info("Entering Last Name");
		lastname_tb.clear();
		lastname_tb.sendKeys("One");

	}

	public void setEmail() {
		log.info("Entering Email Address");
		email_tb.clear();
		email_tb.sendKeys("testone@gmail.com");
	}

	public void selectInterest() throws InterruptedException {
		log.info("Selecting Interests from listed options");
		share_interest_tb.click();
		int size = interest_dd.size();
		log.info("Total interests listed are " + size);
		for (WebElement getOptions : interest_dd) {
			Thread.sleep(1000);
			String options = getOptions.getText();
//			System.out.println(options);
//			
			// Ccommnet if statment when need to select all options only click event enough
			// no need of break
			if (options.equals("Sport & Fitness")) {
				getOptions.click();
				break;
			}
		}

	}

	public void selectCountryCode(WebDriver driver) throws InterruptedException {
		log.info("Selecting Country Code from listed options");
		countryCode_tb.click();
		int size = countryCodes.size();
		log.info("Total country codes available are " + size);
		Thread.sleep(3000);
		for (WebElement countryOptions : countryCodes)

		{
			Thread.sleep(1000);
//			String countries = countryOptions.getText();
//			if(countries.equals("+971 ( UAE ) "))
//			{
//				countryOptions.click();
//				break;
//			}

			countryOptions.click();
			break;
		}

//		countryCode_tb.sendKeys("UAE");
//		Thread.sleep(3000);
		// driver.findElement(By.xpath("//div[contains(text(),'+971 ( UAE )
		// ')]")).click();

	}

	public void setMobileNumber() {
		log.info("Enter Mobile Number");
		phone_tb.clear();
		phone_tb.sendKeys("847484561");

	}

	public void setCountry() throws InterruptedException {
		log.info("Selecting Country from listed options");
		country_tb.click();
		int size = countries.size();
		log.info("Total No of countries are " + size);
		Thread.sleep(3000);
		for (WebElement CountryNames : countries) {
			String countryName = CountryNames.getText();

			if (countryName.equals("United Arab Emirates")) {
				CountryNames.click();
				break;
			}
		}

	}

	public void setEmirate() throws InterruptedException {
		log.info("Selecting Emirates ");
		if (Emirates_tb.isEnabled())

		{
			Emirates_tb.click();
			for (WebElement EmirateNames : emiratesList) {
				String emirateName = EmirateNames.getText();
				if (emirateName.equals("Dubai")) {
					EmirateNames.click();
					break;
				}
			}
		} else {
			setCountry();
			Emirates_tb.click();
			for (WebElement EmirateNames : emiratesList) {
				String emirateName = EmirateNames.getText();
				if (emirateName.equals("Dubai")) {
					EmirateNames.click();
					break;
				}
			}
		}

	}

	public void subscribe() {
		log.info("Clikcing on Subscription CTA");
		subscribe.click();
	}

	public String getCompanyNameError() {
		return C_nameErrorMess.getText();
	}

	public void checkCaptcha() {
		log.info("Checking for CAPTCHA");
		captacha.isDisplayed();
		log.info("Google CAPTCHA present");
	}

}
