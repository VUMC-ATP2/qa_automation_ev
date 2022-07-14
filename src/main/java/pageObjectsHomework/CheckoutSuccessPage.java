package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSuccessPage {

    private WebDriver driver;
    private By finishButton = By.id("finish");
    private By backHomeButton = By.id("back-to-products");

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }
}
