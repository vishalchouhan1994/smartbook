package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseClass;
import PageObjects.LandingPage;
import PageObjects.LoginPage;

public class VerifyLoginAndLogout extends BaseClass {

	@Test
	public void loginAndLogout() throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		String exp = "Logout";
		
		LandingPage landingpage= new LandingPage(driver);
		landingpage.clickOnLoginBtn();
		LoginPage	loginpage = new LoginPage(driver);
		loginpage.loginInApp();
		loginpage.clickOnLoginButton();
		String act= landingpage.logout();
		assertEquals(act, exp);
		
	
	}

}
