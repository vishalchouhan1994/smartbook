package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddPaymentMethodPage {

	WebDriver driver;

	public AddPaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // To initialize driver object in current page,
	}

	// Find Card number input field on payment method page
	@FindBy(xpath = "//input[@name='cardNumber']")
	WebElement cardnumber;

	public void addCardNumber() {
		cardnumber.sendKeys("5454545454545454");

	}
}
