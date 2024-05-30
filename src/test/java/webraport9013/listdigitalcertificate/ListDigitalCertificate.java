package webraport9013.listdigitalcertificate;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.registerdigitalcertificate.RegisterDigitalCertificatesPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.BasePage.getRandomString;
import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.assertTrue;

public class ListDigitalCertificate extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;

    private RegisterDigitalCertificatesPageObject registerDigitalCertificateHomePage;
    public String fullName, identityNumber, email, phoneNumber, address, image, file;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";

        fullName = "ORG " + getRandomString();
        identityNumber = getRandomInt() + getRandomInt();
        email = "org" + getRandomInt() + "@savis-digital.com";
        phoneNumber = "09899" + getRandomInt();
        address = getRandomString() + " Hà Nội";
        image = System.getProperty("user.dir") + "\\uploadFiles\\ProductImage.jpg";
        file = System.getProperty("user.dir") + "\\uploadFiles\\Undefined.txt";

        loginPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
        homePage = loginPage.goToAdminHomePage();
    }

    public void goToHomPage() {
        homePage.openPageUrl(VIB_ADMIN_LOGIN);
    }

    @Test
    public void TC_01_Goto_Register_Digital_Certificate(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go to Register Digital Certificate");
//        goToHomPage();
        registerDigitalCertificateHomePage = homePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
    }

    @Test
    public void TC_02_Register_Digital_Certificate(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register Digital Certificate");
//        goToHomPage();
        registerDigitalCertificateHomePage = homePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.clickCA();
        registerDigitalCertificateHomePage.clickServiceTypeId();
        registerDigitalCertificateHomePage.clickOrganizationCertType();
        registerDigitalCertificateHomePage.clickValidity();
        registerDigitalCertificateHomePage.clickHsmMethodId();
        registerDigitalCertificateHomePage.clickVibAgencyId();
        registerDigitalCertificateHomePage.clickOrganizationServicePackageIdVIBHSM();
        registerDigitalCertificateHomePage.clickNextButton();
        registerDigitalCertificateHomePage.inputFullName(fullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(identityNumber);
        registerDigitalCertificateHomePage.inputEmail(email);
        registerDigitalCertificateHomePage.inputPhoneNumber(phoneNumber);
        registerDigitalCertificateHomePage.inputAddress(address);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.clickNextButton();
        registerDigitalCertificateHomePage.uploadFrontImageCCCD(image);
        registerDigitalCertificateHomePage.uploadBackImageCCCD(image);
        registerDigitalCertificateHomePage.uploadFileRegister(file);
        registerDigitalCertificateHomePage.clickCreateCSRButton();
        assertTrue(registerDigitalCertificateHomePage.isCreateCSRSuccessDisplayed());
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
    }
}
