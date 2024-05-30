package pageObjects.camanager;

import commons.BasePage;
import pageUIs.camanager.CaManagerHomePageUI;


public class CreateCaPageObject extends BasePage {

    public boolean isCreateCaDisplayed() {
        waitForElementVisible(CaManagerHomePageUI.CREATE_CA_TEXT);
        return isElementDisplay(CaManagerHomePageUI.CREATE_CA_TEXT);
    }

    public void clickOrganizationUnit() {
        waitForElementVisible(CaManagerHomePageUI.ORGANIZATION_UNIT_ID);
        selecItemInDefaultDropdown(CaManagerHomePageUI.ORGANIZATION_UNIT_ID,"AUTOMATION - Automation");
    }

    public void clickIndividuals() {
        waitForElementVisible(CaManagerHomePageUI.RADIO_INDIVIDUALS);
        checkToDefaultCheckBoxOrRadio(CaManagerHomePageUI.RADIO_INDIVIDUALS);
    }

    public void inputFullName(String fullName) {
        waitForElementVisible(CaManagerHomePageUI.FULL_NAME);
        sendKeyToElement(CaManagerHomePageUI.FULL_NAME,fullName);
    }

    public void clickIdentityTypeCCCD() {
        waitForElementVisible(CaManagerHomePageUI.IDENTITY_TYPE);
        selecItemInDefaultDropdown(CaManagerHomePageUI.IDENTITY_TYPE,"CCCD");
    }

    public void inputIdentity(String cccd) {
        waitForElementVisible(CaManagerHomePageUI.IDENTITY_NUMBER);
        sendKeyToElement(CaManagerHomePageUI.IDENTITY_NUMBER,cccd);
    }

    public void inputPhoneNumber(String phoneNumber) {
        waitForElementVisible(CaManagerHomePageUI.PHONE_NUMBER);
        sendKeyToElement(CaManagerHomePageUI.PHONE_NUMBER,phoneNumber);
    }
    public void inputEmail(String email) {
        waitForElementVisible(CaManagerHomePageUI.EMAIL);
        sendKeyToElement(CaManagerHomePageUI.EMAIL,email);
    }

    public void clickProvince() {
        waitForElementVisible(CaManagerHomePageUI.PROVINCE);
        selecItemInDefaultDropdown(CaManagerHomePageUI.PROVINCE,"Hà Nội");
    }

    public void clickNation() {
        waitForElementVisible(CaManagerHomePageUI.NATION);
        selecItemInDefaultDropdown(CaManagerHomePageUI.NATION,"Việt Nam");
    }

    public void inputAddress(String address) {
        waitForElementVisible(CaManagerHomePageUI.ADDRESS);
        sendKeyToElement(CaManagerHomePageUI.ADDRESS,address);
    }
    public boolean isSubmitCreateButtonEnable() {
        waitForElementVisible(CaManagerHomePageUI.BUTTON_SUBMIT);
        return isElementEnable(CaManagerHomePageUI.BUTTON_SUBMIT);
    }
    public void clickSubmitButton() {
        waitForElementVisible(CaManagerHomePageUI.BUTTON_SUBMIT);
        clickToElement(CaManagerHomePageUI.BUTTON_SUBMIT);
    }

    public boolean ismessageCreateSuccessfullyDisplayed() {
        waitForElementVisible(CaManagerHomePageUI.CREATE_SUCCESSFULLY);
        return isElementDisplay(CaManagerHomePageUI.CREATE_SUCCESSFULLY);
    }

    public void clickIdentityTypeCMND() {
        waitForElementVisible(CaManagerHomePageUI.IDENTITY_TYPE);
        selecItemInDefaultDropdown(CaManagerHomePageUI.IDENTITY_TYPE,"CMND");
    }

    public void clickIdentityTypePassPort() {
        waitForElementVisible(CaManagerHomePageUI.IDENTITY_TYPE);
        selecItemInDefaultDropdown(CaManagerHomePageUI.IDENTITY_TYPE,"Hộ chiếu");
    }

    public void clickIndividualsInOrganization() {
        waitForElementVisible(CaManagerHomePageUI.RADIO_INDIVIDUALS_IN_ORGANIZATION);
        checkToDefaultCheckBoxOrRadio(CaManagerHomePageUI.RADIO_INDIVIDUALS_IN_ORGANIZATION);
    }

    public void clickOrganization() {
        waitForElementVisible(CaManagerHomePageUI.RADIO_ORGANIZATION);
        checkToDefaultCheckBoxOrRadio(CaManagerHomePageUI.RADIO_ORGANIZATION);
    }

    public void inputOrganizationUnit(String organizationUnit) {
        waitForElementVisible(CaManagerHomePageUI.ORGANIZATION_UNIT);
        sendKeyToElement(CaManagerHomePageUI.ORGANIZATION_UNIT,organizationUnit);
    }

    public void clickTaxCodeTypeMST() {
        waitForElementVisible(CaManagerHomePageUI.TAX_CODE_TYPE);
        selecItemInDefaultDropdown(CaManagerHomePageUI.TAX_CODE_TYPE,"Mã số thuế");
    }

    public void inputTaxCode(String taxCode) {
        waitForElementVisible(CaManagerHomePageUI.TAX_CODE);
        sendKeyToElement(CaManagerHomePageUI.TAX_CODE,taxCode);
    }

    public void inputOrganization(String organization) {
        waitForElementVisible(CaManagerHomePageUI.ORGANIZATION);
        sendKeyToElement(CaManagerHomePageUI.ORGANIZATION,organization);
    }

    public void clickTaxCodeTypeMNS() {
        waitForElementVisible(CaManagerHomePageUI.TAX_CODE_TYPE);
        selecItemInDefaultDropdown(CaManagerHomePageUI.TAX_CODE_TYPE,"Mã ngân sách");
    }

    public void clickIdentityTypeMST() {
        waitForElementVisible(CaManagerHomePageUI.IDENTITY_TYPE);
        selecItemInDefaultDropdown(CaManagerHomePageUI.IDENTITY_TYPE,"Mã số thuế");
    }

    public void clickIdentityTypeMNS() {
        waitForElementVisible(CaManagerHomePageUI.IDENTITY_TYPE);
        selecItemInDefaultDropdown(CaManagerHomePageUI.IDENTITY_TYPE,"Mã ngân sách");
    }

    public void uploadCert(String cert) {
        waitForElementVisible(CaManagerHomePageUI.CERT);
        uploadImage(CaManagerHomePageUI.CERT,cert);
    }

    public void inputCaName(String caName) {
        waitForElementVisible(CaManagerHomePageUI.CA_NAME);
        sendKeyToElement(CaManagerHomePageUI.CA_NAME,caName);
    }
}