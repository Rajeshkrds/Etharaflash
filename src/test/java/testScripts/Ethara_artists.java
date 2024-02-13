package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Artists;
import utilities.webUtilities;

public class Ethara_artists extends BaseClass {

	@Test(testName = "Validation of artisit listing page")
	public void artists_listing_page_tc() throws InterruptedException, IOException {

		log.info(getClass().getName());
		webUtilities u = new webUtilities();
		Ethara_Artists artist = new Ethara_Artists(driver);

		artist.artists_page(driver);

		// still no title given to this page so validation need to done in future
		u.validation(driver.getTitle(), "Regional Artist Spotlight");
//		artist.check_links();
		artist.checking_CTA(driver);

	}

	@Test(testName = "Validation of artisit detail page")
	public void artist_details_page_tc() throws IOException, InterruptedException {

		log.info(getClass().getName());

		Ethara_Artists artist = new Ethara_Artists(driver);
		artist.artists_page(driver);

		artist.artists_details_page(driver);
	}

}
