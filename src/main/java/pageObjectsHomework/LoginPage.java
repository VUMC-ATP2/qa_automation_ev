package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton =  By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(usernameField);
    }
    public void setUsername(String value) {
        driver.findElement(usernameField).sendKeys(value);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }
    public void setPassword(String value) {
        driver.findElement(passwordField).sendKeys(value);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
