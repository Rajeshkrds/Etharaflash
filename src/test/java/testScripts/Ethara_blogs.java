package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Blogs;
import utilities.webUtilities;

public class Ethara_blogs extends BaseClass {

	webUtilities utilities = new webUtilities();

	@Test(testName = "Blogs Page", description = "Valdiaiton of Blogs page")
	public void filters_tc() throws InterruptedException, IOException {

//		log.info(this.getClass().getName());
		Ethara_Blogs blogs = new Ethara_Blogs(driver);
		blogs.blog_page(driver);

		String PageTitle = driver.getTitle();

		utilities.validation(PageTitle, "test");
		blogs.check_links();
		blogs.blog_filters(driver);

		blogs.blog_details(driver);
//		utilities.validation(PageTitle, PageTitle);
	}
}
