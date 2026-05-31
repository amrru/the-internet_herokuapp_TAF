package login;

import base.baseTests;
import listeners.TestNGListeners;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.secureAreaPage;

import java.util.Properties;

import static org.testng.Assert.*;

public class loginTests extends baseTests {

    @Test
    public void testSuccessfulLogin(){


      loginPage loginpage=  HomePage.clickOnformAuthenticationLink();
      String VUName = probs.getProperty("validUserName");
      String VPassword = probs.getProperty("validPassword");
      loginpage.setUsernameField(VUName);
      loginpage.setPasswordField(VPassword);
      secureAreaPage SecureAreaPage = loginpage.clickLoginButton();

      assertTrue(SecureAreaPage.getWelcomeMessage().contains("You logged into a secure area!"), "Incorrect");


    }


}
