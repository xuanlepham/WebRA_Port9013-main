package webraport9013.organizational;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import pageObjects.organizationalstructure.OrganizationalStructurePageObject;

public class Organizational extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;

    private OrganizationalStructurePageObject organizationalStructureHomePage;

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
    public void TC_01_Goto_Organizational_Manager(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go to Organizational Manager");
//        goToHomPage();
        organizationalStructureHomePage = homePage.clickOrganizational();
        assertTrue(organizationalStructureHomePage.isOrganizationalDisplayed());
    }
}
