package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Events;
import utilities.webUtilities;

public class Ethara_events extends BaseClass {

	webUtilities utilities = new webUtilities();

	@Test
	public void ethara_events_tc() throws IOException, InterruptedException {

		Ethara_Events events = new Ethara_Events(driver);
		events.eventPage();

		utilities.validation(driver.getTitle(), "Ethara | Making Moments That Matter");

		events.check_links();
		events.checking_CTA(driver);
		events.event_details();
	}

	@Test
	public void indiviudal_filter_tc() throws InterruptedException {
		Ethara_Events events = new Ethara_Events(driver);
		events.events_category(driver);
		events.events_location(driver);
		events.eventsmonth(driver);
	}

	@Test
	public void filter_category_and_location_tc() throws InterruptedException {
		Ethara_Events events = new Ethara_Events(driver);
		events.eventPage();
		events.category_and_location(driver);
	}

	@Test
	public void filter_category_location_month_tc() throws InterruptedException {
		Ethara_Events events = new Ethara_Events(driver);
		events.eventPage();
		events.category_location_month(driver);
	}
}
