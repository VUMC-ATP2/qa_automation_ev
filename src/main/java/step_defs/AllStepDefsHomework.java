package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectsGherkin.*;
import utils.WebDriverManager;

public class AllStepDefsHomework {

    WebDriver driver = WebDriverManager.getInstance();
    LoginPageGherkin loginPage = new LoginPageGherkin();
    InventoryPageGherkin inventoryPage = new InventoryPageGherkin();
    CartPageGherkin cartPage = new CartPageGherkin();
    CheckoutPageGherkin checkoutPage = new CheckoutPageGherkin();
    CheckoutOverviewPageGherkin checkoutOverviewPage = new CheckoutOverviewPageGherkin();
    CheckoutSuccessPageGherkin checkoutSuccessPage = new CheckoutSuccessPageGherkin();

    @Given("I navigate to login page")
    public void loginPage() {
        driver.get("https://www.saucedemo.com/");
    }
    @And("I login with {string} and {string}")
    public void loginUsing(String username, String password) { loginPage.authorize(username, password);
    }
    @Then("I am successfully logged in")
    public void checkSuccessLogin() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Given("I add item to cart")
        public void selectInventoryItem() {
            inventoryPage.clickAddToCartButton();
        }
    @Then("I navigate to cart page")
    public void clickCart() {
        cartPage.clickShoppingCartButton();
    }
    @When("I verify item in cart")
    public void verifyItemInCart() {
        Assert.assertEquals(cartPage.getItemInCart().getText(), "Sauce Labs Backpack");
    }
    @Then("I go to checkout")
    public void clickCheckout() {
        cartPage.clickCheckoutButton();
    }
    @Given("I fill in {string}, {string} and {string}")
    public void enterCheckoutData(String name, String lastname, String postalCode) {
        checkoutPage.enterCheckoutData(name, lastname, postalCode);
    }
    @Then("I go to checkout continue")
    public void checkoutContinue() {
        checkoutPage.clickCheckoutContinueButton();
    }
    @Given("I verify data in checkout overview")
    public void verifyCheckoutData() {
        checkoutOverviewPage.verifyCheckoutData();
    }
    @Then("I go to finish page")
    public void goToFinish() {
        checkoutSuccessPage.clickFinishButton();
    }
    @When("I verify checkout done successfully")
    public void verifySuccessfulCheckout() {
        Assert.assertEquals(checkoutSuccessPage.getCheckoutComplete().getText(), "THANK YOU FOR YOUR ORDER");
    }
    @Then("I go back to home page")
    public void goToHome() {
        checkoutSuccessPage.clickBackHomeButton();
    }

    @Then("I verify {string} message")
    public void verifyErrorMessage(String error) {
        Assert.assertEquals(checkoutPage.getErrorMessageContainer().getText(), error);
    }
}
