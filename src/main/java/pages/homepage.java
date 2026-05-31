package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLObjectElement;

import java.util.Map;

public class homepage {
    private WebDriver driver;
    //private By formAuthenticationLink= By.linkText("Form Authentication");
    public homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink(String linkTest){
        driver.findElement(By.linkText(linkTest)).click();
    }

    public loginPage clickOnformAuthenticationLink(){
            clickLink("Form Authentication");
        return new loginPage(driver);
    }

    public dropDownPage clickDropdown(){
        clickLink("Dropdown");
        return new dropDownPage(driver);
    }

    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public javaScriptAlert clickJavaScriptAlert(){
        clickLink("Key Presses");
        return new javaScriptAlert(driver);
    }

    public fileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new fileUploadPage(driver);
    }

    public EntryAd clickEntryAd(){
        clickLink("Entry Ad");
        return new EntryAd(driver);
    }

    public FramesPage clickFramePage() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickOndynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public largeAndDeepDomPage clickOnlargeAndDeepDom(){
        clickLink("Large & Deep DOM");
        return new largeAndDeepDomPage(driver);
    }

    public infiniteScroll clickOnInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new infiniteScroll(driver);
    }

    public MultipleWindowPage clickonMultipleWindow(){
        clickLink("Multiple Windows");
        return new MultipleWindowPage(driver);
    }

}

