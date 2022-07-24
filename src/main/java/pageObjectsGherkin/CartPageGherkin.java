package pageObjectsGherkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class CartPageGherkin {

    WebDriver driver = WebDriverManager.getInstance();
    private By shoppingCartButton = By.id("shopping_cart_container");
    private By itemInCart = By.id("item_4_title_link");
    private By checkoutButton = By.id("checkout");

    public void clickShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
    }

    public WebElement getItemInCart() {
        return driver.findElement(itemInCart);
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}