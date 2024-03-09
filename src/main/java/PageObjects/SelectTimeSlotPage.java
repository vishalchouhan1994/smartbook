package PageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectTimeSlotPage {

	WebDriver driver;

	public SelectTimeSlotPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // To initialize driver object in current page,
	}

	// Find Date Field
	@FindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root MuiIconButton-root linkBtn')]")
	WebElement openDatePicker;

	// Find dateSelection from calendar
	@FindBy(css = ".MuiPickersDay-day")
	List<WebElement> dateSelection;

	// Find recommended cutter
	@FindBy(xpath = "//div[text()='Recommended cutter at earliest timeslot (CST)']")
	WebElement recomandedCutter;

	// Find continue button
	@FindBy(xpath = "//div[text()='Continue']")
	WebElement continueBtn;

	public void clickOnDatePickerAndSelectDate() {

		// Get current date
		LocalDate currentDate = LocalDate.now();

		// Add two days to the current date
		LocalDate futureDate = currentDate.plusDays(2);

		// Extract the day part (dd) from the parsed date
		int dayOfMonth = futureDate.getDayOfMonth();

		// Print the formatted future date (optional)
		System.out.println("Selected date: " + dayOfMonth);

		// Adjust timeout as needed
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		openDatePicker.click();

		// Filter the dateSelection list to find the element with the desired date
		WebElement dateElement = dateSelection.stream()
				.filter(element -> element.getText().equals(String.valueOf(dayOfMonth))).findFirst().orElse(null);

		// Click on the date element if found
		if (dateElement != null) {
			dateElement.click();
		} else {
			// Handle case when desired date is not found
			System.out.println("Desired date not found");
		}
	}

	public void scrollInPopup() {
		WebElement element = driver.findElement(By.xpath("(//a[contains(@class, 'underlineAlways ')])[last()]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void selectRecommandedTimeSlot() {

		recomandedCutter.findElement(By.xpath("//div[text()='View more']")).click();

	}

	public void clickOnContinueButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();

	}
}
