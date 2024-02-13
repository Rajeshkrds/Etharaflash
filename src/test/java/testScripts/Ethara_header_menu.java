package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Header;
import utilities.webUtilities;

public class Ethara_header_menu extends BaseClass {

	webUtilities utilities = new webUtilities();

	@Test(testName = "Header Menu", description = "Validation of Header Menus")
	public void menu_options_tc() throws InterruptedException, IOException {

		Ethara_Header header = new Ethara_Header(driver);

//		log.info(this.getClass().getName());

		header.menu();

		header.menuOptionsfun(driver);

		header.terms_and_conditions(driver);

		header.privacy(driver);

		header.sustainability(driver);

//		header.socialmedia(driver);

		header.close();

	}
}
