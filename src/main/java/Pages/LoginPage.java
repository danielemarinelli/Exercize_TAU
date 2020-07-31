package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    //@FindBy(xpath=".//input[@id='username']")
    //private WebElement userField;
    private By userField = By.xpath(".//input[@id='username']");

    //@FindBy(xpath=".//input[@id='password']")
    //private WebElement pwdField;
    private By pwdField = By.xpath(".//input[@id='password']");

    //@FindBy(xpath=".//i[@class='fa fa-2x fa-sign-in']")
    //private WebElement btnLogin;
    private By btnLogin = By.xpath(".//i[@class='fa fa-2x fa-sign-in']");

    public LoginPage(WebDriver driver){ this.driver=driver; }

    public void SetUser(String user){
        driver.findElement(userField).sendKeys(user);
        //userField.sendKeys(user);
    }

    public void SetPassword(String password){
        driver.findElement(pwdField).sendKeys(password);
        //pwdField.sendKeys(password);
    }

    public SecureAreaPage clickLogIn(){
        driver.findElement(btnLogin).click();
        //btnLogin.click();
        return new SecureAreaPage(driver);
    }


}
