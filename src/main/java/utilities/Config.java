package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	Properties properties;

	public Config() {
		try {
			FileInputStream fin = new FileInputStream(
					"C:\\Users\\Administrator\\eclipse-workspace\\Ethara\\src\\test\\resources\\data.properties");
			properties = new Properties();
			properties.load(fin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBaseURL() {
		// String URL = properties.getProperty("StagingURL");
		String URL = properties.getProperty("ProdURL");

		if (URL != null)
			return URL;
		else
			throw new RuntimeException("URL not specified in properites file");
	}

	public String getchromeBrowser() {
		String chromebrowser = properties.getProperty("chrome");

		return chromebrowser;
	}
}
