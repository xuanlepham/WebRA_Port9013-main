package pageObjects.groupusermanager;

import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.groupusermanager.GroupUserManagerHomePageUI;
import pageUIs.usermanager.UserManagerHomePageUI;

public class GroupUserManagerPageObject extends BasePage {

    public boolean isUserManagerDisplayed() {
        waitForElementVisible(AdminHomePageUI.USER_MANAGER_TEXT);
        return isElementDisplay(AdminHomePageUI.USER_MANAGER_TEXT);
    }

    public CreateGroupUserPageObject clickCreateUserButton() {
        waitForElementClickable(UserManagerHomePageUI.CREATE_USER_BUTTON);
        clickToElement(UserManagerHomePageUI.CREATE_USER_BUTTON);
        return new CreateGroupUserPageObject();
    }

    public boolean isGroupUserManagerDisplayed() {
        waitForElementVisible(AdminHomePageUI.GROUP_USER_MANAGER_TEXT);
        return isElementDisplay(AdminHomePageUI.GROUP_USER_MANAGER_TEXT);
    }

    public CreateGroupUserPageObject clickCreateGroupUserButton() {
        waitForElementClickable(GroupUserManagerHomePageUI.CREATE_GROUP_USER_BUTTON);
        clickToElement(GroupUserManagerHomePageUI.CREATE_GROUP_USER_BUTTON);
        return new CreateGroupUserPageObject();
    }
}