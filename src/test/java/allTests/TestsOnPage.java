package allTests;

import Pages.*;
import base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestsOnPage extends BaseTest {
    private WebDriver driver;

    @Test(priority=1)
    public void functionsCheckTests() throws Exception {
        LoginPage page = homePage.clickFormAuthentication();
        page.SetUser("tomsmith");
        page.SetPassword("SuperSecretPassword!");
        SecureAreaPage sap = page.clickLogIn();
        sap.getAlertText().trim();
        //report().log(LogStatus.PASS,"Login PASSED correctly");
        assertTrue(sap.getAlertText().contains("You logged into a secure area!!!!!"),
                "Alert text is incorrect! Check it out man...");

    }

    @Test(priority=3)
    public void dropDownTest() throws IOException {
        dropDownPage ddp = homePage.dropDownFunction();
        ddp.selectListFromDropdown();
        //report().log(LogStatus.PASS,"DropDown Function PASSED correctly");
    }

    @Test(priority=5)
    public void ContextMenuTest() throws IOException {
        contextPage cp = homePage.goToContextMenuPage();
        cp.hoverOverBox();
        cp.acceptAlert();
        //report().log(LogStatus.PASS,"HoverOverBox PASSED correctly");
    }

    @Test(priority=2)
    public void forgotPasswordTest() throws IOException {
        forgotPasswordPage fpp = homePage.requestPasswordFunction();
        emailSentPage finalPage = fpp.insertEmail();
        assertTrue(finalPage.sentenceReturned().contains("Your e-mail's been sent!"),
                "Alert email is incorrect! Check it out man...");
    }

    @Test(priority=4)
    public void disappearingElementsTest() throws InterruptedException, IOException {
        DisappearingElementsPage disEle = homePage.clickBtnDisapEle();
        disEle.clickAllButtonsInPage();
        String infoDisplayed = disEle.checkDisplayedSentence();
        assertEquals(infoDisplayed,
                "Thisx example demonstrates when elements on a page change by disappearing/reappearing on each page load.",
                "Info displayed isn't correct!! Check it out pal");
    }

    //@Test
    public void findLocationTest(){
        geoLocalPage myLocation = homePage.geolocationFunction();
        assertEquals(myLocation.geoLocationInfo(),
                "See it on Google",
                "You are not in the right page, pal!");
    }

    //@Test
    public void waitUntilTest(){
        DynLoadPage dlp = homePage.dynamicLoadFunction();
        dlp.dynamicLoadE1().clickStart();
        assertEquals(dlp.dynamicLoadE1().loadedMsg(),"Hello World!"
                ,"Message didn't appear on page");
    }

}
