package PageObjects;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectTimeSlot {

	WebDriver driver;

	public SelectTimeSlot(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // To initialize driver object in current page,
	}

	// Find Date Field
	@FindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root MuiIconButton-root linkBtn')]")
	WebElement openDatePicker;

	@FindBy(css = ".MuiPickersDay-day")
	List<WebElement> dateSelection;

	public void clickOnDatePickerAndSelectDate(String giveDate) {

		
		// Adjust timeout as needed
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		openDatePicker.click();

		// Filter the dateSelection list to find the element with the desired date
		WebElement dateElement = dateSelection.stream()
				.filter(element -> element.getText().equals(giveDate)).findFirst().orElse(null);

		
		// Click on the date element if found
		if (dateElement != null) {
			
			dateElement.click();
			
		} else {
			// Handle case when desired date is not found
			System.out.println("Desired date not found");
		}

	}

	public void scrollInPopup()
	{
		WebElement element = driver.findElement(By.xpath("(//a[contains(@class, 'underlineAlways ')])[last()]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
}
