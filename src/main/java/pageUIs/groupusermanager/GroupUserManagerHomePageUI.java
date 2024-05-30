package pageUIs.groupusermanager;

public class GroupUserManagerHomePageUI {

    public static final String CREATE_GROUP_USER_BUTTON = "//a[contains(text(),'Thêm mới')]";
    public static final String CREATE_GROUP_USER_TEXT = "//h3[text()='Thêm mới nhóm Người dùng']";
    public static final String GROUP_USER_CODE = "//input[@name='code']";
    public static final String GROUP_USER_NAME = "//input[@name='name']";
    public static final String DESCRIPTION = "//input[@formcontrolname='description']";
    public static final String CHECK_NAVIGATION_LIST = "//span[contains(text(),'Danh sách điều hướng')]/preceding-sibling::input";
    public static final String CHECK_PERMISSTIONS_LIST = "//span[contains(text(),'Danh sách quyền')]/preceding-sibling::input";
    public static final String BUTTON_SUBMIT = "//span[text()='Lưu']/parent::button";
}
