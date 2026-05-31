package WaitTests;
import base.baseTests;
import org.testng.annotations.Test;
import pages.Ex1DynamicLoadingPage;

import static org.testng.Assert.*;

public class WaitTests extends baseTests{
@Test
    public void testWait(){
    var Ex1dynamicLoadingPage = HomePage.clickOndynamicLoading().clickEx1();
    Ex1dynamicLoadingPage.clickStartButton();
    assertEquals(Ex1dynamicLoadingPage.getText(),"Hello World!","The text is incorrect");
}
}
