package pageUIs.admin;

public class AdminLoginPageUI {
	public static final String LOGIN_BUTTON = "//button[@class='btn btn-primary']";
	public static final String ICON_EYE = "//i[@class='v-icon eye-slash']";
	public static final String ACCOUNT_TEXTBOX = "//input[@name='userName']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String ACCOUNT_EMPTY_ERROR_MESSAGE = "//input[@placeholder='Nhập tên tài khoản']/parent::div[@class='input__content relative']/following-sibling::p";
	public static final String PASS_EMPTY_ERROR_MESSAGE = "//input[@placeholder='Nhập mật khẩu']/parent::div[@class='input__content relative']/following-sibling::p";
	public static final String MODAL_TEXT = "//div[@class='modal']//p[text()='Sai tên hoặc sai mật khẩu']";

	public static final String ADMIN_PASSWORD_TEXT = "//input[@name='password']";
	public static final String ADMIN_PASSWORD = "12345678";
	public static final String ADMIN_ACCOUNT_TEXT = "//input[@name='userName']";
	public static final String ADMIN_ACCOUNT = "administrator";
	public static final String TITLE_TEXT = "//h1[text()='Home']";
}
