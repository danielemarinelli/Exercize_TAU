package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadExample1Page {

    private WebDriver driver;
    private By btnStart = By.xpath(".//div[@id='start']/button");
    private By loadIndicator = By.xpath(".//div[@id='loading']");
    private By loadedText = By.xpath(".//div[@id='finish']");

    public DynamicLoadExample1Page(WebDriver driver){ this.driver=driver; }

    public void clickStart(){
        driver.findElement(btnStart).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(
                driver.findElement(loadIndicator)));
    }

    public String loadedMsg(){
        return driver.findElement(loadedText).getText();
    }

}
