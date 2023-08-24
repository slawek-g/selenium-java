package org.selenium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.selenium.BasePage;

public class CheckOutCompletePage extends BasePage {

    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    final String checkoutCompleteUrl = "https://www.saucedemo.com/checkout-complete.html";

    @FindBy(how = How.XPATH, using = "//*[@class='title'][text()='Checkout: Complete!']")
    private WebElement checkoutComplete;

    @FindBy(how = How.XPATH, using = "//*[@class='complete-header'][text()='Thank you for your order!']")
    private WebElement thanksForOrder;

    public String getCheckoutCompleteUrl() {
        return checkoutCompleteUrl;
    }

    public WebElement getCheckoutComplete() {
        return checkoutComplete;
    }

    public WebElement getThanksForOrder() {
        return thanksForOrder;
    }


}
