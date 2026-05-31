package fluentPatternApproachTrialTest;

import base.baseTests;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.homepage;
import pages.loginPage;
import utils.JsonReader;

import static org.testng.Assert.assertTrue;

public class secureAreaPageTest extends baseTests {
    JsonReader jsR= new JsonReader("logindata");
    @Test
    public void redirectionTest(){
        assertTrue(new homepage(driver).clickOnformAuthenticationLink().login(jsR.getJsonData("valid-userName"),jsR.getJsonData("valid-password"))
                .clickLoginButton().getWelcomeMessage().contains("You logged into a secure area!"), "Incorrect");
    }
}
