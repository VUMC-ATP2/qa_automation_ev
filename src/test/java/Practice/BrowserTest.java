package Practice;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Slf4j
public class BrowserTest {
    ChromeDriver driver;

    @BeforeTest
    public void setProperties(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        log.info("Initialize ChromeWebDriver");
        this.driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @Test
    public void chromeDividerTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        log.info("Closing ChromeWebDriver");
        driver.close();
    }
}
