package pageObjects.usermanager;

import commons.BasePage;
import pageUIs.usermanager.UserManagerHomePageUI;


public class CreateUserPageObject extends BasePage {

    public boolean isCreateUserDisplayed() {
        waitForElementVisible(UserManagerHomePageUI.CREATE_USER_TEXT);
        return isElementDisplay(UserManagerHomePageUI.CREATE_USER_TEXT);
    }

    public void inputFullName(String fullName) {
        waitForElementVisible(UserManagerHomePageUI.FULL_NAME);
        sendKeyToElement(UserManagerHomePageUI.FULL_NAME,fullName);
    }

    public void inputPhoneNumber(String phoneNumber) {
        waitForElementVisible(UserManagerHomePageUI.PHONE_NUMBER);
        sendKeyToElement(UserManagerHomePageUI.PHONE_NUMBER,phoneNumber);
    }

    public void inputBirthDay(String birthDay) {
        waitForElementVisible(UserManagerHomePageUI.BIRTH_DAY);
        sendKeyToElement(UserManagerHomePageUI.BIRTH_DAY,birthDay);
    }

    public void inputEmail(String email) {
        waitForElementVisible(UserManagerHomePageUI.EMAIL);
        sendKeyToElement(UserManagerHomePageUI.EMAIL,email);
    }

    public void inputIdentityNumber(String identityNumber) {
        waitForElementVisible(UserManagerHomePageUI.IDENTITY_NUMBER);
        sendKeyToElement(UserManagerHomePageUI.IDENTITY_NUMBER,identityNumber);
    }

    public void clickUnit() {
        waitForElementVisible(UserManagerHomePageUI.UNIT);
        selecItemInDefaultDropdown(UserManagerHomePageUI.UNIT,"AUTOMATION - Automation");
    }

    public void inputUserName(String userName) {
        waitForElementVisible(UserManagerHomePageUI.USER_NAME);
        sendKeyToElement(UserManagerHomePageUI.USER_NAME,userName);
    }

    public void inputPassword(String password) {
        waitForElementVisible(UserManagerHomePageUI.PASSWORD);
        sendKeyToElement(UserManagerHomePageUI.PASSWORD,password);
    }

    public void inputPasswordRepeat(String password) {
        waitForElementVisible(UserManagerHomePageUI.PASSWORD_REPEAT);
        sendKeyToElement(UserManagerHomePageUI.PASSWORD_REPEAT,password);
    }

    public void clickGroupUser() {
        waitForElementVisible(UserManagerHomePageUI.CHECK_GROUP_USER_QTHT);
//        checkToDefaultCheckBoxOrRadio(UserManagerHomePageUI.CHECK_GROUP_USER_QTNV);
        checkToDefaultCheckBoxOrRadio(UserManagerHomePageUI.CHECK_GROUP_USER_QTHT);
    }

    public void clickSubmitButton() {
        waitForElementVisible(UserManagerHomePageUI.BUTTON_SUBMIT);
        clickToElement(UserManagerHomePageUI.BUTTON_SUBMIT);
    }

    public boolean isSubmitCreateButtonEnable() {
        waitForElementVisible(UserManagerHomePageUI.BUTTON_SUBMIT);
        return isElementEnable(UserManagerHomePageUI.BUTTON_SUBMIT);
    }

    public void clickGender() {
        waitForElementVisible(UserManagerHomePageUI.PARENT_GENDER);
        selecItemInDefaultDropdown(UserManagerHomePageUI.PARENT_GENDER,"Nam");
    }

    public void clickProvince() {
        waitForElementVisible(UserManagerHomePageUI.PARENT_PROVINCE);
        selecItemInDefaultDropdown(UserManagerHomePageUI.PARENT_PROVINCE,"Hà Nam");
    }

    public void clickCountry() {
        waitForElementVisible(UserManagerHomePageUI.PARENT_COUNTRY);
        selecItemInDefaultDropdown(UserManagerHomePageUI.PARENT_COUNTRY,"Việt Nam");
    }

    public void clickIdentityType() {
        waitForElementVisible(UserManagerHomePageUI.PARENT_IDENTITY_TPYE);
        selecItemInDefaultDropdown(UserManagerHomePageUI.PARENT_IDENTITY_TPYE,"CCCD");
    }

    public void inputSupplyDate(String supplyDate) {
        waitForElementVisible(UserManagerHomePageUI.SUPPLY_DATE);
        sendKeyToElement(UserManagerHomePageUI.SUPPLY_DATE,supplyDate);
    }

    public void inputPermanentAddress(String permanentAddress) {
        waitForElementVisible(UserManagerHomePageUI.PERMANENT_ADDRESS);
        sendKeyToElement(UserManagerHomePageUI.PERMANENT_ADDRESS,permanentAddress);
    }

    public void inputCurrentAddress(String currentAddress) {
        waitForElementVisible(UserManagerHomePageUI.CURRENT_ADDRESS);
        sendKeyToElement(UserManagerHomePageUI.CURRENT_ADDRESS,currentAddress);
    }

    public void clickOrganizationId() {
        waitForElementVisible(UserManagerHomePageUI.PARENT_ORGANIZATION_ID);
        selecItemInDefaultDropdown(UserManagerHomePageUI.PARENT_ORGANIZATION_ID," VIB - Ngân hàng thương mại cổ phần Quốc tế Việt Nam ");
    }

    public void inputSupplyPlace(String supplyPlace) {
        waitForElementVisible(UserManagerHomePageUI.SUPPLY_PLACE);
        sendKeyToElement(UserManagerHomePageUI.SUPPLY_PLACE,supplyPlace);
    }
}