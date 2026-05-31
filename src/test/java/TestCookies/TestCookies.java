package TestCookies;

import base.baseTests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.homepage;
import utils.WindowManager;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class TestCookies {
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
        driver.get("http://demo.magento.recolize.com/");
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
    public void testCookies() {
        WebElement languageSelect = driver.findElement(By.id("select-language"));
        Select select = new Select(languageSelect);

        Assert.assertEquals("English", select.getFirstSelectedOption().getText());

        // Before switching, URL should not contain store param
        Assert.assertFalse(driver.getCurrentUrl().contains("___store="),
                "URL should not contain store param before language change");

        select.selectByVisibleText("German");


        // Wait for URL to update
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("___store=german"));

        // Assert language switch reflected in URL
        Assert.assertTrue(driver.getCurrentUrl().contains("___store=german"),
                "URL should contain ___store=german after selecting German");

        Set<Cookie> cookies = driver.manage().getCookies();
        Iterator<Cookie> itr = cookies.iterator();

        while(itr.hasNext()){
            Cookie cookie = itr.next();
            System.out.println(cookie.getDomain());
            System.out.println(cookie.getName());
            System.out.println(cookie.getPath());
            System.out.println(cookie.getValue());
            System.out.println(cookie.getExpiry());

        }

        System.out.println("Current URL: " + driver.getCurrentUrl());
    }
}
