package webraport9013.groupusermanager;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.groupusermanager.CreateGroupUserPageObject;
import pageObjects.groupusermanager.GroupUserManagerPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.BasePage.getRandomString;
import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.assertTrue;

public class CreateGroupUserManager extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    public String groupUserCode, groupUserName, description;

    private GroupUserManagerPageObject groupUserManagerHomePage;
    private CreateGroupUserPageObject createGroupUserHomePage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        loginPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
        homePage = loginPage.goToAdminHomePage();

        groupUserCode = "GRU" + getRandomInt();
        groupUserName = "GRU QTHT" + getRandomInt();
        description = "Mô tả " + getRandomString();
    }

    public void goToHomPage() {
        homePage.openPageUrl(VIB_ADMIN_LOGIN);
    }

    @Test
    public void TC_01_Go_To_Create_Group_User(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go to Create Group User");
//        goToHomPage();
        groupUserManagerHomePage = homePage.clickGroupUserManager();
        assertTrue(groupUserManagerHomePage.isGroupUserManagerDisplayed());
        createGroupUserHomePage = groupUserManagerHomePage.clickCreateGroupUserButton();
        assertTrue(createGroupUserHomePage.isGroupUserManagerDisplayed());
    }
    @Test
    public void TC_02_Create_Group_User(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Group User");
        goToHomPage();
        groupUserManagerHomePage = homePage.clickGroupUserManager();
        assertTrue(groupUserManagerHomePage.isGroupUserManagerDisplayed());
        createGroupUserHomePage = groupUserManagerHomePage.clickCreateGroupUserButton();
        assertTrue(createGroupUserHomePage.isGroupUserManagerDisplayed());
        createGroupUserHomePage.inputGroupUserCode(groupUserCode);
        createGroupUserHomePage.inputGroupUserName(groupUserName);
        createGroupUserHomePage.inputDescription(description);
        createGroupUserHomePage.clickNavigationList();
        createGroupUserHomePage.clickPermisstionsList();
        assertTrue(createGroupUserHomePage.isSubmitCreateButtonEnable());
        createGroupUserHomePage.clickSubmitButton();
    }

}
