package pageObjects.groupusermanager;

import commons.BasePage;
import pageUIs.groupusermanager.GroupUserManagerHomePageUI;
import pageUIs.usermanager.UserManagerHomePageUI;


public class CreateGroupUserPageObject extends BasePage {

    public boolean isGroupUserManagerDisplayed() {
        waitForElementVisible(GroupUserManagerHomePageUI.CREATE_GROUP_USER_TEXT);
        return isElementDisplay(GroupUserManagerHomePageUI.CREATE_GROUP_USER_TEXT);
    }

    public void inputGroupUserCode(String groupUserCode) {
        waitForElementVisible(GroupUserManagerHomePageUI.GROUP_USER_CODE);
        sendKeyToElement(GroupUserManagerHomePageUI.GROUP_USER_CODE,groupUserCode);
    }

    public void inputGroupUserName(String groupUserName) {
        waitForElementVisible(GroupUserManagerHomePageUI.GROUP_USER_NAME);
        sendKeyToElement(GroupUserManagerHomePageUI.GROUP_USER_NAME,groupUserName);
    }

    public void inputDescription(String description) {
        waitForElementVisible(GroupUserManagerHomePageUI.DESCRIPTION);
        sendKeyToElement(GroupUserManagerHomePageUI.DESCRIPTION,description);
    }

    public void clickNavigationList() {
        waitForElementVisible(GroupUserManagerHomePageUI.CHECK_NAVIGATION_LIST);
        checkToDefaultCheckBoxOrRadio(GroupUserManagerHomePageUI.CHECK_NAVIGATION_LIST);
    }

    public void clickPermisstionsList() {
        waitForElementVisible(GroupUserManagerHomePageUI.CHECK_PERMISSTIONS_LIST);
        checkToDefaultCheckBoxOrRadio(GroupUserManagerHomePageUI.CHECK_PERMISSTIONS_LIST);
    }
    public boolean isSubmitCreateButtonEnable() {
        waitForElementVisible(GroupUserManagerHomePageUI.BUTTON_SUBMIT);
        return isElementEnable(GroupUserManagerHomePageUI.BUTTON_SUBMIT);
    }

    public void clickSubmitButton() {
        waitForElementVisible(GroupUserManagerHomePageUI.BUTTON_SUBMIT);
        clickToElement(GroupUserManagerHomePageUI.BUTTON_SUBMIT);
    }
}