package dynamicLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class dynamicLocator {
    WebDriver driver;
    @Test
    public void DL(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com");
        /*   */

        new Actions(driver).moveToElement(driver.findElement(By.xpath("(//li[@class='dropdown']/a)[4]"))).perform();

        chooseOption("Join");


    }

    public void chooseOption(String option){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[.='"+ option +"']")).click();
    }
}
