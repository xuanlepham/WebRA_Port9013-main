package webraport9013.organizational;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.organizationalstructure.CreateOrganizationalPageObject;
import pageObjects.organizationalstructure.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.*;
import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.*;

public class CreateOrganizational extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    public String organizationCode, organizationName, taxCode, email, phoneNumber, address, nameRepresentative, idNumberRepresentative;
    public String emailRepresentative, phoneNumberRepresentative, positionRepresentative, addressRepresentative;

    private OrganizationalStructurePageObject organizationalHomePage;
    private CreateOrganizationalPageObject createOrganizationalHomePage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        loginPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
        homePage = loginPage.goToAdminHomePage();

        organizationCode = "OC_" + getRandomInt();
        organizationName = "ON " + getRandomString();
        taxCode = getRandomInt() + getRandomInt();
        email = "savis" + getRandomInt() + "@savis-digital.com";
        emailRepresentative = "representative" + getRandomInt() + "@savis-digital.com";
        phoneNumber = "09899" + getRandomInt();
        phoneNumberRepresentative = "09888" + getRandomInt();
        address = getRandomInt() + " Hà Nam";
        addressRepresentative = getRandomInt() + " Hà Nội";
        nameRepresentative = "ĐD " + getRandomString();
        idNumberRepresentative = "0010" + getRandomInt();
        positionRepresentative = "CTHĐHQ";
    }

    public void goToHomPage() {
        homePage.openPageUrl(VIB_ADMIN_LOGIN);
    }

    @Test
    public void TC_01_Go_To_Create_Organizational_Structure(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go To Create Organizational");
//        goToHomPage();
        organizationalHomePage = homePage.clickOrganizational();
        assertTrue(organizationalHomePage.isOrganizationalDisplayed());
        createOrganizationalHomePage = organizationalHomePage.clickCreateOrganizationalButton();
        assertTrue(organizationalHomePage.isCreateOrganizationalStructureDisplayed());
    }

    @Test
    public void TC_02_Create_Organizational(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Organizational");
        goToHomPage();
        organizationalHomePage = homePage.clickOrganizational();
        assertTrue(organizationalHomePage.isOrganizationalDisplayed());
        createOrganizationalHomePage = organizationalHomePage.clickCreateOrganizationalButton();
        createOrganizationalHomePage.clickParentID();
        createOrganizationalHomePage.inputOrganizationCode(organizationCode);
        createOrganizationalHomePage.inputOrganizationName(organizationName);
        createOrganizationalHomePage.inputTaxCode(taxCode);
        createOrganizationalHomePage.inputEmail(email);
        createOrganizationalHomePage.inputPhoneNumber(phoneNumber);
        createOrganizationalHomePage.inputAddress(address);
        createOrganizationalHomePage.clickProvince();
        createOrganizationalHomePage.clickCountry();
        createOrganizationalHomePage.inputNameRepresentative(nameRepresentative);
        createOrganizationalHomePage.inputIdNumberRepresentative(idNumberRepresentative);
        createOrganizationalHomePage.inputEmailRepresentative(emailRepresentative);
        createOrganizationalHomePage.inputPhoneNumberRepresentative(phoneNumberRepresentative);
        createOrganizationalHomePage.inputPositionRepresentative(positionRepresentative);
        createOrganizationalHomePage.inputAddressRepresentative(addressRepresentative);
        createOrganizationalHomePage.clickProvinceRepresentative();
        createOrganizationalHomePage.clickCountryRepresentative();
        createOrganizationalHomePage.clickSubmitCreateOrganizationStructureButton();
        assertTrue(organizationalHomePage.isMessageCreateSuccessfullyDisplayed());
    }
}

