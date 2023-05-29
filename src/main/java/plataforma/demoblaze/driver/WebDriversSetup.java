package plataforma.demoblaze.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriversSetup {

    public static WebDriver driver;

    public static WebDriversSetup withChromeOptions() {

        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("chrome.capabilities.unexpectedAlertBehavior", "ignore");
        System.setProperty("serenity.verbose.steps","FALSE");
        System.setProperty("serenity.report.encoding","UTF8");
        System.setProperty("feature.file.encoding","UTF8");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --disable-gpu --no-sandbox --disable-download-notification");

        driver = new ChromeDriver(options);
        return new WebDriversSetup();
    }

    public static WebDriver on(String url) {
        driver.get(url);
        return driver;
    }

    public static WebDriver quit(){
        driver.quit();
        return driver;
    }
}