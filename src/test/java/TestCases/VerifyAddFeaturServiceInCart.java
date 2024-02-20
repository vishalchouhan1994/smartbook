package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseClass;
import PageObjects.CancelatioPolicyPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;

public class VerifyAddFeaturServiceInCart extends BaseClass {

	@Test
	public void loginAndBookAppointment() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String expected = "Your appointment was booked successfully!";
		LandingPage landingpage = new LandingPage(driver);
		landingpage.listOfFeaturedServices();
		landingpage.clickOnBookAptBtnWhenCardAlreadyAdded();
		LoginPage lp = new LoginPage(driver);
		lp.loginInApp();
		lp.clickOnLoginButton();
		CancelatioPolicyPage cp = new CancelatioPolicyPage(driver);
		cp.acceptAndBook();
		String actual = landingpage.getAppointmentConfirmationMessage();
		assertEquals(actual, expected);

	}

}
