package webraport9013.listdigitalcertificateapprovals;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.listdigitalcertificateapprovals.ListDigitalCertificateApprovalsPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.assertTrue;

public class VibListDigitalCertificateApprovals extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;

    private ListDigitalCertificateApprovalsPageObject listDigitalCertificateApprovalsHomePage;

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
    public void TC_01_Goto_List_Digital_Certificate_Approvals(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go to List Digital Certificate Approvals");
//        goToHomPage();
        listDigitalCertificateApprovalsHomePage = homePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
    }

    @Test
    public void TC_02_List_Digital_Certificate_Approvals(Method method) {
        ExtentTestManager.startTest(method.getName(), "List Digital Certificate Approvals");
//        goToHomPage();
        listDigitalCertificateApprovalsHomePage = homePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
    }
}
