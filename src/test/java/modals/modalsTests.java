package modals;
import base.baseTests;
import org.testng.annotations.Test;
import pages.EntryAd;

import static org.testng.Assert.*;

public class modalsTests extends baseTests{
    @Test
    public void testModals() throws InterruptedException {
        EntryAd entryAd = HomePage.clickEntryAd();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        entryAd.closeModal();
        entryAd.clickOnLink();
        assertEquals(entryAd.getText(),"Entry Ad","wrong message");

    }
}
