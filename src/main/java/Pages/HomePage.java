package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    private By btnContextMenu = By.xpath(".//a[text()='Context Menu']");
    private By btnAuthentication = By.xpath(".//a[contains(text(),'Form A')]");
    private By btnDropDown = By.xpath(".//a[text()='Dropdown']");
    private By listDropDown = By.xpath(".//select[@id='dropdown']");
    private By btnForgotPw = By.xpath(".//a[contains(text(),'got Pass')]");
    private By btnGeolocal = By.xpath(".//a[text()='Geolocation']");
    private By btnDynamicLoad = By.xpath(".//a[contains(text(),'amic Loa')]");
    private By btnDisapEle = By.xpath(".//a[contains(text(),'Disa')]");

    public HomePage(WebDriver driver){ this.driver=driver; }

    public contextPage goToContextMenuPage(){
        driver.findElement(btnContextMenu).click();
        return new contextPage(driver);
        }

     public LoginPage clickFormAuthentication()  {
        WebElement btnAut = driver.findElement(btnAuthentication);
        btnAut.click();
            //btnAuthentication.click();
            return new LoginPage(driver);
     }

    public dropDownPage dropDownFunction(){
        driver.findElement(btnDropDown).click();
        return new dropDownPage(driver);
    }

    public forgotPasswordPage requestPasswordFunction(){
        driver.findElement(btnForgotPw).click();
        return new forgotPasswordPage(driver);
    }

    public geoLocalPage geolocationFunction(){
        driver.findElement(btnGeolocal).click();
        return new geoLocalPage(driver);
    }

    public DynLoadPage dynamicLoadFunction(){
        driver.findElement(btnDynamicLoad).click();
        return new DynLoadPage(driver);
    }

    public DisappearingElementsPage clickBtnDisapEle(){
        driver.findElement(btnDisapEle).click();
        return new DisappearingElementsPage(driver);
    }

}
