package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class infiniteScroll {
    private WebDriver driver;
    private By paragraphs =By.className("jscroll-added");

    public infiniteScroll(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToParagraph(int index){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script ="window.scrollTo(0,document.body.scrollHeight)";

        while(getNoOfParagraphs()<index){
            js.executeScript(script);

        }

    }

    public int getNoOfParagraphs(){
        return  driver.findElements(paragraphs).size();
    }


}
