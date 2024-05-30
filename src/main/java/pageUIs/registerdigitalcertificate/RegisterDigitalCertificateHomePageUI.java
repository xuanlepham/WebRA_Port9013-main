package pageUIs.registerdigitalcertificate;

public class RegisterDigitalCertificateHomePageUI {

    public static final String FILTER = "//select[@class='form-select form-select-solid form-select-lg fw-bold ng-untouched ng-pristine ng-valid']";
    public static final String CHECKED_VALUE = "(//input[@type='checkbox'])[1]";
    public static final String RENEW_WITH_THE_OLD_KEY_BUTTON = "//button[contains(text(),'Gia hạn với key cũ')]";
    public static final String RENEW_BUTTON = "//span[contains(text(),'Gia hạn')]/parent::button";
    public static final String RENEW_WITH_THE_NEW_KEY_BUTTON = "//button[contains(text(),'Gia hạn với key mới')]";
    public static final String PARENT_CA = "//select[@aria-label='Nhập CA']";
    public static final String PARENT_SERVICE_TYPE = "//select[@aria-label='Nhập loại dịch vụ']";
    public static final String CERT_TYPE = "//select[@aria-label='Loại chứng thư số']";
    public static final String VALIDITY = "//select[@formcontrolname='validity']";
    public static final String METHOD_ID = "//select[@aria-label='Chọn phương thức ký']";
    public static final String PARENT_AGENCY_ID = "//div[@class='ng-select-container ng-has-value']";
    public static final String PARENT_SERVICE_PACKAGE_ID = "//div[@class='ng-select-container']";
    public static final String NEXT_BUTTON = "//button[contains(text(),'Tiếp theo')]";
    public static final String FULL_NAME = "//input[@name='fullName']";
    public static final String IDENTITY_NUMBER = "//input[@name='identityNumber_0']";
    public static final String EMAIL = "(//input[@type='email'])[2]";
    public static final String PHONE_NUMBER = "//input[@name='phone']";
    public static final String ADDRESS = "//input[@name='adress']";
    public static final String PROVICE_ID = "//select[@formcontrolname='proviceId']";
    public static final String FRONT_IMAGE = "//label[contains(text(),'Ảnh CCCD mặt trước')]/parent::div/following-sibling::div//input[@type='file']";
    public static final String BACK_IMAGE = "//label[contains(text(),'Ảnh CCCD mặt sau')]/parent::div/following-sibling::div//input[@type='file']";
    public static final String FILE_REGISTER = "//label[contains(text(),'Đơn đề nghị cấp chứng thư số')]/parent::div/following-sibling::div//input[@type='file']";
    public static final String CREATE_CSR_BUTTON = "//button[contains(text(),'Tạo CSR')]";
    public static final String GRID_CHECK = "//input[@id='gridCheck']";
    public static final String SUBMIT_REGISTRATION_BUTTON = "//button[contains(text(),'Gửi đăng ký')]";
    public static final String MESSAGE_CREATE_CSR_SUCCESS = "//div[contains(text(),'Tạo CSR thành công')]";
    public static final String FRONT_IMAGE_DKKD = "//label[contains(text(),'Ảnh GPKD mặt trước')]/parent::div/following-sibling::div//input[@type='file']";
    public static final String BACK_IMAGE_DKKD = "//label[contains(text(),'Ảnh GPKD mặt sau')]/parent::div/following-sibling::div//input[@type='file']";

    public static final String CHILD_CA = "//option[contains(text(),'TrustCA')]";
    public static final String CHILD_SERVICE_TYPE = "//option[contains(text(),'Gói nội bộ')]";
    public static final String VIB_CHILD_AGENCY_ID = "//label[contains(text(),'Ngân hàng thương mại cổ phần Quốc tế Việt Nam VIB')]";
    public static final String VPB_CHILD_AGENCY_ID = "//label[contains(text(),'Ngân hàng Thương mại cổ phần Việt Nam Thịnh Vượng VPBank')]";
    public static final String CHILD_SERVICE_PACKAGE_ID_VIB_HSM = "//label[contains(text(),'Chứng thư số TrustCA SHA256 HSM cho cá nhân thời hạn 1 năm')]";
    public static final String CHILD_INDIVIDUAL_SERVICE_PACKAGE_ID_VIB_HSM = "//option[contains(text(),'Chọn gói dịch vụ')]/following-sibling::option[contains(text(),'VIB_Personal_12Mo_HSM')]";
    public static final String CHILD_INDIVIDUAL_IN_ORF_SERVICE_PACKAGE_ID_VIB_HSM = "//option[contains(text(),'Chọn gói dịch vụ')]/following-sibling::option[contains(text(),'VIB_Member_24Mo_HSM')]";
    public static final String EMAIL_PACKAGE = "//input[@name='emailPackage']";
    public static final String PHONE_PACKAGE = "//input[@name='phonePackage']";
    public static final String BIRTHDAY = "//input[@name='birthDay']";
    public static final String PARENT_GENDER_ID = "//select[@name='gender']";
    public static final String SUPPLY_PLACE = "//input[@name='supplyPlace']";
    public static final String SUPPLY_DATE = "//input[@name='supplyDate']";
    public static final String ORGANIZATION_NAME = "//input[@name='organizationName_0']";
    public static final String PRESITION = "//input[@name='title']";
    public static final String MST = "//input[@name='mst']";
    public static final String CHILD_GENDER_ID = "//select[@name='gender']/option[contains(text(),'Nam')]";
    public static final String CHILD_INDIVIDUAL_SERVICE_PACKAGE_ID_VPB_HSM = "//option[contains(text(),'Chọn gói dịch vụ')]/following-sibling::option[contains(text(),'VPBank_PER_RS_24H_USER')]";
    public static final String CHILD_INDIVIDUAL_IN_ORF_SERVICE_PACKAGE_ID_VPB_RS = "//option[contains(text(),'Chọn gói dịch vụ')]/following-sibling::option[contains(text(),'MEM_RS_1Y_USER')]";
    public static final String CHILD_SERVICE_PACKAGE_ID_VPB_RS = "//option[contains(text(),'Chọn gói dịch vụ')]/following-sibling::option[contains(text(),'VPBank_CORP_RS_1Y_ORG')]";
    public static final String FRONT_IMAGE_DDPL = "//label[contains(text(),'Ảnh người đại diện pháp luật mặt trước')]/parent::div/following-sibling::div//input[@type='file']";
    public static final String BACK_IMAGE_DDPL = "//label[contains(text(),'Ảnh người đại diện pháp luật mặt sau')]/parent::div/following-sibling::div//input[@type='file']";
}
