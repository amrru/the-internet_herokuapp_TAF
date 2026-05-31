package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class WebDriverFactory {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static AbstractDriver getDriver(String browser){
        /* return switch(browser){
            case "chrome" -> new ChromeFactory();
            case "firefox" -> new FireFoxFactory();
            case "edge" -> new EdgeFactory();
            default -> throw new IllegalArgumentException("browser not supported "+ browser);

        }; */
        browsers browserE = browsers.valueOf(browser.toUpperCase());
        return browserE.getDriverFactory();

    }

    public static WebDriver initDriver(String browser){

            WebDriver driver = ThreadGuard.protect(getDriver(browser).createDriver());
            driverThreadLocal.set(driver);

        return driverThreadLocal.get();
    }

    public static void quitDriver(){
        driverThreadLocal.get().quit();
    }
}
