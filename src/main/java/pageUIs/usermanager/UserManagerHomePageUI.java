package pageUIs.usermanager;

public class UserManagerHomePageUI {
    public static final String CREATE_USER_BUTTON = "//a[contains(text(),'Thêm mới')]";
    public static final String CREATE_USER_TEXT = "//h3[contains(text(),'Thông tin người dùng')]";
    public static final String FULL_NAME = "//input[@name='fullName']";
    public static final String PHONE_NUMBER = "//input[@name='phoneNumber']";
    public static final String BIRTH_DAY = "//input[@formcontrolname='birthday']";
    public static final String EMAIL = "//input[@name='email']";
    public static final String IDENTITY_NUMBER = "//input[@name='identityNumber']";
    public static final String UNIT = "//select[@name='organizationId']";
    public static final String USER_NAME = "//input[@name='userName']";
    public static final String PASSWORD = "//input[@name='password']";
    public static final String PASSWORD_REPEAT = "//input[@name='passwordRepeat']";
    public static final String CHECK_GROUP_USER_QTHT = "//span[contains(text(),'QTHT - Quản trị hệ thống')]/preceding-sibling::input";
    public static final String BUTTON_SUBMIT = "//span[contains(text(),'Lưu')]/parent::button";
    public static final String CHECK_GROUP_USER_QTNV = "//span[contains(text(),'QTNV - Quản trị nghiệp vụ')]/preceding-sibling::input";
    public static final String PARENT_GENDER = "//select[@name='gender']";
    public static final String PARENT_PROVINCE = "//select[@formcontrolname='province']";
    public static final String PARENT_COUNTRY = "//select[@formcontrolname='country']";
    public static final String PARENT_IDENTITY_TPYE = "//select[@formcontrolname='identityType']";
    public static final String SUPPLY_DATE = "//input[@formcontrolname='supplyDate']";
    public static final String PERMANENT_ADDRESS = "//input[@formcontrolname='permanentAddress']";
    public static final String CURRENT_ADDRESS = "//input[@formcontrolname='currentAddress']";
    public static final String PARENT_ORGANIZATION_ID = "//select[@formcontrolname='organizationId']";
    public static final String SUPPLY_PLACE = "//input[@formcontrolname='supplyPlace']";
}
