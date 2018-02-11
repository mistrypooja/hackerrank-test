package test.java.perkbox.utilities;

import org.apache.commons.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Helpers {

    private WebDriver driver;
    private GenericUtilities genericUtilities;

    // page elements
    @FindBy(xpath = "//h2[.='Latest news']")
    public WebElement latestNewsHeading;
    @FindBy(xpath = "//div[@class='bloglisting news-post__listing']")
    public WebElement latestNewsListingSection;
    @FindBy(xpath = "//*[@data-icon='hamburger2']")
    public WebElement hamburgerMenu;
    @FindBy(className = "foot__offices")
    public WebElement officesText;

    public final static String pageLinkLocator = "//span[.='%s']/..";
    public final static String pageHeaderLocator = "//h1[.='%s']";


    public Helpers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
        genericUtilities = new GenericUtilities( driver );
    }


    public void openHamburgerMenu() {
        genericUtilities.waitForElementPresent( hamburgerMenu );
        hamburgerMenu.click();

    }

    public void clickPageLink(String pageName) {
        genericUtilities.waitForElementPresent( By.xpath( String.format( pageLinkLocator, WordUtils.capitalizeFully(
                pageName ) ) ) );
        driver.findElement( By.xpath( String.format( pageLinkLocator, WordUtils.capitalizeFully(
                pageName ) ) ) ).click();
    }

    public boolean isOnCorrectPage(String pageName) {
        return genericUtilities.isElementPresent( By.xpath( String.format( pageHeaderLocator, pageName ) ), 10 );

    }

    public int getOfficesCount(){
        genericUtilities.waitForElementPresent( officesText );
        String offices=officesText.getText();
        String[] officesList = offices.split( "," );
        return officesList.length;
    }

}
