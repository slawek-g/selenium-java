package org.selenium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.selenium.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    final String webUrl = "https://www.saucedemo.com/";
    @FindBy(how = How.ID, using = "user-name")
    private WebElement userLink;

    @FindBy(how = How.ID, using = "password")
    private WebElement passLink;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Epic sadface: Username and password do not match any user in this service']")
    private WebElement wrongCredentials;

    @FindBy(how = How.XPATH, using = "//*[text()='Epic sadface: Sorry, this user has been locked out.']")
    private WebElement lockedUser;

    public String getWebUrl() {
        return webUrl;
    }

    public WebElement getUserLink() {
        return userLink;
    }

    public WebElement getPassLink() {
        return passLink;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWrongCredentials() {
        return wrongCredentials;
    }

    public WebElement getLockedUser() {
        return lockedUser;
    }

    public void loginAndPassword(String userName, String password) {
        getDriver().navigate().to(webUrl);
        userLink.sendKeys(userName);
        passLink.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();
    }


    public void madeFullLogging(String login) {
        getDriver().navigate().to(webUrl);
        loginAndPassword(login, "secret_sauce");
        loginButtonClick();
    }

    public void madeWrongFullLogging() {
        getDriver().navigate().to(webUrl);
        loginAndPassword("standard", "secret");
        loginButtonClick();
    }


    public void inputLockedUser() {
        loginAndPassword("locked_out_user", "secret_sauce");
        loginButtonClick();
    }

}
