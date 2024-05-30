package pageObjects.listdigitalcertificateapprovals;

import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.listdigitalcertificateapprovals.ListDigitalCertificateApprovalsHomePageUI;
import pageUIs.registerdigitalcertificate.RegisterDigitalCertificateHomePageUI;

public class ListDigitalCertificateApprovalsPageObject extends BasePage {
    public boolean isRegisterDigitalCertificateDisplayed() {
        waitForElementVisible(AdminHomePageUI.REGISTER_DIGITAL_CERTIFICATES);
        return isElementDisplay(AdminHomePageUI.REGISTER_DIGITAL_CERTIFICATES);
    }

    public void clickCA() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PARENT_CA);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_CA," TrustCA ");
    }

    public void clickServiceTypeId() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_TYPE);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_TYPE," Gói nội bộ ");
    }

    public void clickOrganizationCertType() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.CERT_TYPE);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.CERT_TYPE,"Tổ chức");
    }

    public void clickValidity() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.VALIDITY);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.VALIDITY,"1 tháng");
    }

    public void clickMethodId() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.METHOD_ID);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.METHOD_ID,"HSM");
    }

    public void clickAgencyId() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID," Ngân hàng thương mại cổ phần Quốc tế Việt Nam ");
    }

    public void clickServicePackageId() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID," VIB - TrustCA - Tổ chức - HSM - 1 tháng ");
    }

    public void clickNextButton() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.NEXT_BUTTON);
        clickToElement(RegisterDigitalCertificateHomePageUI.NEXT_BUTTON);
    }

    public void inputFullName(String fullName) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.FULL_NAME);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.FULL_NAME,fullName);
    }

    public void inputIdentityNumber(String identityNumber) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.IDENTITY_NUMBER);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.IDENTITY_NUMBER,identityNumber);
    }

    public void inputEmail(String email) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.EMAIL);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.EMAIL,email);
    }

    public void inputPhoneNumber(String phoneNumber) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PHONE_NUMBER);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.PHONE_NUMBER,phoneNumber);
    }

    public void inputAddress(String address) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.ADDRESS);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.ADDRESS,address);
    }

    public void clickProviceId() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PROVICE_ID);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PROVICE_ID,"Hà Nội");
    }

    public void uploadFrontImage(String image) {
        sleepInSecond(1);
        uploadImage(RegisterDigitalCertificateHomePageUI.FRONT_IMAGE,image);
    }

    public void uploadBackImage(String image) {
        sleepInSecond(1);
        uploadImage(RegisterDigitalCertificateHomePageUI.BACK_IMAGE, image);
    }

    public void uploadFileRegister(String file) {
        sleepInSecond(1);
        uploadImage(RegisterDigitalCertificateHomePageUI.FILE_REGISTER, file);
    }

    public void clickCreateCSRButton() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.CREATE_CSR_BUTTON);
        clickToElement(RegisterDigitalCertificateHomePageUI.CREATE_CSR_BUTTON);
    }

    public void clickGridCheck() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.GRID_CHECK);
        clickToElement(RegisterDigitalCertificateHomePageUI.GRID_CHECK);
    }

    public void clickSubmitRegistrationButton() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.SUBMIT_REGISTRATION_BUTTON);
        clickToElement(RegisterDigitalCertificateHomePageUI.SUBMIT_REGISTRATION_BUTTON);
    }

    public boolean isCreateCSRSuccessDisplayed() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.MESSAGE_CREATE_CSR_SUCCESS);
        return isElementDisplay(RegisterDigitalCertificateHomePageUI.MESSAGE_CREATE_CSR_SUCCESS);
    }

    public boolean isListDigitalCertificateApprovalsDisplayed() {
        waitForElementVisible(AdminHomePageUI.LIST_DIGITAL_CERTIFICATES_APPROVALS_TEXT);
        return isElementDisplay(AdminHomePageUI.LIST_DIGITAL_CERTIFICATES_APPROVALS_TEXT);
    }

    public void clickApprovals() {
        waitForElementVisible(ListDigitalCertificateApprovalsHomePageUI.APPROVALS_ICON);
        clickToElement(ListDigitalCertificateApprovalsHomePageUI.APPROVALS_ICON);
    }

    public boolean isDigitalCertificateApprovalsPopupDisplayed() {
        waitForElementVisible(ListDigitalCertificateApprovalsHomePageUI.DIGITAL_CERTIFICATES_APPROVALS_POPUP_TEXT);
        return isElementDisplay(ListDigitalCertificateApprovalsHomePageUI.DIGITAL_CERTIFICATES_APPROVALS_POPUP_TEXT);
    }

    public void clickApprovalsPopup() {
        waitForElementVisible(ListDigitalCertificateApprovalsHomePageUI.APPROVALS_POPUP_BUTTON);
        clickToElement(ListDigitalCertificateApprovalsHomePageUI.APPROVALS_POPUP_BUTTON);
    }

    public boolean isApprovalsSuccessDisplayed() {
        waitForElementVisible(ListDigitalCertificateApprovalsHomePageUI.MESSAGE_APPROVALS_SUCCESS);
        return isElementDisplay(ListDigitalCertificateApprovalsHomePageUI.MESSAGE_APPROVALS_SUCCESS);
    }

    public void clickRefuse() {
        waitForElementVisible(ListDigitalCertificateApprovalsHomePageUI.REFUSE_ICON);
        clickToElement(ListDigitalCertificateApprovalsHomePageUI.REFUSE_ICON);
    }

    public boolean isDigitalCertificateRefusePopupDisplayed() {
        waitForElementVisible(ListDigitalCertificateApprovalsHomePageUI.DIGITAL_CERTIFICATES_REFUSE_POPUP_TEXT);
        return isElementDisplay(ListDigitalCertificateApprovalsHomePageUI.DIGITAL_CERTIFICATES_REFUSE_POPUP_TEXT);
    }

    public boolean isRefuseSuccessDisplayed() {
        waitForElementVisible(ListDigitalCertificateApprovalsHomePageUI.MESSAGE_REFUSE_SUCCESS);
        return isElementDisplay(ListDigitalCertificateApprovalsHomePageUI.MESSAGE_REFUSE_SUCCESS);
    }
}