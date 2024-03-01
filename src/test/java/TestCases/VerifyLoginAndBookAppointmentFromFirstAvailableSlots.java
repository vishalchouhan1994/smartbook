package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseClass;
import PageObjects.CancelatioPolicyPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;

public class VerifyLoginAndBookAppointmentFromFirstAvailableSlots extends BaseClass {

	@Test
	public void loginAndBookFirstAvailableSlotAppointment() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String expected = "Your appointment was booked successfully!";
		LandingPage landingpage= new LandingPage(driver);
		landingpage.clickOnLoginBtn();
		LoginPage logingpage = new LoginPage(driver);
		logingpage.loginInApp();
		logingpage.clickOnLoginButton();
		CancelatioPolicyPage CancelatioPolicyPage = new CancelatioPolicyPage(driver);
		landingpage.clickOnBookAptBtnWhenCardAlreadyAdded();
		CancelatioPolicyPage.acceptAndBook();
		String actual = landingpage.getConfirmationMessage();
		assertEquals(actual, expected);
	
	}

}
