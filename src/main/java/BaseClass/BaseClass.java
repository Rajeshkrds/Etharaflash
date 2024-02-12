package BaseClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Config;

public class BaseClass {
	public static Logger log;
	Config readConfig = new Config();
	public WebDriver driver;

	public String url = readConfig.getBaseURL();

	@Parameters("browser")
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void launch_bowser(@Optional("chrome") String browser) throws IOException {

		log = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j.properties");
		// loadLog4j();
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Setting up Chrome browser");
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Setting up firefox browser");
		} else if (browser.equals("microsoft")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("Setting up Edge browser");
		}

//		String url = "https://ethara-frontend-staging.eu-staging.kacdn.net/";

//		String url = "https://www.ethara.com/";
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);

		URL newurl = new URL(url);
		HttpURLConnection httpconnect = (HttpURLConnection) newurl.openConnection();
		httpconnect.connect();

		int resCode = httpconnect.getResponseCode();
		if (resCode >= 400) {
			log.info("Page not found - (Response Code : " + resCode + ")");
			// System.out.println("Page not found - (Response Code : " + resCode + ")");
		}

		else {

			log.info("Landing page is displayed ");
			// System.out.println("Landing page displayed");
		}

	}

	@AfterMethod
	public void close_Browser(ITestResult res) throws IOException
//	public void close_Browser() 
	{

		int status = res.getStatus();
		String name = res.getName();
		if (status == ITestResult.FAILURE) {
			Photo p = new Photo();
			p.getPhoto(driver, name);
			log.info("Taking screenshot for failed test case " + getClass().getName());
		}
		log.info("Closing browser");
		driver.close();

//		driver.quit();
	}
}
