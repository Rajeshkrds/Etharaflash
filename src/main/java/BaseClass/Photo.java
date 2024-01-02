package BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Photo {

	public void getPhoto(WebDriver driver, String testName) throws IOException {
		Date currentdate = new Date();
		String formatteddate = currentdate.toString().replaceAll(":", "-");
		String fileName = testName + "_" + formatteddate + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Administrator\\eclipse-workspace\\Ethara\\failed_TC\\" + fileName);
		FileUtils.copyFile(src, dest);
	}
}
