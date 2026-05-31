package base;

import drivers.WebDriverFactory;
import listeners.TestNGListeners;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.homepage;
import utils.PropertyReader;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static java.nio.file.Files.move;

public class baseTests {
    public WebDriver driver;
    protected homepage HomePage;
    protected Properties probs;
@BeforeClass
    public void setUp(){
    probs = PropertyReader.loadProperties();

    driver = WebDriverFactory.initDriver(probs.getProperty("browserType"));
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        goHome();
    }

@BeforeMethod
    public void goHome(){
    driver.get("https://the-internet.herokuapp.com/");
    HomePage = new homepage(driver);

}

    @AfterMethod
    public void recordFailure(@org.jetbrains.annotations.NotNull ITestResult result){
    if(ITestResult.FAILURE == result.getStatus()) {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(Path.of(screenshot.getAbsolutePath()), Path.of("resources/screenshots/"+result.getName()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }


@AfterClass
    public void tearDown(){
    WebDriverFactory.quitDriver();
    }


    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }



}


