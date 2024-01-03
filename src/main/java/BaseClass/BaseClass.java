package BaseClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

//	Config readConfig = new Config();
	public WebDriver driver;

//	public String url = readConfig.getBaseURL();

//	@Parameters("browser")
	@SuppressWarnings("deprecation")
	@BeforeTest
//	public void launch_bowser(String br) throws IOException {

	public void launch_bowser() throws IOException {

//		if (br.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (br.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else if (br.equals("microsoft")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}

//		String url = "https://ethara-frontend-staging.eu-staging.kacdn.net/";

		String url = "https://www.ethara.com/";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);

		URL newurl = new URL(url);
		HttpURLConnection httpconnect = (HttpURLConnection) newurl.openConnection();
		httpconnect.connect();

		int resCode = httpconnect.getResponseCode();
		if (resCode >= 400) {
			System.out.println("Page not found - (Response Code : " + resCode + ")");
		}

		else {
			System.out.println("Landing page displayed");
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
		}
		driver.close();

//		driver.quit();
	}
}
