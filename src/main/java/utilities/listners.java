package utilities;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listners implements ITestListener {

	public static final Logger log = Logger.getLogger(listners.class);

	public void onTestStart(ITestResult result) {

		log.info("Execute Test : " + result.getMethod().getDescription());
	}
}
