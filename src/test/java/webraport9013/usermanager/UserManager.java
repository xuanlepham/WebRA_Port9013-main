package webraport9013.usermanager;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.organizationalstructure.OrganizationalStructurePageObject;
import pageObjects.usermanager.UserManagerPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.assertTrue;

public class UserManager extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;

    private OrganizationalStructurePageObject organizationalStructureHomePage;
    private UserManagerPageObject userManagerHomePage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        loginPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
        homePage = loginPage.goToAdminHomePage();
    }

    public void goToHomPage() {
        homePage.openPageUrl(VIB_ADMIN_LOGIN);
    }

    @Test
    public void TC_01_Goto_User_Manager(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go to User Manager");
//        goToHomPage();
        userManagerHomePage = homePage.clickUserManager();
        assertTrue(userManagerHomePage.isUserManagerDisplayed());
    }
}
