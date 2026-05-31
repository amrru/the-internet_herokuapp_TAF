package KeysTests;
import base.baseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KeysTests extends baseTests{
    @Test
    public void testBackSpace(){
        var keyPressesPage = HomePage.clickKeyPresses();
      //keyPressesPage.setText("a"+ Keys.BACK_SPACE);
        keyPressesPage.setText(Keys.chord(Keys.SHIFT + "a"));

       //assertEquals(keyPressesPage.getText(),"You entered: BACK SPACE","The text is incorrect");
        assertEquals(keyPressesPage.getText(),"You entered: A","The text is incorrect");

    }
}
