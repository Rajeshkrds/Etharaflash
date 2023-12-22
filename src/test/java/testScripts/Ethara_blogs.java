package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Blogs;
import utilities.webUtilities;

public class Ethara_blogs extends BaseClass {

	webUtilities utilities = new webUtilities();

	@Test
	public void filters_tc() throws InterruptedException, IOException {

		Ethara_Blogs blogs = new Ethara_Blogs(driver);
		blogs.blog_page();

		String PageTitle = driver.getTitle();

		utilities.validation("test", PageTitle);
		blogs.check_links();
		blogs.blog_filters(driver);

		blogs.blog_details();
//		utilities.validation(PageTitle, PageTitle);
	}
}
