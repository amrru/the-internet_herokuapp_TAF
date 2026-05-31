package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ex1DynamicLoadingPage {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By result = By.cssSelector("#finish h4");
    private By loadingBar = By.id("loading");

    public Ex1DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButton(){
        driver.findElement(startButton).click();
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));
    }

    public String getText(){

        return driver.findElement(result).getText();
    }


}
