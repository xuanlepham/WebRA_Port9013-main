package pageObjects.listdigitalcertificate;

import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.listdigitalcertificate.ListDigitalCertificateHomePageUI;

public class ListDigitalCertificatesPageObject extends BasePage {

    public boolean isListDigitalCertificateDisplayed() {
        waitForElementVisible(AdminHomePageUI.LIST_DIGITAL_CERTIFICATES);
        return isElementDisplay(AdminHomePageUI.LIST_DIGITAL_CERTIFICATES);
    }

    public void inputSearchBar(String fullName) {
        waitForElementVisible(ListDigitalCertificateHomePageUI.SEARCH_BAR);
        sendKeyToElement(ListDigitalCertificateHomePageUI.SEARCH_BAR,fullName);
    }

    public void clickSearchIcon() {
        waitForElementVisible(ListDigitalCertificateHomePageUI.SEARCH_ICON);
        clickToElement(ListDigitalCertificateHomePageUI.SEARCH_ICON);
    }

    public String getTextRefuseStatus() {
        waitForElementVisible(ListDigitalCertificateHomePageUI.REFUSE_STATUS_TEXT);
        return getElementText(ListDigitalCertificateHomePageUI.REFUSE_STATUS_TEXT);
    }

    public String getTextActiveStatus() {
        waitForElementVisible(ListDigitalCertificateHomePageUI.ACTIVE_STATUS_TEXT);
        return getElementText(ListDigitalCertificateHomePageUI.ACTIVE_STATUS_TEXT);
    }
}