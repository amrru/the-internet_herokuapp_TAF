package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class dropDownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    public dropDownPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectFromDropdown(String option){
        Select dropdownElement = new Select(driver.findElement(dropdown));
        dropdownElement.selectByVisibleText(option);
    }

    public List<String>  getSelectedOption(){
        List <WebElement> optionsElements =findSelectObject(dropdown).getAllSelectedOptions();
        List <String> optionsText = new ArrayList<>();
        for(WebElement element:optionsElements){
            optionsText.add(element.getText());
        }
        return optionsText;
    }

    private Select findSelectObject(By element){
        return new Select(driver.findElement(element));
    }
}
