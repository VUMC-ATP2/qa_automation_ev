package pageObjectsGherkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverManager;

public class InventoryPageGherkin {

    WebDriver driver = WebDriverManager.getInstance();
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }
}