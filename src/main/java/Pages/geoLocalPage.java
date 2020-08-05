package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class geoLocalPage {
    private WebDriver driver;

    private By btnWhere = By.xpath(".//div[@class='example']/button");
    private By btnGoogle = By.xpath(".//div[@id='map-link']/a");
            //By.xpath(".//a[contains(text(),'Google')]");
    private By latitude = By.xpath("(.//p[@id='demo']/div)[1]");
            //By.xpath(".//div[@id='lat-value']");
    private By longitude = By.xpath("(.//p[@id='demo']/div)[2]");
                    //By.xpath(".//div[@id='long-value']");

    public geoLocalPage(WebDriver driver){ this.driver=driver; }

    public String geoLocationInfo(){
        driver.findElement(btnWhere).click();

        //System.out.println("This is your location in the Earth: "+
          //      driver.findElement(latitude).getText()+","+
            //    driver.findElement(longitude).getText());
        return driver.findElement(btnGoogle).getText();

    }

}
