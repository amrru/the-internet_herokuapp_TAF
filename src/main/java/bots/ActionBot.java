package bots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionBot {
    private WebDriver driver;
    private WaitBot waitBot;

    public ActionBot(WebDriver driver){
        this.driver = driver;
        this.waitBot = new WaitBot(driver);
    }

    //clicking
    public void click(By locator){
        waitBot.fluentWait().until( d-> {

            try {
                WebElement element = d.findElement(locator);
                new Actions(d).scrollToElement(element);
                element.click();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        );
    }
    //typing
    public void type(By locator, String text){
        waitBot.fluentWait().until( d-> {

                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        element.sendKeys("text");
                        return true;
                    }
                    catch(Exception e){
                        return false;
                    }
                }
        );
    }
    //getting text
    public String getText(By locator){

        return waitBot.fluentWait().until( d-> {

                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        return element.getText().isEmpty()? element.getText() : null;
                        
                    }
                    catch(Exception e){
                        return null;
                    }
                }
        );

    }
}
