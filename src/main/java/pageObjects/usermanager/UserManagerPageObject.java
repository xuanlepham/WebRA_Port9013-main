package pageObjects.usermanager;

import commons.BasePage;
import pageUIs.usermanager.UserManagerHomePageUI;
import pageUIs.admin.AdminHomePageUI;

public class UserManagerPageObject extends BasePage {

    public boolean isUserManagerDisplayed() {
        waitForElementVisible(AdminHomePageUI.USER_MANAGER_TEXT);
        return isElementDisplay(AdminHomePageUI.USER_MANAGER_TEXT);
    }

    public CreateUserPageObject clickCreateUserButton() {
        waitForElementClickable(UserManagerHomePageUI.CREATE_USER_BUTTON);
        clickToElement(UserManagerHomePageUI.CREATE_USER_BUTTON);
        return new CreateUserPageObject();
    }
}