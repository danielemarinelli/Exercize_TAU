package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class forgotPasswordPage {

    private WebDriver driver;

    private By fieldEmail = By.xpath(".//input[@id='email']");
    private By btnRetrive = By.xpath(".//i[@class='icon-2x icon-signin']");

    public forgotPasswordPage(WebDriver driver){ this.driver=driver; }

    public emailSentPage insertEmail(){
        driver.findElement(fieldEmail).sendKeys("dan@testqa.com");
        driver.findElement(btnRetrive).click();
        return new emailSentPage(driver);
    }


}
