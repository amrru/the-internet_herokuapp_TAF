package pages;

import org.openqa.selenium.*;

public class largeAndDeepDomPage {
    private WebDriver driver;
    private By table= By.id("#large-table");
    public largeAndDeepDomPage(WebDriver driver){
        this.driver =driver;
    }

    public void scrollToTable(){
        WebElement tableElement = driver.findElement(table);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "argument[0].scrollIntoView()";
        js.executeScript(script,tableElement);

        /*
        Moataz Nabil Course:
            JavaScriptExecutor js = (JavaScriptExecutor) driver;
            js.executeScript("ScrollBy(x:0,y:3000)");
            Thread.sleep(3000);
         */
    }

}
