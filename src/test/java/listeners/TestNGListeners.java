package listeners;
import org.testng.*;
import utils.PropertyReader;

import java.util.Properties;

public class TestNGListeners implements IInvokedMethodListener, ITestListener, IExecutionListener, IRetryAnalyzer {
public static Properties prob;
    // ---------------- IInvokedMethodListener ----------------
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            System.out.println(method.getTestMethod().getMethodName() + " started");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            System.out.println(method.getTestMethod().getMethodName() + " finished");
        }
    }

    // ---------------- ITestListener ----------------
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getMethod().getMethodName());
        // Example: capture screenshot here if using Selenium
        // ScreenshotUtil.capture(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Context Started: " + context.getName());
        prob = PropertyReader.loadProperties();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Context Finished: " + context.getName());
    }

    // ---------------- IExecutionListener ----------------
    @Override
    public void onExecutionStart() {
        System.out.println("TestNG Execution Started");

    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG Execution Finished");
    }

    // ---------------- IRetryAnalyzer ----------------
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // retry failed test max 2 times

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test " + result.getMethod().getMethodName() + " (" + retryCount + ")");
            return true;
        }
        return false;
    }
}
