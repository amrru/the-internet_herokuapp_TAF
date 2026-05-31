package javaScriptCalls;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.homepage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.AssertJUnit.assertEquals;

public class jsCalls {
    private WebDriver driver;
    protected homepage HomePage;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("http://www.google.com/");
        HomePage = new homepage(driver);

    }

    @AfterMethod
    public void recordFailure(@org.jetbrains.annotations.NotNull ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(
                        Path.of(screenshot.getAbsolutePath()),
                        Path.of("resources/screenshots/" + result.getName() + ".png"),
                        java.nio.file.StandardCopyOption.REPLACE_EXISTING  // <-- add this
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        driver.quit();
    }






    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @Test
    public void JsCallsTest(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = (String) js.executeScript("return document.title");
        assertEquals("Google",title);

        long links = (long) js.executeScript("return document.getElementsByTagName('A').length;");
        assertEquals("19",links);

    }


}
