package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage   {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this); // To initialize driver object in current page,
	}
	
	// Instruction box
	@FindBy(xpath = "//textarea[@name='instruction']")
	WebElement instructionBox;
	
	// booknow button
	@FindBy(xpath = "//div[text()='Book now']")
	WebElement bookNowBtn;
		
	
	public void inputInstruction()
	{
		 // Define WebDriverWait with a timeout of 10 seconds
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Wait until the acceptAndBook button is clickable
	    wait.until(ExpectedConditions.visibilityOf(instructionBox));

	    // Click on the acceptAndBook button
	    instructionBox.sendKeys("Instruction added by Automation Script");
		
	    
	}
	
	public void clickOnBookNowBtn()
	{
		bookNowBtn.click();
	}

}
