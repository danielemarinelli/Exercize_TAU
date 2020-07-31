package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage {
    private WebDriver driver;
    public SecureAreaPage(WebDriver driver){ this.driver=driver; }

    //@FindBy(xpath=".//div[@id='flash']")
    //private WebElement statusAlert;
    private By statusAlert = By.xpath(".//div[@id='flash']");

    public String getAlertText() {
        return driver.findElement(statusAlert).getText().trim();

    }
}
