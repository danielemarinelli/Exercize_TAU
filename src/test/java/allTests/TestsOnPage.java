package allTests;

import Pages.*;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestsOnPage extends BaseTest {
    private WebDriver driver;

    @Test
    public void functionsCheckTests(){
        LoginPage page = homePage.clickFormAuthentication();
        page.SetUser("tomsmith");
        page.SetPassword("SuperSecretPassword!");
        SecureAreaPage sap = page.clickLogIn();
        sap.getAlertText().trim();
        assertTrue(sap.getAlertText().contains("You logged into a secure area!"),
                "Alert text is incorrect! Check it out man...");

    }

    @Test
    public void dropDownTest() {
        dropDownPage ddp = homePage.dropDownFunction();
        ddp.selectListFromDropdown();
    }

    @Test
    public void ContextMenuTest(){
        contextPage cp = homePage.goToContextMenuPage();
        cp.hoverOverBox();
        cp.acceptAlert();
    }

    @Test
    public void forgotPasswordTest(){
        forgotPasswordPage fpp = homePage.requestPasswordFunction();
        emailSentPage finalPage = fpp.insertEmail();
        assertTrue(finalPage.sentenceReturned().contains("Your e-mail's been sent!"),
                "Alert email is incorrect! Check it out man...");
    }
    @Test
    public void findLocationTest(){
        geoLocalPage myLocation = homePage.geolocationFunction();
        assertEquals(myLocation.geoLocationInfo(),
                "See it on Google",
                "You are not in the right page, pal!");
    }
}
