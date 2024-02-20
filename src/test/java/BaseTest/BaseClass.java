package BaseTest;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import PageObjects.LandingPage;

public class BaseClass {

	public WebDriver driver;
	public Properties properties;
	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(
				"C://Users//Dell 5580//eclipse-workspace//AutomationPractise//Smartlook//src//main//java//GlobalProperties//config.properties");
		properties.load(fis);
		String browserinvoke = properties.getProperty("browser");
		switch (browserinvoke.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	@BeforeMethod
	public void launchApplication() throws IOException {
		driver = initializeDriver();
		FileInputStream fis = new FileInputStream(
				"C://Users//Dell 5580//eclipse-workspace//AutomationPractise//Smartlook//src//main//java//GlobalProperties//config.properties");
		properties.load(fis);
		String URL = properties.getProperty("url");
		
		driver.get(URL);
		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
