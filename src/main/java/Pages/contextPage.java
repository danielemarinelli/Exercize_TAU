package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class contextPage {

    private WebDriver driver;

    //@FindBy(xpath=".//div[@id='hot-spot']")
    //private WebElement hotSpotBox;
    private By hotSpotBox = By.xpath(".//div[@id='hot-spot']");

    public contextPage (WebDriver driver){ this.driver=driver; }

    public void hoverOverBox(){
        WebElement box = driver.findElement(hotSpotBox);
        Actions act = new Actions(driver);
        //act.moveToElement(box).
        act.contextClick(box).build().perform();
        //act.contextClick(hotSpotBox).perform();
    }

    public void acceptAlert(){ driver.switchTo().alert().accept(); }
}
