package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends AbstractDriver{
    private EdgeOptions getOptions(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");              // Launch maximized
        options.addArguments("--disable-popup-blocking");       // Allow popups
        options.addArguments("--ignore-certificate-errors");    // Skip SSL errors
        options.addArguments("--incognito");                    // Private browsing
        options.addArguments("--disable-notifications");        // Block site notifications
        options.addArguments("--disable-extensions");           // Disable extensions
        options.addArguments("--headless");                     // Run headless (CI/CD)
        options.addArguments("--disable-gpu");                  // Disable GPU (for headless stability)
        options.addArguments("--remote-debugging-port=9222");   // Enable remote debugging
        options.addArguments("--lang=en-US");                   // Set browser language
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--start-maximized");

        return options;
    }

    @Override
    public WebDriver createDriver(){
        return new EdgeDriver(getOptions());
    }
}
