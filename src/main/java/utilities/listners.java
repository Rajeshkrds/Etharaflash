package utilities;

import org.testng.ITestResult;

import jdk.internal.org.jline.utils.Log;

public class listners {

	public void getTestName(ITestResult result) {
		Log.info("Test Case :" + result.getMethod().getMethodName());
	}
}
