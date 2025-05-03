package MME.meeplatform.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MME3.meeplatform.BaseTest;
import MME3.meeplatform.resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent;

	public void onTestStart(ITestResult result) {

		extent = ExtentReportNG.getReportObject();
		test = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test pass");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException e) {

			e.printStackTrace();
		}
		String filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		try {
			test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestResult result) {
	}

	public void onFinish(ITestResult result) {

		extent.flush();
	}

}
