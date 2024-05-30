package webraport9013.camanager;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.camanager.CaManagerPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.assertTrue;

public class CaManager extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;

    private CaManagerPageObject caManagerHomePage;

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
    public void TC_01_Goto_CA_Manager(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go to CA Manager");
//        goToHomPage();
        caManagerHomePage = homePage.clickCaManager();
        assertTrue(caManagerHomePage.isCaManagerDisplayed());
    }
}
