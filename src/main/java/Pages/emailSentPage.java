package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class emailSentPage {

    private WebDriver driver;
    public emailSentPage(WebDriver driver){ this.driver=driver; }

    //@FindBy(xpath=".//div[@id='flash']")
    //private WebElement statusAlert;
    private By statusDisplayed = By.xpath(".//div[@id='content']");

    public String sentenceReturned(){
        return driver.findElement(statusDisplayed).getText().trim();
    }

}
