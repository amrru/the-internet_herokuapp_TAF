package frames;
import base.baseTests;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.NestedFramesPage;

import java.awt.*;

import static org.testng.Assert.*;

public class FramesTests extends baseTests{
    @Test
    public void FrameTest(){
        FramesPage framePage = HomePage.clickFramePage();
        NestedFramesPage nestedFramesPage=framePage.clickNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(),"LEFT","Wrong message");
        assertEquals(nestedFramesPage.getBottomFrameText(),"BOTTOM","Wrong message");

    }

}
