package test.java.perkbox.usecases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.java.perkbox.base.TestBase;
import test.java.perkbox.utilities.Helpers;

import java.io.IOException;

public class Test_ValtechOffices extends TestBase {

    private WebDriver driver;
    Helpers helpers;

    @Test
    public void testValtechOffices() throws IOException,
            InterruptedException {

        driver = setDriver(  );
        helpers = new Helpers( driver );

       System.out.println(  "The offices count was: " +helpers.getOfficesCount());
    }
}
