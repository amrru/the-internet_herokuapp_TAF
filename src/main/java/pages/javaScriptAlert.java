package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class javaScriptAlert {
    private WebDriver driver;
    private By alertTriggerButton = By.xpath("//button[contains(.,'Alert')]");
    private By confirmTriggerButton = By.xpath("//button[contains(.,'Confirm')]");
    private By promptTriggerButton = By.xpath("//button[contains(.,'Prompt')]");
    private By resultText = By.id("result");


    public javaScriptAlert(WebDriver driver){
        this.driver =driver;
    }

    public void triggerAlert(){
        driver.findElement(alertTriggerButton).click();
    }

    public void triggerConfirm(){
        driver.findElement(confirmTriggerButton).click();
    }

    public void triggerPrompt(){
        driver.findElement(promptTriggerButton).click();
    }

    public String getResultText(){
        return driver.findElement(resultText).getText();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_setText(String text){
        driver.switchTo().alert().sendKeys(text);
    }

}
