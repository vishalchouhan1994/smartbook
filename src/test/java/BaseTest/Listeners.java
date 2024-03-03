package BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GlobalProperties.ExterntReporterNG;

public class Listeners extends BaseClass implements ITestNGListener {
		ExtentTest test;
		ExtentReports extent = ExterntReporterNG.getReportObject();

		 @Override
		public void onTestStart(ITestResult result) {
			// Implement your logic for what to do when a test starts
			 test = extent.createTest(result.getMethod().getMethodName());
			
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			// Implement your logic for what to do when a test succeeds
			test.log(Status.PASS, "Test Passed");
		}

		@Override
		public void onTestFailure(ITestResult result) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
			// Implement your logic for what to do when a test fails
			test.fail(result.getThrowable());
			try
			{
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch(Exception e1){
				e1.printStackTrace();
				
			}
		
			String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
			test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// Implement your logic for what to do when a test is skipped
		}
		
		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// Implement your logic for what to do when a test fails within success
			// percentage
		}

		
		public void onStart(ITestContext context) {
			// Implement your logic for what to do before the start of any test method
		}

		@Override
		public void onFinish(ITestContext context) {
			// Implement your logic for what to do after all the test methods have been run
			extent.flush();
		}
	
	
}