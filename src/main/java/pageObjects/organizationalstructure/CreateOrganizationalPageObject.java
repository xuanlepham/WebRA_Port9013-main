package pageObjects.organizationalstructure;

import commons.BasePage;
import pageUIs.organizationstructure.OrganizationHomePageUI;


public class CreateOrganizationalPageObject extends BasePage {

    public void clickParentID() {
        waitForElementVisible(OrganizationHomePageUI.PARENT_ID);
        selectItemInCustomDropdown(OrganizationHomePageUI.PARENT_ID,OrganizationHomePageUI.CHILD_ID);
    }

    public void inputOrganizationCode(String organizationCode) {
        waitForElementVisible(OrganizationHomePageUI.ORGANAZATION_CODE);
        sendKeyToElement(OrganizationHomePageUI.ORGANAZATION_CODE,organizationCode);
    }

    public void inputOrganizationName(String organizationName) {
        waitForElementVisible(OrganizationHomePageUI.ORGANAZATION_NAME);
        sendKeyToElement(OrganizationHomePageUI.ORGANAZATION_NAME,organizationName);
    }

    public void clickSubmitCreateOrganizationStructureButton() {
        waitForElementVisible(OrganizationHomePageUI.SUBMIT_CREATE_ORGANIZATION_STRUCTURE_BUTTON);
        clickToElement(OrganizationHomePageUI.SUBMIT_CREATE_ORGANIZATION_STRUCTURE_BUTTON);
    }

    public void clickOrganizationCode() {
        waitForElementVisible(OrganizationHomePageUI.ORGANAZATION_CODE);
        clickToElement(OrganizationHomePageUI.ORGANAZATION_CODE);
    }

    public void clickOrganizationName() {
        waitForElementVisible(OrganizationHomePageUI.ORGANAZATION_NAME);
        clickToElement(OrganizationHomePageUI.ORGANAZATION_NAME);
    }

    public String getErrorMessageOrganizationCode() {
        waitForElementVisible(OrganizationHomePageUI.ERROR_MESSAGE_ORGANAZATION_CODE);
        return getElementText(OrganizationHomePageUI.ERROR_MESSAGE_ORGANAZATION_CODE);
    }

    public String getErrorMessageOrganizationName() {
        waitForElementVisible(OrganizationHomePageUI.ERROR_MESSAGE_ORGANAZATION_NAME);
        return getElementText(OrganizationHomePageUI.ERROR_MESSAGE_ORGANAZATION_NAME);
    }

    public boolean isSubmitCreateOrganizationStructureButtonEnable() {
        waitForElementVisible(OrganizationHomePageUI.SUBMIT_CREATE_ORGANIZATION_STRUCTURE_BUTTON);
        return isElementEnable(OrganizationHomePageUI.SUBMIT_CREATE_ORGANIZATION_STRUCTURE_BUTTON);
    }

    public void inputTaxCode(String taxCode) {
        waitForElementVisible(OrganizationHomePageUI.TAX_CODE);
        sendKeyToElement(OrganizationHomePageUI.TAX_CODE,taxCode);
    }

    public void inputEmail(String email) {
        waitForElementVisible(OrganizationHomePageUI.EMAIL);
        sendKeyToElement(OrganizationHomePageUI.EMAIL,email);
    }

    public void inputPhoneNumber(String phoneNumber) {
        waitForElementVisible(OrganizationHomePageUI.PHONE_NUMBER);
        sendKeyToElement(OrganizationHomePageUI.PHONE_NUMBER,phoneNumber);
    }

    public void inputAddress(String address) {
        waitForElementVisible(OrganizationHomePageUI.ADDRESS);
        sendKeyToElement(OrganizationHomePageUI.ADDRESS,address);
    }

    public void clickProvince() {
        waitForElementVisible(OrganizationHomePageUI.PARENT_PROVINCE);
        waitForElementVisible(OrganizationHomePageUI.CHILD_PROVINCE);
        selectItemInCustomDropdown(OrganizationHomePageUI.PARENT_PROVINCE,OrganizationHomePageUI.CHILD_PROVINCE);
    }

    public void clickCountry() {
        waitForElementVisible(OrganizationHomePageUI.PARENT_COUNTRY);
        selectItemInCustomDropdown(OrganizationHomePageUI.PARENT_COUNTRY,OrganizationHomePageUI.CHILD_COUNTRY);
    }

    public void inputNameRepresentative(String nameRepresentative) {
        waitForElementVisible(OrganizationHomePageUI.NAME_REPRESENTATIVE);
        sendKeyToElement(OrganizationHomePageUI.NAME_REPRESENTATIVE,nameRepresentative);
    }

    public void inputIdNumberRepresentative(String idNumberRepresentative) {
        waitForElementVisible(OrganizationHomePageUI.ID_NUMBER_REPRESENTATIVE);
        sendKeyToElement(OrganizationHomePageUI.ID_NUMBER_REPRESENTATIVE,idNumberRepresentative);
    }

    public void inputEmailRepresentative(String emailRepresentative) {
        waitForElementVisible(OrganizationHomePageUI.EMAIL_REPRESENTATIVE);
        sendKeyToElement(OrganizationHomePageUI.EMAIL_REPRESENTATIVE,emailRepresentative);
    }

    public void inputPhoneNumberRepresentative(String phoneNumberRepresentative) {
        waitForElementVisible(OrganizationHomePageUI.PHONE_NUMBER_REPRESENTATIVE);
        sendKeyToElement(OrganizationHomePageUI.PHONE_NUMBER_REPRESENTATIVE,phoneNumberRepresentative);
    }

    public void inputPositionRepresentative(String positionRepresentative) {
        waitForElementVisible(OrganizationHomePageUI.POSITION_REPRESENTATIVE);
        sendKeyToElement(OrganizationHomePageUI.POSITION_REPRESENTATIVE,positionRepresentative);
    }

    public void inputAddressRepresentative(String addressRepresentative) {
        waitForElementVisible(OrganizationHomePageUI.ADDRESS_REPRESENTATIVE);
        sendKeyToElement(OrganizationHomePageUI.ADDRESS_REPRESENTATIVE,addressRepresentative);
    }

    public void clickProvinceRepresentative() {
        waitForElementVisible(OrganizationHomePageUI.PARENT_PROVINCE_REPRESENTATIVE);
        scrollToElement(OrganizationHomePageUI.PARENT_PROVINCE_REPRESENTATIVE);
        waitForElementVisible(OrganizationHomePageUI.CHILD_PROVINCE_REPRESENTATIVE);
        selectItemInCustomDropdown(OrganizationHomePageUI.PARENT_PROVINCE_REPRESENTATIVE,OrganizationHomePageUI.CHILD_PROVINCE_REPRESENTATIVE);
    }

    public void clickCountryRepresentative() {
        waitForElementVisible(OrganizationHomePageUI.PARENT_COUNTRY_REPRESENTATIVE);
        selecItemInDefaultDropdown(OrganizationHomePageUI.PARENT_COUNTRY_REPRESENTATIVE," Việt Nam ");
    }
}