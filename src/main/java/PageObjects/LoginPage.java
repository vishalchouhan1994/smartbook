package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage  {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // To initialize driver object in current page,
	}

	// Find input number/email field
	@FindBy(xpath = "//input[@name='userName']")
	WebElement userNameInputField;

	// Find input password field
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordInputField;

	// Find Login submit button
	@FindBy(xpath = "//span[(text()='Log in')]")
	WebElement loginSubmitButton;

	// Find login error
	@FindBy(xpath = "//div[text()='Incorrect username or password.']")
	WebElement errorMsg;

	By loginbtn = By.xpath("//span[(text()='Log in')]");

	public void loginInApp() throws IOException, InterruptedException {

		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
				"C://Users//Dell 5580//eclipse-workspace//AutomationPractise//Smartlook//src//main//java//GlobalProperties//config.properties");
		pro.load(fis);
		String user = pro.getProperty("userName");
		String pwd = pro.getProperty("password");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='userName']")));

		userNameInputField.sendKeys(user);
		passwordInputField.sendKeys(pwd);
		// passwordInputField.submit();

	}

	public void clickOnLoginButton() throws InterruptedException {

		Thread.sleep(4000);
		loginSubmitButton.click();

	}

	public String loginInAppWithInvalidCredentials(String userName, String password) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='userName']")));

		userNameInputField.sendKeys(userName);
		passwordInputField.sendKeys(password);
		Thread.sleep(4000);

		loginSubmitButton.click();

		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Incorrect username or password.']")));
		String actual = errorMsg.getText();
		return actual;

	}

}
