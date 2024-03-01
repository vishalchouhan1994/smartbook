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


public class BaseClass {

    public WebDriver driver;
    public Properties properties;

    @BeforeMethod
    public void initializeDriverAndLaunchApplication() throws IOException {
        properties = loadPropertiesFile("C://Users//Dell 5580//eclipse-workspace//AutomationPractise//Smartlook//src//main//java//GlobalProperties//config.properties");
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
}