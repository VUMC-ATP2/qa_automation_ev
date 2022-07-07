package mavenTestNGHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j
public class BrowserTitleTest {

    ChromeDriver chromeDriver;

    @BeforeClass
    public void taskLaunch() {
        System.out.println("######## 2.uzdevums! ########");
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initialize ChromeWebDriver");
        this.chromeDriver = new ChromeDriver();
    }

    @Test
    public void firstBrowserTitleTest() {
        chromeDriver.get("https://www.lsm.lv/");
        Assert.assertEquals(chromeDriver.getTitle(), "LSM.lv - Uzticamas ziņas");
    }

    @Test
    public void secondBrowserTitleTest() {
        chromeDriver.get("https://www.bbc.com/");
        Assert.assertEquals(chromeDriver.getTitle(), "BBC - Homepage");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        log.info("Closing ChromeWebDriver");
        chromeDriver.close();
        chromeDriver.quit();
    }
}
