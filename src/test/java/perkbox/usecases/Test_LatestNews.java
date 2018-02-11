package test.java.perkbox.usecases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.java.perkbox.base.TestBase;
import test.java.perkbox.utilities.GenericUtilities;
import test.java.perkbox.utilities.Helpers;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class Test_LatestNews extends TestBase {
    private WebDriver driver;
    Helpers helpers;

    @Test
    public void testLatestNews() throws IOException,
            InterruptedException {

        driver = setDriver(  );
        helpers = new Helpers( driver );
        GenericUtilities genericUtilities = new GenericUtilities( driver );

        assertTrue( genericUtilities.isElementPresent( helpers.latestNewsHeading ), "Latest news heading was not " +
                "displayed" );
        assertTrue( genericUtilities.isElementPresent( helpers.latestNewsListingSection ), "Latest news listing " +
                "section was not displayed" );


    }
}



