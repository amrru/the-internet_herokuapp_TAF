package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
private WebDriver driver;


public DynamicLoadingPage(WebDriver driver){
    this.driver=driver;
}

public Ex1DynamicLoadingPage clickEx1(){
    driver.findElement(By.partialLinkText("Example 1")).click();
    return new Ex1DynamicLoadingPage(driver);
}

}
