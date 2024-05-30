package pageUIs.listdigitalcertificateapprovals;

public class ListDigitalCertificateApprovalsHomePageUI {

    public static final String APPROVALS_ICON = "(//a[@title='Phê duyệt yêu cầu']//span[@class='Info fs-3 ki-duotone ki-like'])[1]";
    public static final String DIGITAL_CERTIFICATES_APPROVALS_POPUP_TEXT = "//div[contains(text(),'Bạn có chắc muốn phê duyệt yêu cầu')]";
    public static final String APPROVALS_POPUP_BUTTON = "//button[contains(text(),'Đồng ý')]";
    public static final String MESSAGE_APPROVALS_SUCCESS = "//div[contains(text(),'Phê duyệt thành công')]";
    public static final String REFUSE_ICON = "(//a[@title='Từ chối yêu cầu']//span[@class='fs-3 ki-duotone ki-trash ng-star-inserted'])[1]";
    public static final String DIGITAL_CERTIFICATES_REFUSE_POPUP_TEXT = "//div[contains(text(),'Bạn có chắc muốn từ chối yêu cầu')]";
    public static final String MESSAGE_REFUSE_SUCCESS = "//div[contains(text(),'Từ chối yêu cầu thành công')]";
}
