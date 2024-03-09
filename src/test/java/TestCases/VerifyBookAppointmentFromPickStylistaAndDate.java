package TestCases;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseClass;
import PageObjects.CancelatioPolicyPage;
import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.SelectTimeSlotPage;

public class VerifyBookAppointmentFromPickStylistaAndDate extends BaseClass {

	@Test
	public void BookAppointmentFromPickStylistAndDate() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		LandingPage lp = new LandingPage(driver);
		lp.clickOnLoginBtn();

		LoginPage ll = new LoginPage(driver);
		ll.loginInApp();
		ll.clickOnLoginButton();

		Thread.sleep(8000);
		lp.clickOnPickStylisAndDate();

		SelectTimeSlotPage st = new SelectTimeSlotPage(driver);
		st.clickOnDatePickerAndSelectDate();
		st.scrollInPopup();
		
		Thread.sleep(3000);
		st.clickOnContinueButton();

		CheckoutPage cp = new CheckoutPage(driver);
		cp.inputInstruction();
		cp.clickOnBookNowBtn();

		CancelatioPolicyPage Canp = new CancelatioPolicyPage(driver);
		
		Thread.sleep(3000);
		Canp.acceptAndBook();

	}

}
