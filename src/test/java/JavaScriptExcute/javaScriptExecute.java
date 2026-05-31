package JavaScriptExcute;
import base.baseTests;
import org.testng.annotations.Test;

public class javaScriptExecute extends baseTests{
@Test
    public void testScrolltoTable(){
    var largeAndDeepDomPage=HomePage.clickOnlargeAndDeepDom();
    largeAndDeepDomPage.scrollToTable();

}
    @Test
    public void testScrollToParagraph(){
        var InfiniteScroll=HomePage.clickOnInfiniteScroll();
        InfiniteScroll.scrollToParagraph(5);

    }
}
