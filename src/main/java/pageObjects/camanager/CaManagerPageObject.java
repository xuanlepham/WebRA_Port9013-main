package pageObjects.camanager;

import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.camanager.CaManagerHomePageUI;
import pageUIs.usermanager.UserManagerHomePageUI;

public class CaManagerPageObject extends BasePage {

    public boolean isUserManagerDisplayed() {
        waitForElementVisible(AdminHomePageUI.USER_MANAGER_TEXT);
        return isElementDisplay(AdminHomePageUI.USER_MANAGER_TEXT);
    }

    public CreateCaPageObject clickCreateUserButton() {
        waitForElementClickable(UserManagerHomePageUI.CREATE_USER_BUTTON);
        clickToElement(UserManagerHomePageUI.CREATE_USER_BUTTON);
        return new CreateCaPageObject();
    }

    public boolean isCaManagerDisplayed() {
        waitForElementVisible(AdminHomePageUI.CA_MANAGER_TEXT);
        return isElementDisplay(AdminHomePageUI.CA_MANAGER_TEXT);
    }

    public CreateCaPageObject clickCreateCAButton() {
        waitForElementClickable(CaManagerHomePageUI.CREATE_KEY_BUTTON);
        clickToElement(CaManagerHomePageUI.CREATE_KEY_BUTTON);
        return new CreateCaPageObject();
    }
}