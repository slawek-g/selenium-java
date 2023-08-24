package org.selenium.DriverFactory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {


    public static WebDriver getBrowser(String browser) {
//        System.getProperty(browser);
        if (browser != null) {
            if (browser.equalsIgnoreCase("chrome")) {
                return setChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                return setEdgeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                return setFirefoxDriver();
            }
        } else
            return setChromeDriver();

        return getBrowser(browser);

    }


    private static WebDriver setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions());
    }


    public static WebDriver setEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(edgeOptions());
    }

    public static WebDriver setFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless");
        return options;
    }

    private static EdgeOptions edgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

}
