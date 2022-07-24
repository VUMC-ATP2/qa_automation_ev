package pageObjectsGherkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class CheckoutSuccessPageGherkin {

    WebDriver driver = WebDriverManager.getInstance();
    private By finishButton = By.id("finish");
    private By backHomeButton = By.id("back-to-products");
    private By checkoutComplete = By.xpath("//*[@class='complete-header']");

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public WebElement getCheckoutComplete() {
        return driver.findElement(checkoutComplete);
    }

    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }
}
