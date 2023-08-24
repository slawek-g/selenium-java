package org.selenium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.selenium.BasePage;

public class CheckOutPageOne extends BasePage {

    public CheckOutPageOne(WebDriver driver) {
        super(driver);
    }

    final String checkoutUrl1 = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(how = How.XPATH, using = "//*[@class='title'][text()='Checkout: Your Information']")
    private WebElement yourInfo;

    @FindBy(how = How.ID, using = "first-name")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "last-name")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "postal-code")
    private WebElement postalCode;

    @FindBy(how = How.ID, using = "continue")
    private WebElement continueButton;

    public String getCheckoutUrl1() {
        return checkoutUrl1;
    }

    public WebElement getYourInfo() {
        return yourInfo;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }


    public void checkoutDetailsInput(String name, String surname, String postal) {
        firstName.sendKeys(name);
        lastName.sendKeys(surname);
        postalCode.sendKeys(postal);
        continueButton.click();

    }
}
