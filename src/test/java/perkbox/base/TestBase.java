package test.java.perkbox.base;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import test.java.perkbox.config.Config;

import java.io.IOException;

public class TestBase {


    private WebDriver driver;
    private static final Platform LOCAL_OS = Platform.getCurrent();

    protected WebDriver setDriver()
            throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (Config.browser.equalsIgnoreCase( "firefox" )) {
            if (LOCAL_OS.is( Platform.MAC )) {
                System.setProperty( "webdriver.gecko.driver",
                        System.getProperty( "user.dir" ) + "/src/test/resources/drivers/mac/firefox/geckodriver" );
            }
            if (LOCAL_OS.is( Platform.WINDOWS )) {
                System.setProperty( "webdriver.gecko.driver",
                        System.getProperty( "user.dir" ) + "/src/test/resources/drivers/win/firefox/geckodriver.exe" );
            }
            capabilities = DesiredCapabilities.firefox();
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability( FirefoxOptions.FIREFOX_OPTIONS, capabilities );
            driver = new FirefoxDriver( options );
        } else if (Config.browser.equalsIgnoreCase( "chrome" )) {
            if (LOCAL_OS.is( Platform.MAC )) {
                System.setProperty( "webdriver.chrome.driver",
                        System.getProperty( "user.dir" ) + "/src/test/resources/drivers/mac/chromedriver" );
            }
            if (LOCAL_OS.is( Platform.WINDOWS )) {
                System.setProperty( "webdriver.chrome.driver",
                        System.getProperty( "user.dir" ) + "/src/test/resources/drivers/win/chromedriver.exe" );
            }
            capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            capabilities.setCapability( ChromeOptions.CAPABILITY, options );
            driver = new ChromeDriver( options );


        }
        driver.get( Config.appURL );
        driver.manage().window().maximize();

        return driver;
    }

    @AfterMethod
    protected void afterInvocation(ITestResult result) throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }

}
