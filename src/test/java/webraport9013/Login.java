package webraport9013;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminLoginPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Login extends BaseTest {
    private String userName, password;
    private String browserName;
    private AdminLoginPageObject loginPage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        loginPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
        userName = "administrator";
        password = "12345678";
    }

    @Test
    public void TC_01_Login(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login Success");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Input User Name");
        loginPage.inputUserName(userName);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input Password");
        loginPage.inputPassword(password);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click Login Button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Verify Title");
        assertEquals(loginPage.getTitle(), "RA Admin - Cổng đăng ký chứng thư số");
    }

}
