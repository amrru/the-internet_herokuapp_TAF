package navigation;
import base.baseTests;
import org.testng.annotations.Test;
import utils.WindowManager;

import static org.testng.Assert.assertEquals;

public class NavigateTests extends baseTests{
    @Test
    public void testNavigation(){
        HomePage.clickOndynamicLoading().clickEx1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goToURL("https://www.google.com");

    }

    @Test
    public void testSwitchToTab(){
        var newWindowPage =HomePage.clickonMultipleWindow().clickonlink();
        getWindowManager().switchToTab("New Window");
        assertEquals(newWindowPage.getText(), "New Window", "You're in the wrong tab");

    }
}
