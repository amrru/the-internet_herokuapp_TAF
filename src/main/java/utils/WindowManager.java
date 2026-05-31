package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager  {
            private WebDriver driver;
            private WebDriver.Navigation navigate;

            public WindowManager(WebDriver driver){
                this.driver = driver;
                navigate = driver.navigate();
            }

            public void goBack(){
                navigate.back();
            }

            public void goForward(){
                navigate.forward();
            }

            public void goToURL(String URL){
                navigate.to(URL);
            }
            public void refreshPage(){
                driver.navigate().refresh();
            }

            public void switchToTab(String title){
                Set<String> windowHandles =driver.getWindowHandles(); //btrg3 kol el handles l kol el windows elly mfto7a, unique identifier w btrg3 set of strings
                for(String windowHandle : windowHandles){
                    driver.switchTo().window(windowHandle);
                    if(title.equals(driver.getTitle())){
                        break;
                    /*el fekra eh, ana bgeb el set of strings b3d kda a3ml loop 3la kolo
                    b3d kda h3ml switch l window mnhom, bs ana 3ayz el title elly esmha kza kza
                    yb2a h3ml if condition, en lma el title bta3y equals kza kza, w2f el loop w switch leha
                     */
                    }
                }
            }




}
