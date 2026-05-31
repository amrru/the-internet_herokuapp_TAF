package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage {
    private WebDriver driver ;
    private By figureBox = By.className("figure");
    private By figurecaption = By.className("figcaption");
    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    public figureCaption hoverOverFigure(int index){
       WebElement figure= driver.findElements(figureBox).get(index-1);
       Actions actions = new Actions(driver);
       actions.moveToElement(figure).perform();

       return new figureCaption(figure.findElement(figurecaption));

    }


    public class figureCaption{
        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");
        public figureCaption(WebElement caption){
            this.caption = caption;
        }
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        public String getName(){
           return caption.findElement(header).getText();
        }

        public String getLinkText(){
            return caption.findElement(link).getText();
        }
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }



    }


}
