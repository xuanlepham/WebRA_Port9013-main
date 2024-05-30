package webraport9013.usermanager;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.usermanager.CreateUserPageObject;
import pageObjects.usermanager.UserManagerPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.BasePage.getRandomString;
import static commons.GlobalConstants.VIB_ADMIN_LOGIN;
import static org.testng.AssertJUnit.*;

public class CreateUserManager extends BaseTest {
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    public String fullName, phoneNumber, birthDay, email, identityNumber, userName, password, supplyDate, supplyPlace;
    public String permanentAddress, currentAddress;

    private UserManagerPageObject userManagerHomePage;
    private CreateUserPageObject createUserHomePage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        loginPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
        homePage = loginPage.goToAdminHomePage();

        phoneNumber = "09899" + getRandomInt();
        fullName = "USER_" + getRandomString();
        birthDay = "01/01/1990";
        email = "savis" + getRandomInt() + "@savis-digital.com";
        identityNumber = "00"+ getRandomInt()+ getRandomInt();
        supplyDate = "02/02/2002";
        supplyPlace = "Hà Nội";
        permanentAddress = getRandomInt() + " Hà Nam";
        currentAddress = getRandomInt() + " Hà Nội";
        userName = "savis" + getRandomInt();
        password = "Abc@1234";
    }

    public void goToHomPage() {
        homePage.openPageUrl(VIB_ADMIN_LOGIN);
    }

    @Test
    public void TC_01_Go_To_Create_User(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go To Create User");
//        goToHomPage();
        userManagerHomePage = homePage.clickUserManager();
        assertTrue(userManagerHomePage.isUserManagerDisplayed());
        createUserHomePage = userManagerHomePage.clickCreateUserButton();
        assertTrue(createUserHomePage.isCreateUserDisplayed());
    }
    @Test
    public void TC_02_Create_User(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create User");
        goToHomPage();
        userManagerHomePage = homePage.clickUserManager();
        assertTrue(userManagerHomePage.isUserManagerDisplayed());
        createUserHomePage = userManagerHomePage.clickCreateUserButton();
        assertTrue(createUserHomePage.isCreateUserDisplayed());
        createUserHomePage.inputFullName(fullName);
        createUserHomePage.inputPhoneNumber(phoneNumber);
        createUserHomePage.inputBirthDay(birthDay);
        createUserHomePage.clickGender();
        createUserHomePage.inputEmail(email);
        createUserHomePage.clickProvince();
        createUserHomePage.clickCountry();
        createUserHomePage.clickIdentityType();
        createUserHomePage.inputIdentityNumber(identityNumber);
        createUserHomePage.inputSupplyDate(supplyDate);
        createUserHomePage.inputSupplyPlace(supplyPlace);
        createUserHomePage.inputPermanentAddress(permanentAddress);
        createUserHomePage.inputCurrentAddress(currentAddress);
        createUserHomePage.clickOrganizationId();
        createUserHomePage.inputUserName(userName);
        createUserHomePage.inputPassword(password);
        createUserHomePage.inputPasswordRepeat(password);
        createUserHomePage.clickGroupUser();
        assertTrue(createUserHomePage.isSubmitCreateButtonEnable());
        createUserHomePage.clickSubmitButton();
    }

}
