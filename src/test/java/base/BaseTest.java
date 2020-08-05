package base;

import Pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import static org.testng.reporters.Files.*;

public class BaseTest {

        private WebDriver driver;
        protected HomePage homePage;
        private ExtentReports extent;
        private ExtentTest test;

        @BeforeSuite
        public void initReport(){
            // new instance
            ExtentReports extent = new ExtentReports("./TestReport.html", true);
            File file = new File("./ScreenShots");
            if(!file.exists()){
                file.mkdir();
            }
        }

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            goHome();
            
        }

        @BeforeMethod
        public void goHome(){
            driver.get("https://the-internet.herokuapp.com/");
            homePage = new HomePage(driver);
        }

       // @BeforeMethod
        public void initTestReport(Method method){
            test = new ExtentTest(method.getName(),"");
        }

        public ExtentTest report(){
            if(test!=null){
                return test;
            }
                return null;
        }

        @AfterClass
        public void tearDown(){
            driver.quit();
        }

        @AfterMethod
        public void takeScreenShotIfFailure(ITestResult result) throws IOException {
            if(ITestResult.FAILURE == result.getStatus()) {
                TakesScreenshot camera =((TakesScreenshot)driver);
                File screenShot = camera.getScreenshotAs(OutputType.FILE);
                System.out.println("Screenshot taken: " + screenShot.getAbsolutePath());
                File DestFile = new File("./ScreenShots/"+result.getName()+"_Fail.png");
                FileHandler.copy(screenShot,DestFile);
            }

        }

        //@AfterMethod
        public void closeReport(){
            extent.endTest(test);
        }

        //@AfterSuite
        public void clearReport(){
            extent.flush();
            extent.close();
    }

        public WebDriver getDriver(){ return driver;}


}
