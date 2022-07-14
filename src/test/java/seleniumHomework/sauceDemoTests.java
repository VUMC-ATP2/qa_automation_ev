package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

@Log4j
public class sauceDemoTests {

    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initialize ChromeWebDriver");
        this.driver = new ChromeDriver();
    }

    @Test
    public void scenario1() {

        System.out.println("Running scenario #1!");

        // 1. Navigēt uz saiti https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // 2. Ielogoties ar pareizu lietotāja vārdu/paroli
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        // 3. Pārbaudīt, ka lietotājs ir ielogojies
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        // 4. Ievietot Grozā 1 produktu
        inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartButton();

        // 5. Doties uz grozu
        cartPage = new CartPage(driver);
        cartPage.clickShoppingCartButton();

        // 6. Pārbaudīt, kā šī prece ir grozā
        Assert.assertEquals(cartPage.getItemInCart().getText(), "Sauce Labs Backpack");

        // 7. Doties uz Checkout
        cartPage.clickCheckoutButton();

        // 8. Ievadīt vārdu/uzvārdu/pasta indeksu
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstName("Name");
        checkoutPage.setLastName("Last");
        checkoutPage.setZipCode("LV-1099");
        checkoutPage.clickCheckoutContinueButton();

        // 9. Doties uz Checkout overview lapu, pārbaudīt datus
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverviewPage.getItemPrice().getText(), "$29.99");
        Assert.assertEquals(checkoutOverviewPage.getTaxPrice().getText(), "Tax: $2.40");
        Assert.assertEquals(checkoutOverviewPage.getTotalPrice().getText(), "Total: $32.39");

        // 10. Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
        checkoutSuccessPage.clickFinishButton();

        // 11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'
        checkoutSuccessPage.clickBackHomeButton();
    }

    @Test
    public void scenario2() {

        System.out.println("Running scenario #2!");

        // 1. Navigēt uz saiti https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // 2. Ielogoties ar pareizu lietotāja vārdu/paroli
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        // 3. Doties uz grozu
        cartPage = new CartPage(driver);
        cartPage.clickShoppingCartButton();

        // 4. Doties uz Checkout
        cartPage.clickCheckoutButton();

        // 5. Pārbaudīt, ka FirstName/LastName/Zip code ir obligāts
        // 6. Pārbaudīt, ka forma parāda pareizu kļūdas paziņojumu pie katra neievadītā lauka
        checkoutPage = new CheckoutPage(driver);//checkoutPage.setFirstName("Name");
        checkoutPage.clickCheckoutContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageContainer().getText(), "Error: First Name is required");
        checkoutPage.setFirstName("Name");
        checkoutPage.clickCheckoutContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageContainer().getText(), "Error: Last Name is required");
        checkoutPage.setLastName("Last");
        checkoutPage.clickCheckoutContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageContainer().getText(), "Error: Postal Code is required");
        checkoutPage.setZipCode("LV-1099");
        checkoutPage.clickCheckoutContinueButton();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Closing ChromeWebDriver");
        driver.close();
        driver.quit();
    }
}