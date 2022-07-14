package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    private WebDriver driver;
    private By itemName = By.id("item_4_title_link");
    private By itemPrice = By.xpath("//*[@class='inventory_item_price']");
    private By taxPrice = By.xpath("//*[@class='summary_tax_label']");
    private By totalPrice = By.xpath("//*[@class='summary_total_label']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getItemName() {
        return driver.findElement(itemName);
    }

    public WebElement getItemPrice() {
        return driver.findElement(itemPrice);
    }

    public WebElement getTaxPrice() {
        return driver.findElement(taxPrice);
    }

    public WebElement getTotalPrice() {
        return driver.findElement(totalPrice);
    }
}
