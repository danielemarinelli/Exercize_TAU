package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownPage {

    private By dropDown = By.xpath(".//select[@id='dropdown']");

    private WebDriver driver;
    public dropDownPage(WebDriver driver){ this.driver=driver; }


    public void selectListFromDropdown(){
        driver.findElement(dropDown).click();
        Select listOfElements = new Select(driver.findElement(dropDown));
        listOfElements.selectByVisibleText("Option 2");
    }
}
