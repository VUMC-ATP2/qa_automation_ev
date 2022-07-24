package pageObjectsGherkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebDriverManager;

public class CheckoutOverviewPageGherkin {

    WebDriver driver = WebDriverManager.getInstance();
    private By itemName = By.id("item_4_title_link");
    private By itemPrice = By.xpath("//*[@class='inventory_item_price']");
    private By taxPrice = By.xpath("//*[@class='summary_tax_label']");
    private By totalPrice = By.xpath("//*[@class='summary_total_label']");

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

    public void verifyCheckoutData() {
        Assert.assertEquals(getItemName().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(getItemPrice().getText(), "$29.99");
        Assert.assertEquals(getTaxPrice().getText(), "Tax: $2.40");
        Assert.assertEquals(getTotalPrice().getText(), "Total: $32.39");
    }
}
