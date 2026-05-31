package hoversTests;

import base.baseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HoversTests extends baseTests {
    @Test
    public void testHovers(){
        var HoversPage = HomePage.clickHovers();
        var figureCaption = HoversPage.hoverOverFigure(1);
        assertTrue(figureCaption.isCaptionDisplayed(),"The caption is not displayed");
        assertEquals(figureCaption.getName(),"name: user1","The name is incorrect");
        assertEquals(figureCaption.getLinkText(),"View profile", "The link text is incorrect");
        assertTrue(figureCaption.getLink().endsWith("/users/1"), "The link is incorrect");


    }
}
