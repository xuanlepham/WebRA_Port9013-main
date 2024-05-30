package pageObjects.registerdigitalcertificate;

import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.registerdigitalcertificate.RegisterDigitalCertificateHomePageUI;

public class RegisterDigitalCertificatesPageObject extends BasePage {
    public boolean isRegisterDigitalCertificateDisplayed() {
        waitForElementVisible(AdminHomePageUI.REGISTER_DIGITAL_CERTIFICATES);
        return isElementDisplay(AdminHomePageUI.REGISTER_DIGITAL_CERTIFICATES);
    }

    public void clickCA() {
//        waitForElementVisible(RegisterDigitalCertificateHomePageUI.CA);
//        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_CA," TrustCA ");
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_CA, RegisterDigitalCertificateHomePageUI.CHILD_CA);
    }

    public void clickServiceTypeId() {
//        waitForElementVisible(RegisterDigitalCertificateHomePageUI.SERVICE_TYPE);
//        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_TYPE," Gói nội bộ ");
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_TYPE, RegisterDigitalCertificateHomePageUI.CHILD_SERVICE_TYPE);
    }

    public void clickOrganizationCertType() {
//        waitForElementVisible(RegisterDigitalCertificateHomePageUI.CERT_TYPE);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.CERT_TYPE,"Tổ chức");
    }

    public void clickValidity() {
//        waitForElementVisible(RegisterDigitalCertificateHomePageUI.VALIDITY);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.VALIDITY,"1 tháng");
    }

    public void clickHsmMethodId() {
//        waitForElementVisible(RegisterDigitalCertificateHomePageUI.METHOD_ID);
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.METHOD_ID,"HSM");
    }

    public void clickVibAgencyId() {
//        waitForElementVisible(RegisterDigitalCertificateHomePageUI.AGENCY_ID);
//        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID," Ngân hàng thương mại cổ phần Quốc tế Việt Nam ");
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID,RegisterDigitalCertificateHomePageUI.VIB_CHILD_AGENCY_ID);
    }

    public void clickOrganizationServicePackageIdVIBHSM() {
//        waitForElementVisible(RegisterDigitalCertificateHomePageUI.SERVICE_PACKAGE_ID);
//        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID," VIB - TrustCA - Tổ chức - HSM - 1 tháng ");
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID, RegisterDigitalCertificateHomePageUI.CHILD_SERVICE_PACKAGE_ID_VIB_HSM);
    }

    public void clickNextButton() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.NEXT_BUTTON);
        clickToElement(RegisterDigitalCertificateHomePageUI.NEXT_BUTTON);
    }

    public void inputFullName(String fullName) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.FULL_NAME);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.FULL_NAME,fullName);
    }

    public void inputIdentityNumberCCCD(String identityNumber) {
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

    public void uploadFrontImageCCCD(String image) {
        uploadImage(RegisterDigitalCertificateHomePageUI.FRONT_IMAGE,image);
    }

    public void uploadBackImageCCCD(String image) {
        uploadImage(RegisterDigitalCertificateHomePageUI.BACK_IMAGE, image);
    }

    public void uploadFileRegister(String file) {
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

    public void clickIndividualCertType() {
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.CERT_TYPE,"Cá nhân");
    }

    public void clickIndividualServicePackageIdVIBHSM() {
//        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID," VIB - TrustCA - Cá nhân - HSM - 1 tháng ");
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID,RegisterDigitalCertificateHomePageUI.CHILD_INDIVIDUAL_SERVICE_PACKAGE_ID_VIB_HSM);
    }

    public void clickIndividualInOrgCertType() {
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.CERT_TYPE,"Cá nhân trong tổ chức");
    }

    public void clickIndividualInOrgServicePackageIdVIBHSM() {
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID, RegisterDigitalCertificateHomePageUI.CHILD_INDIVIDUAL_IN_ORF_SERVICE_PACKAGE_ID_VIB_HSM);
    }

    public void uploadFrontImageDKKD(String image) {
        uploadImage(RegisterDigitalCertificateHomePageUI.FRONT_IMAGE_DKKD,image);
    }

    public void uploadBackImageDKKD(String image) {
        uploadImage(RegisterDigitalCertificateHomePageUI.BACK_IMAGE_DKKD,image);
    }

    public void inputEmailPackage(String inputEmail) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.EMAIL_PACKAGE);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.EMAIL_PACKAGE,inputEmail);
    }

    public void inputPhonePackage(String inputPhoneNumber) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PHONE_PACKAGE);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.PHONE_PACKAGE,inputPhoneNumber);
    }

    public void inputBirthDay(String birthDay) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.BIRTHDAY);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.BIRTHDAY,birthDay);
    }

    public void clickGender() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PARENT_GENDER_ID);
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_GENDER_ID,RegisterDigitalCertificateHomePageUI.CHILD_GENDER_ID);
    }

    public void clickRsMethodId() {
        selecItemInDefaultDropdown(RegisterDigitalCertificateHomePageUI.METHOD_ID,"Remote Signing");
    }

    public void clickVpbAgencyId() {
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID,RegisterDigitalCertificateHomePageUI.VPB_CHILD_AGENCY_ID);
    }

    public void chooseVIBAgency() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID);
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID,RegisterDigitalCertificateHomePageUI.VIB_CHILD_AGENCY_ID);
    }

    public void inputSupplyPlace(String inputAddress) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.SUPPLY_PLACE);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.SUPPLY_PLACE,inputAddress);
    }

    public void inputSupplyDate(String supplyDate) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.SUPPLY_DATE);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.SUPPLY_DATE,supplyDate);
    }

    public void inputOrganizationName(String organizationName) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.ORGANIZATION_NAME);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.ORGANIZATION_NAME,organizationName);
    }

    public void inputPersition(String presition) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PRESITION);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.PRESITION,presition);
    }

    public void inputIdentityNumberMST(String inputMst) {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.MST);
        sendKeyToElement(RegisterDigitalCertificateHomePageUI.MST,inputMst);
    }

    public void chooseVPBAgency() {
        waitForElementVisible(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID);
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_AGENCY_ID,RegisterDigitalCertificateHomePageUI.VPB_CHILD_AGENCY_ID);
    }

    public void clickIndividualServicePackageIdVPBRS() {
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID,RegisterDigitalCertificateHomePageUI.CHILD_INDIVIDUAL_SERVICE_PACKAGE_ID_VPB_HSM);
    }

    public void clickIndividualInOrgServicePackageIdVPBRS() {
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID, RegisterDigitalCertificateHomePageUI.CHILD_INDIVIDUAL_IN_ORF_SERVICE_PACKAGE_ID_VPB_RS);
    }

    public void clickOrganizationServicePackageIdVPBHSM() {
        selectItemInCustomDropdown(RegisterDigitalCertificateHomePageUI.PARENT_SERVICE_PACKAGE_ID, RegisterDigitalCertificateHomePageUI.CHILD_SERVICE_PACKAGE_ID_VPB_RS);
    }

    public void uploadFrontImageDDPL(String image) {
        uploadImage(RegisterDigitalCertificateHomePageUI.FRONT_IMAGE_DDPL,image);
    }

    public void uploadBackImageDDPL(String image) {
        uploadImage(RegisterDigitalCertificateHomePageUI.BACK_IMAGE_DDPL,image);
    }
}