package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // To initialize driver object in current page,
	}

	// Find logout button on landing page
	@FindBy(xpath = "//div[text() ='Logout']")
	WebElement logoutButton;

	// Find customer name button on landing page
	@FindBy(css = "div[class='MuiAvatar-root MuiAvatar-circular']")
	WebElement customerNamebtn;

	// Find Login button on landing page
	@FindBy(xpath = "//div[text()= 'Log in']")
	WebElement loginBtn;

	// Find Book Appointment button on landing page
	@FindBy(xpath = "//div[text()='Book Appointment']")
	WebElement bookAptBtn;

	By bookAptBtnLocator = By.xpath("//div[text()='Book Appointment']");

	// Get Booked Appointment confirmation message
	@FindBy(xpath = "//div[text()='Your appointment was booked successfully!']")
	WebElement getConfirmationMessage;

	// Add feature service in cart
	@FindBy(xpath = "//div[text()=\"Add\"]")
	WebElement addButton;

	// Find feature services display on landing page
	@FindBy(css = ".MuiGrid-grid-xs-4")
	List<WebElement> featruedServices;

	// Find pick stylist and date locator
	@FindBy(xpath = "//div[text()='Pick Stylist/ Date']")
	WebElement pickStylistAndDate;

	// Click on Pick stylist and date
	public void clickOnPickStylisAndDate() {

		// Create an instance of JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down the page by 500 pixels vertically
		js.executeScript("window.scrollBy(0,400)");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Adjust timeout as needed

		WebElement pickbtn = wait.until(ExpectedConditions.elementToBeClickable(pickStylistAndDate));
		pickbtn.click();

	}

	// Method to click on login button from landing page
	public void clickOnLoginBtn() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Adjust timeout as needed

		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginButton.click();
	}

	// Method to click on bookAptBtn
	public void clickOnBookAptBtn() {
		// Wait for the element to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
		wait.until(ExpectedConditions.elementToBeClickable(bookAptBtn));

		// Scroll down the page by 500 pixels vertically using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// Click on the button
		bookAptBtn.click();

	}

	public String logout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Adjust timeout as needed

		WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(customerNamebtn));
		customerName.click();
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		String actual = logout.getText();
		logout.click();
		return actual;

	}

	public void clickOnBookAptBtnWhenCardAlreadyAdded() {

		// Create an instance of WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed

		// Create an instance of JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down the page by 500 pixels vertically
		js.executeScript("window.scrollBy(0,500)");

		// Explicitly wait for the bookAptBtn element to be clickable
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bookAptBtn));

		js.executeScript("arguments[0].click();", element);
	}

	public String getConfirmationMessage() {
		String match = getConfirmationMessage.getText();
		return match;

	}

	public void listOfFeaturedServices() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed

		By element1 = By.xpath("//div[@title='Hair Cut']");

		WebElement srvc = featruedServices.stream().filter(service -> {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(element1)).getText().equals("Hair Cut");
		}).findFirst().orElse(null);

		if (srvc != null) {
			// Re-locate srvc element to avoid StaleElementReferenceException
			srvc = wait.until(ExpectedConditions.visibilityOfElementLocated(element1));

			WebElement addButton = wait
					.until(ExpectedConditions.elementToBeClickable(srvc.findElement(By.xpath("//div[text()='Add']"))));
			addButton.click();
		} else {
			System.out.println("Hair Cut service not found.");
		}

	}

}
