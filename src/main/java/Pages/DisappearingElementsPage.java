package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisappearingElementsPage {

    private WebDriver driver;
    private By btnContactUs = By.xpath(".//a[contains(text(),'Us')]");
    private By btnAbout = By.xpath(".//a[contains(text(),'bou')]");
    private By btnPortfolio = By.xpath(".//a[contains(text(),'folio')]");
    private By displayedMessage = By.xpath(".//div[@class='example']/p");

    public DisappearingElementsPage (WebDriver driver){ this.driver=driver; }

    public void clickAllButtonsInPage() throws InterruptedException {
        driver.findElement(btnContactUs).click();
        Thread.sleep(1000);
        driver.navigate().back();
        System.out.println("I am clicking About...");
        Thread.sleep(1000);
        driver.findElement(btnAbout).click();
        System.out.println("I am clicking Portfolio...");
        Thread.sleep(1000);
        driver.navigate().back();
        driver.findElement(btnPortfolio).click();
        Thread.sleep(1000);
        driver.navigate().back();

    }

    public String checkDisplayedSentence(){
        String testToCheck = driver.findElement(displayedMessage).getText();
        return testToCheck;
    }
}
