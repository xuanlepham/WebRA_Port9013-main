package pageObjects.organizationalstructure;

import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.organizationstructure.OrganizationHomePageUI;

public class OrganizationalStructurePageObject extends BasePage {
    public boolean isOrganizationalDisplayed() {
        waitForElementVisible(AdminHomePageUI.ORGANIZATIONAL_STRUCTURE_TEXT);
        return isElementDisplay(AdminHomePageUI.ORGANIZATIONAL_STRUCTURE_TEXT);
    }

    public CreateOrganizationalPageObject clickCreateOrganizationalButton() {
        waitForElementClickable(OrganizationHomePageUI.CREATE_ORGANIZATIONAL_STRUCTURE_BUTTON);
        clickToElement(OrganizationHomePageUI.CREATE_ORGANIZATIONAL_STRUCTURE_BUTTON);
        return new CreateOrganizationalPageObject();
    }

    public boolean isCreateOrganizationalStructureDisplayed() {
        waitForElementVisible(OrganizationHomePageUI.CREATE_ORGANIZATIONAL_STRUCTURE_TEXT);
        return isElementDisplay(OrganizationHomePageUI.CREATE_ORGANIZATIONAL_STRUCTURE_TEXT);
    }

    public boolean isMessageCreateSuccessfullyDisplayed() {
        waitForElementVisible(OrganizationHomePageUI.MESSAGE_SUCCESSFULLY);
        return isElementDisplay(OrganizationHomePageUI.MESSAGE_SUCCESSFULLY);
    }
}