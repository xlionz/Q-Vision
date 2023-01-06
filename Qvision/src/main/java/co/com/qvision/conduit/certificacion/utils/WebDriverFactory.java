package co.com.qvision.conduit.certificacion.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.Map;

import static co.com.qvision.conduit.certificacion.utils.Constants.CHROME;
import static co.com.qvision.conduit.certificacion.utils.Constants.DEFAULT_BROWSER;


public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver goToWeb() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver getDriver() {
        return (DEFAULT_BROWSER.equals(CHROME)) ? getChromeDriver() : getEdgeDriver();
    }

    private static WebDriver getChromeDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments(
                "--incognito",
                "--disable-infobars",
                "enable-automation",
                "--disable-browser-side-navigation",
                "--lang=es",
                "--disable-download-notification",
                "--start-maximized",
                "--test-type",
                "--ignore-certificate-errors",
                "--allow-running-insecure-content",
                "--disable-translate",
                "--always-authorize-plugins", "--disable-extensions",
                "--profile.default_content_setting_values.geolocation");

        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();
// Specify the ChromeOption we need to set
        contentSettings.put("geolocation", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        chromeOptions.setExperimentalOption("prefs", prefs);
// Declare the capability for ChromeOptions
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        return WebDriverManager.chromedriver().capabilities(chromeOptions).create();
    }

    private static WebDriver getEdgeDriver() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("inprivate", true);

        return WebDriverManager.edgedriver().capabilities(edgeOptions).create();
    }
}