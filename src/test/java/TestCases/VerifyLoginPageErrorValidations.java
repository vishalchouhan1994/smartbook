package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.Test;
import BaseTest.BaseClass;
import BaseTest.Retry;
import PageObjects.LandingPage;
import PageObjects.LoginPage;

public class VerifyLoginPageErrorValidations extends BaseClass {

	@Test (retryAnalyzer = Retry.class)
	public void LoginPageError() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		LandingPage landingpage = new LandingPage(driver);
		landingpage.clickOnLoginBtn();
		LoginPage loginpage = new LoginPage(driver);
		String actual = loginpage.loginInAppWithInvalidCredentials("1234567890", "Smartlook@123");
		assertEquals(actual, "Incorrect username or password.");

	}

}
