package org.selenium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.selenium.BasePage;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    final String inventoryUrl = "https://www.saucedemo.com/inventory.html";
    @FindBy(how = How.CLASS_NAME, using = "bm-burger-button")
    private WebElement burgerButton;

    @FindBy(how = How.XPATH, using = "//*[@class='title'][text()='Products']")
    private WebElement products;

    @FindBy(how = How.XPATH, using = "//*[@alt='Sauce Labs Backpack']")
    private WebElement backPackImage;

    @FindBy(how = How.XPATH, using = "//*[@alt='Sauce Labs Bike Light']")
    private WebElement bikeLightImage;

    @FindBy(how = How.XPATH, using = "//*[@data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement backPackAdd;

    @FindBy(how = How.XPATH, using = "//*[@data-test='add-to-cart-sauce-labs-bike-light']")
    private WebElement bikeLightAdd;

    @FindBy(how = How.XPATH, using = "//*[@class='shopping_cart_badge']")
    private WebElement cartBadge;

    public String getInventoryUrl() {
        return inventoryUrl;
    }

    public WebElement getBurgerButton() {
        return burgerButton;
    }

    public WebElement getProducts() {
        return products;
    }

    public WebElement getBackPackImage() {
        return backPackImage;
    }

    public WebElement getBikeLightImage() {
        return bikeLightImage;
    }

    public WebElement getBackPackAdd() {
        return backPackAdd;
    }

    public WebElement getBikeLightAdd() {
        return bikeLightAdd;
    }

    public WebElement getCartBadge() {
        return cartBadge;
    }

}
