package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Header;
import utilities.webUtilities;

public class Ethara_home extends BaseClass {

	webUtilities utilities = new webUtilities();
//	SoftAssert a = new SoftAssert();

//	@Test(priority = 1)
//	public void homePage_TC() throws InterruptedException, IOException {
//
//		String Expected_title = "Ethara | Making Moments That Matter";
//		Thread.sleep(2000);
//
//		String actual_title = utilities.getPageTitle(driver);
//		System.out.println(actual_title);
//		a.assertEquals(Expected_title, actual_title);
//		Thread.sleep(2000);
//
//	}

	@Test(priority = 2)
	public void homePage_TC() throws InterruptedException, IOException {
		Ethara_Header HomePage = new Ethara_Header(driver);

		HomePage.check_links();

		HomePage.coming_soon();
		String Expected_title = "Ethara | Making Moments That Matter";
		Thread.sleep(2000);
		String actual_title = utilities.getPageTitle(driver);
		utilities.delay();
		System.out.println(actual_title);
		utilities.validation(Expected_title, actual_title);

		utilities.backward(driver);
		utilities.delay();

		HomePage.contactus_button();
		String Expected_contactustitle = "Ethara | Contact Us";
		utilities.delay();
		String actual_contactustitle = utilities.getPageTitle(driver);
		utilities.delay();
		System.out.println(actual_contactustitle);
		utilities.validation(Expected_contactustitle, actual_contactustitle);
		utilities.delay();
		utilities.backward(driver);

		HomePage.aboutus_button();
		String Expected_aboutustitle = "Ethara | About Us";
		utilities.delay();
		String actual_aboutustitle = utilities.getPageTitle(driver);
		utilities.delay();
		System.out.println(actual_aboutustitle);
		utilities.validation(Expected_aboutustitle, actual_aboutustitle);
		utilities.delay();
		utilities.backward(driver);

		// Dynamically changing so need to check button available or not and run

//		HomePage.comingup_category();
//
//		String Expected_cominguptitle = "FORMULA 1® ETIHAD AIRWAYS ABU DHABI GRAND PRIX 2023";
//		utilities.delay();
//		String actual_cominguptitle = utilities.getPageTitle(driver);
//		utilities.delay();
//		System.out.println(actual_cominguptitle);
//		utilities.validation(Expected_cominguptitle, actual_cominguptitle);
//		utilities.delay();
//		utilities.backward(driver);

		HomePage.ourpeople();
		String Expected_ourpeopletitle = "Ethara | Our People";
		utilities.delay();
		String actual_ourpeopletitle = utilities.getPageTitle(driver);
		utilities.delay();
		System.out.println(actual_ourpeopletitle);
		utilities.validation(Expected_ourpeopletitle, actual_ourpeopletitle);
		utilities.delay();
		utilities.backward(driver);

	}

//	@Test(priority = 3)
//	public void homePage_contactus() throws InterruptedException {
//		Ethara_Header hp_header = new Ethara_Header(driver);
//
//		hp_header.contactus_button();
//		String Expected_title = "Ethara | Contact Us";
//		Thread.sleep(2000);
//
//		String actual_title = utilities.getPageTitle(driver);
//		Thread.sleep(2000);
//		System.out.println(actual_title);
//		a.assertEquals(Expected_title, actual_title);
//		Thread.sleep(2000);
//		utilities.backward(driver);
//
//	}
//
//	@Test(priority = 7)
//	public void homePage_menu() throws InterruptedException {
//
//		Ethara_Header hp_header = new Ethara_Header(driver);
//
//		hp_header.menu();
//		hp_header.menuOptions(driver);
//		hp_header.close();
//
//	}
//
//	@Test(priority = 4)
//	public void homePage_aboutus() throws InterruptedException {
//		Ethara_Header hp_header = new Ethara_Header(driver);
//
//		hp_header.aboutus_button();
//		String Expected_title = "Ethara | About Us";
//		Thread.sleep(2000);
//
//		String actual_title = utilities.getPageTitle(driver);
//		Thread.sleep(2000);
//		System.out.println(actual_title);
//		a.assertEquals(Expected_title, actual_title);
//		Thread.sleep(2000);
//		utilities.backward(driver);
//
//	}
//
//	@Test(priority = 5)
//	public void homePage_comingup_category() throws InterruptedException {
//		Ethara_Header hp_header = new Ethara_Header(driver);
//
//		hp_header.comingup_category();
//		String Expected_title = "FORMULA 1® ETIHAD AIRWAYS ABU DHABI GRAND PRIX 2023";
//		Thread.sleep(2000);
//
//		String actual_title = utilities.getPageTitle(driver);
//		Thread.sleep(2000);
//		System.out.println(actual_title);
//		a.assertEquals(Expected_title, actual_title);
//		Thread.sleep(2000);
//		utilities.backward(driver);
//
//	}
//
//	@Test(priority = 6)
//	public void homePage_ourpeople() throws InterruptedException {
//		Ethara_Header hp_header = new Ethara_Header(driver);
//
//		hp_header.ourpeople();
//		String Expected_title = "Ethara | Our People";
//		Thread.sleep(2000);
//
//		String actual_title = utilities.getPageTitle(driver);
//		Thread.sleep(2000);
//		System.out.println(actual_title);
//		a.assertEquals(Expected_title, actual_title);
//		Thread.sleep(2000);
//		utilities.backward(driver);
//
//	}

}
