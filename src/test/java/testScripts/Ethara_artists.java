package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Artists;
import utilities.webUtilities;

public class Ethara_artists extends BaseClass {

	@Test
	public void artists_listing_page_tc() throws InterruptedException, IOException {

		webUtilities u = new webUtilities();
		Ethara_Artists artist = new Ethara_Artists(driver);

		artist.artists_page();

		// still no title given to this page so validation need to done in future
//		u.validation(driver.getTitle(), "");
		artist.check_links();
		artist.checking_CTA(driver);
		artist.artists_details_page(driver);

	}

}
