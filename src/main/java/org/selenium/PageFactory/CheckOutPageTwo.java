package org.selenium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.selenium.BasePage;

import java.util.List;

public class CheckOutPageTwo extends BasePage {

    public CheckOutPageTwo(WebDriver driver) {
        super(driver);
    }

    final String checkoutUrl2 = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(how = How.XPATH, using = "//*[@class='title'][text()='Checkout: Overview']")
    private WebElement checkoutOverview;

    @FindBy(how = How.CLASS_NAME, using = "cart_item")
    private List<WebElement> cartItem;

    @FindBy(how = How.XPATH, using = "//*[@class='summary_info_label summary_total_label']")
    private WebElement total;

    @FindBy(how = How.ID, using = "finish")
    private WebElement finishButton;

    public String getCheckoutUrl2() {
        return checkoutUrl2;
    }

    public WebElement getCheckoutOverview() {
        return checkoutOverview;
    }

    public List<WebElement> getCartItem() {
        return cartItem;
    }

    public WebElement getTotal() {
        return total;
    }

    public WebElement getFinishButton() {
        return finishButton;
    }

}
