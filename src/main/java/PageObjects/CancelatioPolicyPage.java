package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CancelatioPolicyPage   {
	WebDriver driver;

	public CancelatioPolicyPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this); // To initialize driver object in current page,
	}
	
	@FindBy(xpath = "//div[text()='Accept and book']")
	WebElement acceptAndBook;
	
	public void acceptAndBook()
	{
		 // Define WebDriverWait with a timeout of 10 seconds
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Wait until the acceptAndBook button is clickable
	    wait.until(ExpectedConditions.elementToBeClickable(acceptAndBook));

	    // Click on the acceptAndBook button
	    acceptAndBook.click();
		
	}

}
