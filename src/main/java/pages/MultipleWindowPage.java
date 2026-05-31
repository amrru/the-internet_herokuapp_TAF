package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowPage {
    private WebDriver driver;
    private By clickLink = By.linkText("Click Here");


    public MultipleWindowPage(WebDriver driver){
        this.driver = driver;
    }

    public NewWindowPage clickonlink(){
        driver.findElement(clickLink).click();
        return new NewWindowPage(driver);
    }



}
