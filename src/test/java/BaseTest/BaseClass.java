package BaseTest;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

public class BaseClass {

	public WebDriver driver;
	public Properties properties;

	@BeforeMethod
	public void initializeDriverAndLaunchApplication() throws IOException {
		properties = loadPropertiesFile(
				"C://Users//Dell 5580//eclipse-workspace//AutomationPractise//Smartlook//src//main//java//GlobalProperties//config.properties");
		String browserInvoke = properties.getProperty("browser");
		driver = initializeDriver(browserInvoke);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String URL = properties.getProperty("url");
		driver.get(URL);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	private Properties loadPropertiesFile(String filePath) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		properties.load(fis);
		return properties;
	}

	private WebDriver initializeDriver(String browserName) {
		WebDriver driver = null;
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		// Add more cases for other browsers if needed
		default:
			throw new IllegalArgumentException("Invalid browser name provided in config.properties file.");
		}
		return driver;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) {
    	// Convert WebDriver object to TakeScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        
        // Capture screenshot as File
        File source  = ts.getScreenshotAs(OutputType.FILE);
        
        File file = new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png");
        try {
            FileUtils.copyFile(source, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
          
            return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
    }

}