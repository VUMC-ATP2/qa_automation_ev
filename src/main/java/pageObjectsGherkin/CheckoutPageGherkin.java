package pageObjectsGherkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebDriverManager;

public class CheckoutPageGherkin {

    WebDriver driver = WebDriverManager.getInstance();
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By checkoutContinueButton = By.id("continue");
    private By errorMessageContainer = By.xpath("//*[@class='error-message-container error']");

    public void clickCheckoutContinueButton() {
        driver.findElement(checkoutContinueButton).click();
    }

    public WebElement getErrorMessageContainer() {
        return driver.findElement(errorMessageContainer);
    }

    public void enterCheckoutData(String name, String lastname, String postalCode) {
        driver.findElement(firstNameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(zipCodeField).sendKeys(postalCode);
    }
}