package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login > button");
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsernameField(String userName){
        driver.findElement(usernameField).sendKeys(userName);

    }
    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public secureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new secureAreaPage(driver);
    }

    public loginPage login(String userName, String Password){
        setUsernameField(userName);
        setPasswordField(Password);
        return this;

    }

}
