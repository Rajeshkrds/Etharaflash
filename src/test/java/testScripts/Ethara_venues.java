package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Venues;
import utilities.webUtilities;

public class Ethara_venues extends BaseClass {

	webUtilities utilities = new webUtilities();

	@Test
	public void venues_tc() throws IOException, InterruptedException {

		Ethara_Venues venues = new Ethara_Venues(driver);

		venues.venuesPage(driver);

		// Title not available for this page

//		utilities.validation(driver.getTitle(), "");

		venues.checking_links();

		venues.venue_lists(driver);

		venues.etihad_Park_direction(driver);

	}

}
