package pageUIs.organizationstructure;

public class OrganizationHomePageUI {
    // LOGIN PAGE
    public static final String CREATE_ORGANIZATIONAL_STRUCTURE_BUTTON = "//a[contains(text(),' Thêm mới ')]";
    public static final String PARENT_ID = "//select[@formcontrolname='parentId']";
    public static final String ORGANAZATION_CODE = "//input[@formcontrolname='code']";
    public static final String ORGANAZATION_NAME = "//input[@formcontrolname='name']";
    public static final String SUBMIT_CREATE_ORGANIZATION_STRUCTURE_BUTTON = "//span[text()='Lưu']/parent::button";
    public static final String ERROR_MESSAGE_ORGANAZATION_CODE = "//input[@name='organizationCode']/following-sibling::div/em";
    public static final String ERROR_MESSAGE_ORGANAZATION_NAME = "//input[@name='organizationName']/following-sibling::div/em";
    public static final String CREATE_ORGANIZATIONAL_STRUCTURE_TEXT = "//h3[contains(text(),'Thêm mới đơn vị')]";
    public static final String MESSAGE_SUCCESSFULLY = "//div[contains(text(),'Thêm mới thành công')]";
    public static final String TAX_CODE = "//input[@formcontrolname='taxCode']";
    public static final String EMAIL = "//input[@formcontrolname='email']";
    public static final String PHONE_NUMBER = "//input[@formcontrolname='phoneNumber']";
    public static final String ADDRESS = "//input[@formcontrolname='address']";
    public static final String PARENT_PROVINCE = "//select[@formcontrolname='provinceId']";
    public static final String PARENT_COUNTRY = "//select[@formcontrolname='country']";
    public static final String NAME_REPRESENTATIVE = "//input[@name='nameRepresentative']";
    public static final String ID_NUMBER_REPRESENTATIVE = "//input[@name='idNumberRepresentative']";
    public static final String EMAIL_REPRESENTATIVE = "//input[@name='emailRepresentative']";
    public static final String PHONE_NUMBER_REPRESENTATIVE = "//input[@name='phoneNumberNepresentative']";
    public static final String ADDRESS_REPRESENTATIVE = "//input[@name='addressRepresentative']";
    public static final String PARENT_PROVINCE_REPRESENTATIVE = "//select[@formcontrolname='provinceRepresentative']";
    public static final String PARENT_COUNTRY_REPRESENTATIVE = "//select[@formcontrolname='countryRepresentative']";
    public static final String CHILD_PROVINCE = "//select[@formcontrolname='provinceId']/option[@label=' Hà Nội']";
    public static final String CHILD_PROVINCE_REPRESENTATIVE = "//select[@formcontrolname='provinceRepresentative']/option[@label=' Hà Nội']";
    public static final String CHILD_ID = "//option[@label='Ngân hàng thương mại cổ phần Quốc tế Việt Nam']";
    public static final String CHILD_COUNTRY = "//option[@label='Việt Nam']";
    public static final String POSITION_REPRESENTATIVE = "//input[@name='positionRepresentative']";
}
