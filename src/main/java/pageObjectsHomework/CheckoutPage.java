package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By checkoutContinueButton = By.id("continue");
    private By errorMessageContainer = By.xpath("//*[@class='error-message-container error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }
    public void setFirstName(String value) {
        driver.findElement(firstNameField).sendKeys(value);
    }

    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }
    public void setLastName(String value) {
        driver.findElement(lastNameField).sendKeys(value);
    }

    public WebElement getZipCodeField() {
        return driver.findElement(zipCodeField);
    }
    public void setZipCode(String value) {
        driver.findElement(zipCodeField).sendKeys(value);
    }

    public void clickCheckoutContinueButton() {
        driver.findElement(checkoutContinueButton).click();
    }

    public WebElement getErrorMessageContainer() {
        return driver.findElement(errorMessageContainer);
    }
}
