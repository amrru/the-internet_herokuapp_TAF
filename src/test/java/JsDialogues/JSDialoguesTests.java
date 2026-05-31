package JsDialogues;
import base.baseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JSDialoguesTests extends baseTests {

    @Test
    public void testAlerts() {
        var javaScriptAlertPage = HomePage.clickJavaScriptAlert();
        javaScriptAlertPage.triggerAlert();
        javaScriptAlertPage.alert_clickToAccept();
        assertEquals(javaScriptAlertPage.getResultText(), "You successfully clicked on alert", "F");

    }

    @Test
    public void testConfirm() {
        var javaScriptAlertPage = HomePage.clickJavaScriptAlert();
        javaScriptAlertPage.triggerConfirm();
        String text = javaScriptAlertPage.alert_getText();
        javaScriptAlertPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "F");
    }

    @Test
    public void testPrompt() {
        String text = "Route";
        var javaScriptAlertPage = HomePage.clickJavaScriptAlert();
        javaScriptAlertPage.triggerPrompt();
        javaScriptAlertPage.alert_setText(text);
        javaScriptAlertPage.alert_clickToAccept();
        assertEquals(javaScriptAlertPage.getResultText(), "You entered: " + text, "F");
    }

}