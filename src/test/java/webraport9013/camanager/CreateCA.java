package webraport9013.camanager;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.camanager.CreateCaPageObject;
import pageObjects.camanager.CaManagerPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.BasePage.getRandomString;
import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.assertTrue;

public class CreateCA extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    public String caName, cert;

    private CaManagerPageObject caManagerHomePage;
    private CreateCaPageObject createCAHomePage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        loginPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
        homePage = loginPage.goToAdminHomePage();

        caName = "CA " + getRandomString();
        cert = System.getProperty("user.dir") + "\\uploadFiles\\tochuc.cer";
    }

    public void goToHomPage() {
        homePage.openPageUrl(VIB_ADMIN_LOGIN);
    }

    @Test
    public void TC_01_Go_To_Create_Key(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go To Create Key");
//        goToHomPage();
        caManagerHomePage = homePage.clickCaManager();
        assertTrue(caManagerHomePage.isCaManagerDisplayed());
        createCAHomePage = caManagerHomePage.clickCreateCAButton();
        assertTrue(createCAHomePage.isCreateCaDisplayed());
    }
    @Test
    public void TC_02_Create_CA(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create CA");
        goToHomPage();
        caManagerHomePage = homePage.clickCaManager();
        assertTrue(caManagerHomePage.isCaManagerDisplayed());
        createCAHomePage = caManagerHomePage.clickCreateCAButton();
        assertTrue(createCAHomePage.isCreateCaDisplayed());
        createCAHomePage.uploadCert(cert);
        createCAHomePage.inputCaName(caName);
        createCAHomePage.clickSubmitButton();
        assertTrue(createCAHomePage.ismessageCreateSuccessfullyDisplayed());
    }
}
