package org.selenium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.selenium.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    final String cartUrl = "https://www.saucedemo.com/cart.html";

    @FindBy(how = How.XPATH, using = "//*[@class='title'][text()='Your Cart'] ")
    private WebElement yourCart;

    @FindBy(how = How.CLASS_NAME, using = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement checkoutButton;

    public String getCartUrl() {
        return cartUrl;
    }

    public WebElement getYourCart() {
        return yourCart;
    }

    public List<WebElement> getCartItems() {
        return cartItems;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }


}
