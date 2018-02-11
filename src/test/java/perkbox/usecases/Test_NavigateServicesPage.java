package test.java.perkbox.usecases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.java.perkbox.base.TestBase;
import test.java.perkbox.utilities.Helpers;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class Test_NavigateServicesPage extends TestBase{
    private WebDriver driver;
    Helpers helpers;
    private String pageName="Services";

    @Test
    public void testNavigateServicesPage() throws IOException,
            InterruptedException {

        driver = setDriver(  );
        helpers = new Helpers( driver );

        helpers.openHamburgerMenu();
        helpers.clickPageLink( pageName );
        assertTrue( helpers.isOnCorrectPage( pageName ), "The page header was not displayed on navigating to the " +
                "page" );
    }
}


