package pageObjects.admin;

import commons.BasePage;
import driver.DriverManager;
import io.qameta.allure.Step;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.admin.AdminLoginPageUI;

import static commons.GlobalConstants.*;
import static pageUIs.admin.AdminLoginPageUI.*;

public class AdminLoginPageObject extends BasePage {

    public AdminLoginPageObject(String adminLoginUrl) {
        openPageUrl(adminLoginUrl);
    }

    public void openLoginPage() {
        DriverManager.getDriver().get(VIB_ADMIN_LOGIN);
    }

    public AdminHomePageObject goToAdminHomePage() {
        loginWebsite(ADMIN_ACCOUNT, ADMIN_PASSWORD);
        return new AdminHomePageObject();
    }

    @Step("Login to website")
    public AdminHomePageObject loginWebsite(String account, String password) {
        inputToAccountTextbox(account);
        inputToPasswordTextbox(password);
        clickToLoginButton();
        waitForElementVisible(TITLE_TEXT);
        return new AdminHomePageObject();
    }

    @Step("Click to Login button")
    public AdminHomePageObject clickToLoginButton() {
        waitForElementClickable(AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(AdminLoginPageUI.LOGIN_BUTTON);
        return new AdminHomePageObject();
    }

    @Step("Enter to Account textbox")
    public void inputToAccountTextbox(String account) {
        waitForElementVisible(AdminLoginPageUI.ACCOUNT_TEXTBOX);
        sendKeyToElement(AdminLoginPageUI.ACCOUNT_TEXTBOX, account);
    }

    @Step("Enter to Password textbox")
    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login button")
    public void clickToIconEyeSlash() {
        waitForElementClickable(AdminLoginPageUI.ICON_EYE);
        clickToElement(AdminLoginPageUI.ICON_EYE);
    }

    @Step("Click to Account textbox")
    public void clickToAccountTextbox() {
        waitForElementClickable(ADMIN_ACCOUNT_TEXT);
        clickToElement(ADMIN_ACCOUNT_TEXT);
    }

    @Step("Click to Password textbox")
    public void clickToPasswordTextbox() {
        waitForElementClickable(AdminLoginPageUI.ADMIN_PASSWORD_TEXT);
        clickToElement(AdminLoginPageUI.ADMIN_PASSWORD_TEXT);
    }

    @Step("Verify Error Message At Account Textbox")
    public String getErrorMessageAtAccountTextbox() {
        waitForElementVisible(AdminLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
        return getElementText(AdminLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Error Message At Passwork Textbox")
    public String getErrorMessageAtPassworkTextbox() {
        waitForElementVisible(AdminLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
        return getElementText(AdminLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Modal Confirm Displayed")
    public boolean isModalConfirmDisplayed() {
        waitForElementVisible(AdminLoginPageUI.MODAL_TEXT);
        return isElementDisplay(AdminLoginPageUI.MODAL_TEXT);
    }

    public void inputUserName(String userName) {
        waitForElementClickable(AdminHomePageUI.USER_NAME);
        sendKeyToElement(AdminHomePageUI.USER_NAME, userName);
    }
    public void inputPassword(String password) {
        waitForElementClickable(AdminHomePageUI.PASSWORD);
        sendKeyToElement(AdminHomePageUI.PASSWORD, password);
    }

    public String getTitle() {
        waitForElementVisible(AdminLoginPageUI.TITLE_TEXT);
        return getElementText(TITLE_TEXT);
    }
}