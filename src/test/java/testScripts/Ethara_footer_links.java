package testScripts;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Footer;

public class Ethara_footer_links extends BaseClass {

	@Test(testName = "Footer", description = "Validation of Footer")
	public void footerlinks_tc() throws InterruptedException, IOException {

		Ethara_Footer footer = new Ethara_Footer(driver);
//		log.info(this.getClass().getName());

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();

		footer.get_footerOptions();

		footer.hperlinkFun(driver);

		footer.terms_and_conditions(driver);

		footer.sustainability(driver);

		footer.privacy(driver);

		footer.socialmedia(driver);

	}
}
