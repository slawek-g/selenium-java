package org.selenium.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.selenium.DriverFactory.WebDriverFactory;
import org.selenium.PageFactory.*;

import static org.assertj.core.api.Assertions.assertThat;


public class Steps {
    private WebDriver driver;

    private final String MVN_BROWSER = System.getProperty("browser");

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckOutPageOne checkOutPageOne;
    CheckOutPageTwo checkOutPageTwo;
    CheckOutCompletePage checkOutCompletePage;


    @Before
    public void setupDriver() {
        driver = WebDriverFactory.getBrowser(MVN_BROWSER);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkOutPageOne = new CheckOutPageOne(driver);
        checkOutPageTwo = new CheckOutPageTwo(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);


    }

    @After
    public void QuitDriver() {
        driver.quit();
    }

    @Given("user is on test automation page and use {string}")
    public void userIsOnTestAutomationPage(String login) {
        loginPage.madeFullLogging(login);
    }

    @Given("user is on test automation page and tries to login")
    public void wrongCredentials() {
        loginPage.madeWrongFullLogging();
    }

    @When("user verifying automation homepage")
    public void userVerifyingAutomationHomepage() {
        assertThat("https://www.saucedemo.com/").isEqualTo(driver.getCurrentUrl());

    }

    @When("user is on inventory page")
    public void userIsOnInventoryPage() {
        assertThat(inventoryPage.getInventoryUrl()).isEqualTo(driver.getCurrentUrl());
        inventoryPage.getProducts().isDisplayed();

    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        assertThat("Epic sadface: Username and password " +
                "do not match any user in this service").isEqualTo(loginPage.getWrongCredentials().getText());

    }

    @Given("user is on test automation page and tries to login with specific login")
    public void loginLockedUser() {
        loginPage.inputLockedUser();
    }

    @When("user get response")
    public void userGetResponse() {
        assertThat("Epic sadface: Sorry, this user has been locked out.")
                .isEqualTo(loginPage.getLockedUser().getText());

    }

    @Then("user is buying BackPack and Bike Light")
    public void userBuyingBackPackAndBikeLight() {
        assertThat(inventoryPage.getBackPackImage().isDisplayed()).isTrue();
        inventoryPage.getBackPackAdd().click();
        assertThat(inventoryPage.getBikeLightImage().isDisplayed()).isTrue();
        inventoryPage.getBikeLightAdd().click();
        assertThat("2").isEqualTo(inventoryPage.getCartBadge().getText());
        inventoryPage.getCartBadge().click();
    }

    @When("user check his cart")
    public void userIsHisCartPage() {
        assertThat(cartPage.getCartUrl()).isEqualTo(driver.getCurrentUrl());
        assertThat(cartPage.getYourCart().isDisplayed()).isTrue();
        assertThat(2).isEqualTo(cartPage.getCartItems().size());
        cartPage.getCheckoutButton().click();
    }

    @When("fill all data, first name {string} surname {string} and postal code {string}")
    public void fillData(String name, String surname, String postal) {
        assertThat(checkOutPageOne.getCheckoutUrl1()).isEqualTo(driver.getCurrentUrl());
        assertThat(checkOutPageOne.getYourInfo().isDisplayed()).isTrue();
        checkOutPageOne.checkoutDetailsInput(name, surname, postal);
    }

    @When("confirm total payment")
    public void confirmTotalPayment() {
        assertThat(checkOutPageTwo.getCheckoutUrl2()).isEqualTo(driver.getCurrentUrl());
        assertThat(checkOutPageTwo.getCheckoutOverview().isDisplayed()).isTrue();
        assertThat(2).isEqualTo(checkOutPageTwo.getCartItem().size());
        checkOutPageTwo.getFinishButton().click();
    }

    @When("finish order")
    public void finishOrder() {
        assertThat(checkOutCompletePage.getCheckoutCompleteUrl()).isEqualTo(driver.getCurrentUrl());
        assertThat(checkOutCompletePage.getCheckoutComplete().isDisplayed()).isTrue();
        assertThat(checkOutCompletePage.getThanksForOrder().isDisplayed()).isTrue();
    }

}
