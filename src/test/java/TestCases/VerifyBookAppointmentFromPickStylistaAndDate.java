package TestCases;


import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseClass;
import PageObjects.LandingPage;
import PageObjects.SelectTimeSlot;

public class VerifyBookAppointmentFromPickStylistaAndDate extends BaseClass {

	@Test
	public void BookAppointmentFromPickStylistAndDate() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		LandingPage lp = new LandingPage(driver);
		lp.clickOnPickStylisAndDate();
		
		SelectTimeSlot st = new SelectTimeSlot(driver);
		st.clickOnDatePickerAndSelectDate("7");
		Thread.sleep(3000);
		st.scrollInPopup();
		
	
	}

}
