package webraport9013.autoflow;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.listdigitalcertificate.ListDigitalCertificatesPageObject;
import pageObjects.listdigitalcertificateapprovals.ListDigitalCertificateApprovalsPageObject;
import pageObjects.registerdigitalcertificate.RegisterDigitalCertificatesPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.*;
import static commons.GlobalConstants.SAVIS_ADMIN_LOGIN;
import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class RegisterDigitalCertificateFlow extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginVibPage;
    private AdminLoginPageObject loginSavisPage;
    private AdminHomePageObject VibHomePage;
    private AdminHomePageObject SavisHomePage;
    private RegisterDigitalCertificatesPageObject registerDigitalCertificateHomePage;
    private ListDigitalCertificateApprovalsPageObject listDigitalCertificateApprovalsHomePage;
    private ListDigitalCertificatesPageObject listDigitalCertificateHomePage;
    public String hoangName, fullName, mst, cccd, email, phoneNumber, address, image, file, inputFullName, inputCccd, inputEmail, inputPhoneNumber, inputAddress, inputMst, birthDay;
    public String supplyDate, organizationName, presition;
    public int count;
    Actions action;
//    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
//        this.driver = driver;
//        createDriver(browserName,"https://webra-vib.savis.vn/navigation");
        browserName = "chrome";
        hoangName = "MT ";
        fullName = "ORG " + getRandomString() + " ";
        mst = getRandomInt() + getRandomInt();
        cccd = "00" + getRandomInt() + getRandomInt();
        email = "org" + getRandomInt() + "@savis-digital.com";
        phoneNumber = "09899" + getRandomInt();
        address = getRandomString() + " Hà Nội";
        image = System.getProperty("user.dir") + "\\uploadFiles\\ProductImage.png";
        file = System.getProperty("user.dir") + "\\uploadFiles\\Undefined.txt";
        birthDay = "19/10/1999";
        supplyDate = "01/01/2001";
        organizationName = "Savis Group";
        presition = "Giám đốc";
        count = 1;
//        loginVibPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
//        VibHomePage = loginVibPage.goToAdminHomePage();
//        VibHomePage.zoomPage(driver.DriverManager.getDriver(),0.8);
//
//        // Sử dụng JavaScript để mở tab mới
//        ((JavascriptExecutor) driver.DriverManager.getDriver()).executeScript("window.open();");
//        Set<String> allHandles = driver.DriverManager.getDriver().getWindowHandles();
//        List<String> handlesList = new ArrayList<>(allHandles);
//        // Switch to the second tab (index 1 in the list)
//        driver.DriverManager.getDriver().switchTo().window(handlesList.get(1));

        loginSavisPage = new AdminLoginPageObject(SAVIS_ADMIN_LOGIN);
        SavisHomePage = loginSavisPage.goToAdminHomePage();
        SavisHomePage.zoomPage(driver.DriverManager.getDriver(),0.8);
    }

    public void goToVibHomePage() { VibHomePage.openPageUrl(VIB_ADMIN_LOGIN);
    }
    public void goToSavisHomePage() { SavisHomePage.openPageUrl(SAVIS_ADMIN_LOGIN);
    }

    // Savis tạo CTS tổ chức HSM
    @Test(invocationCount = 1)
    public void TC_00_Savis_Register_Digital_Certificate_Flow_ORG(Method method) {
        ExtentTestManager.startTest(method.getName(), "Savis Register Digital Certificate ORG With HSM");
        inputFullName = hoangName + "ORG HSM " + Integer.toString(count++);
        inputMst = getRandomInt() + getRandomInt();
        inputCccd = "00" + getRandomInt() + getRandomInt();
        inputEmail = "org" + getRandomInt() + "@savis-digital.com";
        inputPhoneNumber = "09899" + getRandomInt();
        inputAddress = getRandomString() + " Hà Nội";
//        SavisHomePage.switchWindowsByIndex(1);
        goToSavisHomePage();
        registerDigitalCertificateHomePage = SavisHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.chooseVIBAgency();
        registerDigitalCertificateHomePage.clickOrganizationServicePackageIdVIBHSM();
        registerDigitalCertificateHomePage.inputEmailPackage(inputEmail);
        registerDigitalCertificateHomePage.inputPhonePackage(inputPhoneNumber);
        registerDigitalCertificateHomePage.inputFullName(inputFullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(inputCccd);
        registerDigitalCertificateHomePage.inputSupplyPlace(inputAddress);
        registerDigitalCertificateHomePage.inputSupplyDate(supplyDate);
        registerDigitalCertificateHomePage.inputOrganizationName(organizationName);
        registerDigitalCertificateHomePage.inputEmail(inputEmail);
        registerDigitalCertificateHomePage.inputPhoneNumber(inputPhoneNumber);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.inputAddress(inputAddress);
        registerDigitalCertificateHomePage.uploadFrontImageDKKD(image);
        registerDigitalCertificateHomePage.uploadBackImageDKKD(image);
        registerDigitalCertificateHomePage.uploadFrontImageDDPL(image);
        registerDigitalCertificateHomePage.uploadBackImageDDPL(image);
        registerDigitalCertificateHomePage.uploadFileRegister(image);
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
        goToSavisHomePage();
        listDigitalCertificateApprovalsHomePage = SavisHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
    }

    // Savis tạo CTS cá nhân trong tổ chức HSM
    @Test(invocationCount = 1)
    public void TC_01_Savis_Register_Digital_Certificate_Flow_Individual_In_Org(Method method) {
        ExtentTestManager.startTest(method.getName(), "Savis Register Digital Certificate Individual In Org With HSM");
        inputFullName = hoangName + "MEM HSM " +  Integer.toString(count++);
        inputMst = getRandomInt() + getRandomInt();
        inputCccd = "00" + getRandomInt() + getRandomInt();
        inputEmail = "org" + getRandomInt() + "@savis-digital.com";
        inputPhoneNumber = "09899" + getRandomInt();
        inputAddress = getRandomString() + " Hà Nội";

        goToSavisHomePage();
        registerDigitalCertificateHomePage = SavisHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.chooseVIBAgency();
        registerDigitalCertificateHomePage.clickIndividualInOrgServicePackageIdVIBHSM();
        registerDigitalCertificateHomePage.inputEmailPackage(inputEmail);
        registerDigitalCertificateHomePage.inputPhonePackage(inputPhoneNumber);
        registerDigitalCertificateHomePage.inputFullName(inputFullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(inputCccd);
        registerDigitalCertificateHomePage.inputIdentityNumberMST(inputMst);
        registerDigitalCertificateHomePage.clickGender();
        registerDigitalCertificateHomePage.inputBirthDay(birthDay);
        registerDigitalCertificateHomePage.inputOrganizationName(organizationName);
        registerDigitalCertificateHomePage.inputEmail(inputEmail);
        registerDigitalCertificateHomePage.inputPhoneNumber(inputPhoneNumber);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.inputPersition(presition);
        registerDigitalCertificateHomePage.inputAddress(inputAddress);;
        registerDigitalCertificateHomePage.uploadFrontImageCCCD(image);
        registerDigitalCertificateHomePage.uploadBackImageCCCD(image);
        registerDigitalCertificateHomePage.uploadFrontImageDKKD(image);
        registerDigitalCertificateHomePage.uploadBackImageDKKD(image);
        registerDigitalCertificateHomePage.uploadFrontImageDDPL(image);
        registerDigitalCertificateHomePage.uploadBackImageDDPL(image);
        registerDigitalCertificateHomePage.uploadFileRegister(image);
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
//        goToSavisHomePage();
//        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());

    }

    // Savis tạo CTS cá nhân HSM
    @Test(invocationCount = 1)
    public void TC_02_Savis_Register_Digital_Certificate_Flow_Individual(Method method) {
        ExtentTestManager.startTest(method.getName(), "Savis Register Digital Certificate Individual With HSM");
        inputFullName = hoangName + "PER HSM " +  Integer.toString(count++);
        inputMst = getRandomInt() + getRandomInt();
        inputCccd = "00" + getRandomInt() + getRandomInt();
        inputEmail = "org" + getRandomInt() + "@savis-digital.com";
        inputPhoneNumber = "09899" + getRandomInt();
        inputAddress = getRandomString() + " Hà Nội";
        goToSavisHomePage();
        registerDigitalCertificateHomePage = SavisHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.chooseVIBAgency();
        registerDigitalCertificateHomePage.clickIndividualServicePackageIdVIBHSM();
        registerDigitalCertificateHomePage.inputEmailPackage(inputEmail);
        registerDigitalCertificateHomePage.inputPhonePackage(inputPhoneNumber);
        registerDigitalCertificateHomePage.inputFullName(inputFullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(inputCccd);
        registerDigitalCertificateHomePage.clickGender();
        registerDigitalCertificateHomePage.inputBirthDay(birthDay);
        registerDigitalCertificateHomePage.inputEmail(inputEmail);
        registerDigitalCertificateHomePage.inputPhoneNumber(inputPhoneNumber);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.inputAddress(inputAddress);;
        registerDigitalCertificateHomePage.uploadFrontImageCCCD(image);
        registerDigitalCertificateHomePage.uploadBackImageCCCD(image);
        registerDigitalCertificateHomePage.uploadFileRegister(image);
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
//        goToSavisHomePage();
//        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
    }

    // Savis tạo CTS cá nhân RS
    @Test(invocationCount = 1)
    public void TC_03_Savis_Register_Digital_Certificate_Flow_Individual(Method method) {
        ExtentTestManager.startTest(method.getName(), "Savis Register Digital Certificate Individual With RS");
        inputFullName = hoangName + "PER RS " +  Integer.toString(count++);
        inputMst = getRandomInt() + getRandomInt();
        inputCccd = "00" + getRandomInt() + getRandomInt();
        inputEmail = "org" + getRandomInt() + "@savis-digital.com";
        inputPhoneNumber = "09899" + getRandomInt();
        inputAddress = getRandomString() + " Hà Nội";
        goToSavisHomePage();
        registerDigitalCertificateHomePage = SavisHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.chooseVPBAgency();
        registerDigitalCertificateHomePage.clickIndividualServicePackageIdVPBRS();
        registerDigitalCertificateHomePage.inputEmailPackage(inputEmail);
        registerDigitalCertificateHomePage.inputPhonePackage(inputPhoneNumber);
        registerDigitalCertificateHomePage.inputFullName(inputFullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(inputCccd);
        registerDigitalCertificateHomePage.clickGender();
        registerDigitalCertificateHomePage.inputBirthDay(birthDay);
        registerDigitalCertificateHomePage.inputEmail(inputEmail);
        registerDigitalCertificateHomePage.inputPhoneNumber(inputPhoneNumber);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.inputAddress(inputAddress);
        ;
        registerDigitalCertificateHomePage.uploadFrontImageCCCD(image);
        registerDigitalCertificateHomePage.uploadBackImageCCCD(image);
        registerDigitalCertificateHomePage.uploadFileRegister(image);
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
//        goToSavisHomePage();
//        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
    }

    // Savis tạo CTS cá nhân trong tổ chức RS
    @Test(invocationCount = 1)
    public void TC_04_Savis_Register_Digital_Certificate_Flow_Individual_In_Org(Method method) {
        ExtentTestManager.startTest(method.getName(), "Savis Register Digital Certificate Individual In Org With RS");
        inputFullName = hoangName + "MEM RS " + Integer.toString(count++);
        inputMst = getRandomInt() + getRandomInt();
        inputCccd = "00" + getRandomInt() + getRandomInt();
        inputEmail = "org" + getRandomInt() + "@savis-digital.com";
        inputPhoneNumber = "09899" + getRandomInt();
        inputAddress = getRandomString() + " Hà Nội";

        goToSavisHomePage();
        registerDigitalCertificateHomePage = SavisHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.chooseVPBAgency();
        registerDigitalCertificateHomePage.clickIndividualInOrgServicePackageIdVPBRS();
        registerDigitalCertificateHomePage.inputEmailPackage(inputEmail);
        registerDigitalCertificateHomePage.inputPhonePackage(inputPhoneNumber);
        registerDigitalCertificateHomePage.inputFullName(inputFullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(inputCccd);
        registerDigitalCertificateHomePage.inputIdentityNumberMST(inputMst);
        registerDigitalCertificateHomePage.clickGender();
        registerDigitalCertificateHomePage.inputBirthDay(birthDay);
        registerDigitalCertificateHomePage.inputOrganizationName(organizationName);
        registerDigitalCertificateHomePage.inputEmail(inputEmail);
        registerDigitalCertificateHomePage.inputPhoneNumber(inputPhoneNumber);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.inputPersition(presition);
        registerDigitalCertificateHomePage.inputAddress(inputAddress);;
        registerDigitalCertificateHomePage.uploadFrontImageCCCD(image);
        registerDigitalCertificateHomePage.uploadBackImageCCCD(image);
        registerDigitalCertificateHomePage.uploadFrontImageDKKD(image);
        registerDigitalCertificateHomePage.uploadBackImageDKKD(image);
        registerDigitalCertificateHomePage.uploadFileRegister(image);
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
//        goToSavisHomePage();
//        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());

    }

    // Savis tạo CTS tổ chức RS
    @Test(invocationCount = 1)
    public void TC_05_Savis_Register_Digital_Certificate_Flow_ORG(Method method) {
        ExtentTestManager.startTest(method.getName(), "Savis Register Digital Certificate ORG With RS");
        inputFullName = hoangName + "ORG RS " + Integer.toString(count++);
        inputMst = getRandomInt() + getRandomInt();
        inputCccd = "00" + getRandomInt() + getRandomInt();
        inputEmail = "org" + getRandomInt() + "@savis-digital.com";
        inputPhoneNumber = "09899" + getRandomInt();
        inputAddress = getRandomString() + " Hà Nội";
        goToSavisHomePage();
        registerDigitalCertificateHomePage = SavisHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.chooseVPBAgency();
        registerDigitalCertificateHomePage.clickOrganizationServicePackageIdVPBHSM();
        registerDigitalCertificateHomePage.inputEmailPackage(inputEmail);
        registerDigitalCertificateHomePage.inputPhonePackage(inputPhoneNumber);
        registerDigitalCertificateHomePage.inputFullName(inputFullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(inputMst);
        registerDigitalCertificateHomePage.inputSupplyPlace(inputAddress);
        registerDigitalCertificateHomePage.inputSupplyDate(supplyDate);
        registerDigitalCertificateHomePage.inputOrganizationName(organizationName);
        registerDigitalCertificateHomePage.inputEmail(inputEmail);
        registerDigitalCertificateHomePage.inputPhoneNumber(inputPhoneNumber);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.inputAddress(inputAddress);
        registerDigitalCertificateHomePage.uploadFrontImageCCCD(image);
        registerDigitalCertificateHomePage.uploadBackImageCCCD(image);
        registerDigitalCertificateHomePage.uploadFileRegister(image);
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
//        goToSavisHomePage();
//        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovals();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
//        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
//        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
    }

    // VIB tạo CTS tổ chức HSM
    @Test(invocationCount = 1)
    public void TC_06_Vib_Register_Digital_Certificate_Flow_ORG(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register Digital Certificate ORG");
        inputFullName = hoangName + Integer.toString(count++);
        inputMst = getRandomInt() + getRandomInt();
        inputCccd = "00" + getRandomInt() + getRandomInt();
        inputEmail = "org" + getRandomInt() + "@savis-digital.com";
        inputPhoneNumber = "09899" + getRandomInt();
        inputAddress = getRandomString() + " Hà Nội";
        VibHomePage.switchWindowsByIndex(0);
        goToVibHomePage();
        registerDigitalCertificateHomePage = VibHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.clickCA();
        registerDigitalCertificateHomePage.clickServiceTypeId();
        registerDigitalCertificateHomePage.clickOrganizationCertType();
        registerDigitalCertificateHomePage.clickValidity();
        registerDigitalCertificateHomePage.clickHsmMethodId();
        registerDigitalCertificateHomePage.clickVibAgencyId();
        registerDigitalCertificateHomePage.clickOrganizationServicePackageIdVIBHSM();
        registerDigitalCertificateHomePage.clickNextButton();
        registerDigitalCertificateHomePage.inputFullName(inputFullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(inputMst);
        registerDigitalCertificateHomePage.inputEmail(inputEmail);
        registerDigitalCertificateHomePage.inputPhoneNumber(inputPhoneNumber);
        registerDigitalCertificateHomePage.inputAddress(inputAddress);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.clickNextButton();
        registerDigitalCertificateHomePage.uploadFrontImageCCCD(image);
        registerDigitalCertificateHomePage.uploadBackImageCCCD(image);
        registerDigitalCertificateHomePage.uploadFileRegister(file);
        registerDigitalCertificateHomePage.clickCreateCSRButton();
        assertTrue(registerDigitalCertificateHomePage.isCreateCSRSuccessDisplayed());
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
        goToVibHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
        SavisHomePage.switchWindowsByIndex(1);
        goToSavisHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
        VibHomePage.switchWindowsByIndex(0);
        goToVibHomePage();
        listDigitalCertificateHomePage = VibHomePage.clickListDigitalCertificate();
        assertTrue(listDigitalCertificateHomePage.isListDigitalCertificateDisplayed());
        listDigitalCertificateHomePage.inputSearchBar(inputFullName);
        listDigitalCertificateHomePage.clickSearchIcon();
        assertEquals(listDigitalCertificateHomePage.getTextActiveStatus(), "Hoạt động");
    }

    // VIB tạo CTS cá nhân HSM
    @Test
    public void TC_07_Register_Digital_Certificate_Flow_Individual(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register Digital Certificate Individual");
        goToVibHomePage();
        registerDigitalCertificateHomePage = VibHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.clickCA();
        registerDigitalCertificateHomePage.clickServiceTypeId();
        registerDigitalCertificateHomePage.clickIndividualCertType();
        registerDigitalCertificateHomePage.clickValidity();
        registerDigitalCertificateHomePage.clickHsmMethodId();
        registerDigitalCertificateHomePage.clickVibAgencyId();
        registerDigitalCertificateHomePage.clickIndividualServicePackageIdVIBHSM();
        registerDigitalCertificateHomePage.clickNextButton();
        registerDigitalCertificateHomePage.inputFullName(fullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(cccd);
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
        goToVibHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
        goToSavisHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
        goToVibHomePage();
        listDigitalCertificateHomePage = VibHomePage.clickListDigitalCertificate();
        assertTrue(listDigitalCertificateHomePage.isListDigitalCertificateDisplayed());
        listDigitalCertificateHomePage.inputSearchBar(fullName);
        listDigitalCertificateHomePage.clickSearchIcon();
        assertEquals(listDigitalCertificateHomePage.getTextActiveStatus(), "Hoạt động");
    }

    // VIB tạo CTS cá nhân trong tổ chức HSM
    @Test()
    public void TC_08_Register_Digital_Certificate_Flow_Individual_In_ORG(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register Digital Certificate Individual In ORG");
        VibHomePage.switchWindowsByIndex(0);
        goToVibHomePage();
        registerDigitalCertificateHomePage = VibHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.clickCA();
        registerDigitalCertificateHomePage.clickServiceTypeId();
        registerDigitalCertificateHomePage.clickIndividualInOrgCertType();
        registerDigitalCertificateHomePage.clickValidity();
        registerDigitalCertificateHomePage.clickHsmMethodId();
        registerDigitalCertificateHomePage.clickVibAgencyId();
        registerDigitalCertificateHomePage.clickIndividualInOrgServicePackageIdVIBHSM();
        registerDigitalCertificateHomePage.clickNextButton();
        registerDigitalCertificateHomePage.inputFullName(fullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(cccd);
        registerDigitalCertificateHomePage.inputEmail(email);
        registerDigitalCertificateHomePage.inputPhoneNumber(phoneNumber);
        registerDigitalCertificateHomePage.inputAddress(address);
        registerDigitalCertificateHomePage.clickProviceId();
        registerDigitalCertificateHomePage.clickNextButton();
        registerDigitalCertificateHomePage.uploadFrontImageCCCD(image);
        registerDigitalCertificateHomePage.uploadBackImageCCCD(image);
        registerDigitalCertificateHomePage.uploadFrontImageDKKD(image);
        registerDigitalCertificateHomePage.uploadBackImageDKKD(image);
        registerDigitalCertificateHomePage.uploadFileRegister(file);
        registerDigitalCertificateHomePage.clickCreateCSRButton();
        assertTrue(registerDigitalCertificateHomePage.isCreateCSRSuccessDisplayed());
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
        goToVibHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
        SavisHomePage.switchWindowsByIndex(1);
        goToSavisHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
        VibHomePage.switchWindowsByIndex(0);
        goToVibHomePage();
        listDigitalCertificateHomePage = VibHomePage.clickListDigitalCertificate();
        assertTrue(listDigitalCertificateHomePage.isListDigitalCertificateDisplayed());
        listDigitalCertificateHomePage.inputSearchBar(fullName);
        listDigitalCertificateHomePage.clickSearchIcon();
        assertEquals(listDigitalCertificateHomePage.getTextActiveStatus(), "Hoạt động");
    }

    // VIB tạo CTS tổ chức HSM + Từ chối phê duyệt
    @Test
    public void TC_09_Vib_Refuse_Register_Digital_Certificate_Flow(Method method) {
        ExtentTestManager.startTest(method.getName(), "Vib Refuse Register Digital Certificate ORG");
        VibHomePage.switchWindowsByIndex(0);
        goToVibHomePage();
        registerDigitalCertificateHomePage = VibHomePage.clickRegisterDigitalCertificate();
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
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(mst);
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
        goToVibHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickRefuse();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateRefusePopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isRefuseSuccessDisplayed());
        goToVibHomePage();
        listDigitalCertificateHomePage = VibHomePage.clickListDigitalCertificate();
        assertTrue(listDigitalCertificateHomePage.isListDigitalCertificateDisplayed());
        listDigitalCertificateHomePage.inputSearchBar(fullName);
        listDigitalCertificateHomePage.clickSearchIcon();
        assertEquals(listDigitalCertificateHomePage.getTextRefuseStatus(), "Từ chối phê duyệt");
    }

    // VIB tạo CTS tổ chức HSM + Savis Từ chối phê duyệt
    @Test
    public void TC_10_Savis_Refuse_Register_Digital_Certificate_Flow_ORG(Method method) {
        ExtentTestManager.startTest(method.getName(), "Savis Refuse Register Digital Certificate ORG");
        goToVibHomePage();
        registerDigitalCertificateHomePage = VibHomePage.clickRegisterDigitalCertificate();
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
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(mst);
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
        goToVibHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateApprovalsPopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isApprovalsSuccessDisplayed());
        goToSavisHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickRefuse();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateRefusePopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isRefuseSuccessDisplayed());
        goToVibHomePage();
        listDigitalCertificateHomePage = VibHomePage.clickListDigitalCertificate();
        assertTrue(listDigitalCertificateHomePage.isListDigitalCertificateDisplayed());
        listDigitalCertificateHomePage.inputSearchBar(fullName);
        listDigitalCertificateHomePage.clickSearchIcon();
        assertEquals(listDigitalCertificateHomePage.getTextRefuseStatus(), "Từ chối phê duyệt");
    }

    // Savis tạo CTS tổ chức HSM + Từ chối phê duyệt
    @Test(invocationCount = 1)
    public void TC_11_Savis_Refuse_Digital_Certificate_Flow_ORG(Method method) {
        ExtentTestManager.startTest(method.getName(), "Savis Refuse Register Digital Certificate ORG With HSM");
        inputFullName = hoangName + Integer.toString(count++);
        inputMst = getRandomInt() + getRandomInt();
        inputCccd = "00" + getRandomInt() + getRandomInt();
        inputEmail = "org" + getRandomInt() + "@savis-digital.com";
        inputPhoneNumber = "09899" + getRandomInt();
        inputAddress = getRandomString() + " Hà Nội";
        SavisHomePage.switchWindowsByIndex(1);
        goToSavisHomePage();
        registerDigitalCertificateHomePage = VibHomePage.clickRegisterDigitalCertificate();
        assertTrue(registerDigitalCertificateHomePage.isRegisterDigitalCertificateDisplayed());
        registerDigitalCertificateHomePage.clickCA();
        registerDigitalCertificateHomePage.inputEmailPackage(inputEmail);
//        registerDigitalCertificateHomePage.clickServiceTypeId();
        registerDigitalCertificateHomePage.clickOrganizationCertType();
        registerDigitalCertificateHomePage.inputPhonePackage(inputPhoneNumber);
//        registerDigitalCertificateHomePage.clickValidity();
        registerDigitalCertificateHomePage.clickHsmMethodId();
        registerDigitalCertificateHomePage.inputAddress(inputAddress);
        registerDigitalCertificateHomePage.clickVibAgencyId();
        registerDigitalCertificateHomePage.clickOrganizationServicePackageIdVIBHSM();
//        registerDigitalCertificateHomePage.clickNextButton();
        registerDigitalCertificateHomePage.inputFullName(inputFullName);
        registerDigitalCertificateHomePage.inputIdentityNumberCCCD(inputMst);
        registerDigitalCertificateHomePage.inputEmail(inputEmail);
        registerDigitalCertificateHomePage.inputPhoneNumber(inputPhoneNumber);
        registerDigitalCertificateHomePage.clickProviceId();
//        registerDigitalCertificateHomePage.clickNextButton();
//        registerDigitalCertificateHomePage.uploadFrontImage(image);
//        registerDigitalCertificateHomePage.uploadBackImage(image);
//        registerDigitalCertificateHomePage.uploadFileRegister(file);
//        registerDigitalCertificateHomePage.clickCreateCSRButton();
//        assertTrue(registerDigitalCertificateHomePage.isCreateCSRSuccessDisplayed());
        registerDigitalCertificateHomePage.clickGridCheck();
        registerDigitalCertificateHomePage.clickSubmitRegistrationButton();
        goToSavisHomePage();
        listDigitalCertificateApprovalsHomePage = VibHomePage.clickListDigitalCertificateApprovals();
        assertTrue(listDigitalCertificateApprovalsHomePage.isListDigitalCertificateApprovalsDisplayed());
        listDigitalCertificateApprovalsHomePage.clickRefuse();
        assertTrue(listDigitalCertificateApprovalsHomePage.isDigitalCertificateRefusePopupDisplayed());
        listDigitalCertificateApprovalsHomePage.clickApprovalsPopup();
        assertTrue(listDigitalCertificateApprovalsHomePage.isRefuseSuccessDisplayed());
    }
}
