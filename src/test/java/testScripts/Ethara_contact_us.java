package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.Ethara_Contact_Us;
import pomPages.Ethara_Header;
import utilities.webUtilities;

public class Ethara_contact_us extends BaseClass {
	webUtilities utilities = new webUtilities();

	@Test(enabled = true)
	public void businessForm_positive_tc() throws InterruptedException, IOException {
		log.info(this.getClass().getName());
		Ethara_Header hp_header = new Ethara_Header(driver);
		hp_header.contactus_button();

		utilities.validation(driver.getTitle(), "Ethara | Contact Us");

		Ethara_Contact_Us business = new Ethara_Contact_Us(driver);
//			utilities.delay();
//			utilities.refresh(driver);
		business.setCompanyName();
		business.setPosition();
		business.setUsernames();
		business.setEmail();
		business.selectInterest();
		utilities.delay();
		business.selectCountryCode(driver);
		business.setMobileNumber();
		utilities.delay();
		business.setCountry();
		utilities.delay();
		business.setEmirate();
		utilities.delay();
		business.checkCaptcha();
		business.subscribe();
		utilities.delay();
	}

	@Test(enabled = false)
	public void businessForm_FormValidation_tc() throws IOException {
		Ethara_Header hp_header = new Ethara_Header(driver);
		log.info(this.getClass().getName());

		hp_header.contactus_button();

//		SoftAssert a = new SoftAssert();

		Ethara_Contact_Us business = new Ethara_Contact_Us(driver);
		business.subscribe();

		String CN_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Enter Company name')]")).getText();
		String CN_exp_Message = "Enter Company name";
		utilities.validation(CN_act_Message, CN_exp_Message);
		log.info(CN_act_Message);

		String FN_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Enter First Name')]")).getText();
		String FN_exp_Message = "Enter First Name";
		utilities.validation(FN_act_Message, FN_exp_Message);
		log.info(FN_act_Message);

		String LN_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Enter Last Name')]")).getText();
		String LN_exp_Message = "Enter Last Name";
		utilities.validation(LN_act_Message, LN_exp_Message);
		log.info(LN_act_Message);

		String EID_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Enter Email ID')]")).getText();
		String EID_exp_Message = "Enter Email ID";
		utilities.validation(EID_act_Message, EID_exp_Message);
		log.info(EID_act_Message);

		String interest_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Select Your Interest *')]"))
				.getText();
		String interest_exp_Message = "Select Your Interest *";
		utilities.validation(interest_act_Message, interest_exp_Message);
		log.info(interest_act_Message);

		String country_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Please select a Country')]"))
				.getText();
		String country_exp_Message = "Please select a Country";
		utilities.validation(country_act_Message, country_exp_Message);
		log.info(country_act_Message);
//
//		String emirate_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Please select an Emirate')]")).getText();
//		String emirate_exp_Message = "Please select an Emirate";
//		utilities.validation(emirate_act_Message, emirate_exp_Message);

		utilities.assertAll();
	}

	@Test(enabled = true)
	public void personalForm_postivie_tc() throws InterruptedException, IOException {
		Ethara_Header hp_header = new Ethara_Header(driver);
		log.info(this.getClass().getName());

		hp_header.contactus_button();

		Ethara_Contact_Us personal = new Ethara_Contact_Us(driver);
		personal.select_personal();
		utilities.delay();
		personal.setUsernames();
		personal.setEmail();
		personal.selectInterest();
		personal.selectCountryCode(driver);
		personal.setMobileNumber();
		personal.setCountry();
		personal.setEmirate();
		personal.checkCaptcha();
		personal.subscribe();
	}

	@Test(enabled = false)
	public void personalForm_FormValidation_tc() throws IOException {
		Ethara_Header hp_header = new Ethara_Header(driver);
		log.info(this.getClass().getName());

		hp_header.contactus_button();

		Ethara_Contact_Us personal = new Ethara_Contact_Us(driver);
		personal.select_personal();
		personal.subscribe();

		String FN_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Enter First Name')]")).getText();
		String FN_exp_Message = "Enter First Name";
		utilities.validation(FN_act_Message, FN_exp_Message);
		log.info(FN_act_Message);

		String LN_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Enter Last Name')]")).getText();
		String LN_exp_Message = "Enter Last Name";
		utilities.validation(LN_act_Message, LN_exp_Message);
		log.info(LN_act_Message);

		String EID_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Enter Email ID')]")).getText();
		String EID_exp_Message = "Enter Email ID";
		utilities.validation(EID_act_Message, EID_exp_Message);
		log.info(EID_act_Message);

		String interest_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Select Your Interest *')]"))
				.getText();
		String interest_exp_Message = "Select Your Interest *";
		utilities.validation(interest_act_Message, interest_exp_Message);
		log.info(interest_act_Message);

		String country_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Please select a Country')]"))
				.getText();
		String country_exp_Message = "Please select a Country";
		utilities.validation(country_act_Message, country_exp_Message);
		log.info(country_act_Message);

		String emirate_act_Message = driver.findElement(By.xpath("//span[contains(text(),'Please select an Emirate')]"))
				.getText();
		String emirate_exp_Message = "Please select an Emirate";
		utilities.validation(emirate_act_Message, emirate_exp_Message);

		utilities.assertAll();
	}

}
