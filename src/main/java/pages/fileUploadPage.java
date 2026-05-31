package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class fileUploadPage {
    private WebDriver driver;
    private By chooseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");
    public fileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public void uploadfile(String absoluteFilePath){
        driver.findElement(chooseFileButton).sendKeys(absoluteFilePath);
        clickUploadButton();
    }
    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }
    public String getUploadedFileName(){
        return driver.findElement(uploadedFile).getText();
    }

}

