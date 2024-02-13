package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Events;
import utilities.webUtilities;

public class Ethara_events extends BaseClass {

	webUtilities utilities = new webUtilities();

	@Test(testName = "Events page", description = "Validation of Events Page")
	public void ethara_events_tc() throws IOException, InterruptedException {

		Ethara_Events events = new Ethara_Events(driver);
		events.eventPage(driver);
//		log.info(this.getClass().getName());

		utilities.validation(driver.getTitle(), "Ethara | Making Moments That Matter");

		events.check_links();
		events.checking_CTA(driver);
		events.event_details();
	}

	@Test(testName = "ContactUs - Filter", description = "Validation of Events filter")
	public void indiviudal_filter_tc() throws InterruptedException {
		Ethara_Events events = new Ethara_Events(driver);
//		log.info(this.getClass().getName());

		events.events_category(driver);
		events.events_location(driver);
		events.eventsmonth(driver);
	}

	@Test(testName = "ContactUs - Filter", description = "Validation of Events filter - category and location")
	public void filter_category_and_location_tc() throws InterruptedException, IOException {
		Ethara_Events events = new Ethara_Events(driver);
//		log.info(this.getClass().getName());

		events.eventPage(driver);
		events.category_and_location(driver);
	}

	@Test(testName = "ContactUs - Filter", description = "Validation of Events filter - Months, category and locaiton")
	public void filter_category_location_month_tc() throws InterruptedException, IOException {
		Ethara_Events events = new Ethara_Events(driver);
//		log.info(this.getClass().getName());

		events.eventPage(driver);
		events.category_location_month(driver);
	}
}
