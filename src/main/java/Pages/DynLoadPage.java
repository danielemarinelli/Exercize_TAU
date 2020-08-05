package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynLoadPage {

    private WebDriver driver;
    private By loadExample1 = By.xpath(".//a[contains(text(),'Example 1')]");
    private By loadExample2 = By.xpath(".//a[contains(text(),'Example 2')]");

    public DynLoadPage(WebDriver driver){ this.driver=driver; }

    public DynamicLoadExample1Page dynamicLoadE1(){
        driver.findElement(loadExample1).click();
        return new DynamicLoadExample1Page(driver);
    }

}
