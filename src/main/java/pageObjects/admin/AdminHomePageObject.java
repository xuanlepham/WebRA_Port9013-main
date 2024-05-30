package pageObjects.admin;

import commons.BasePage;
import pageObjects.listdigitalcertificate.ListDigitalCertificatesPageObject;
import pageObjects.listdigitalcertificateapprovals.ListDigitalCertificateApprovalsPageObject;
import pageObjects.registerdigitalcertificate.RegisterDigitalCertificatesPageObject;
import pageObjects.groupusermanager.GroupUserManagerPageObject;
import pageObjects.camanager.CaManagerPageObject;
import pageObjects.organizationalstructure.OrganizationalStructurePageObject;
import pageObjects.usermanager.UserManagerPageObject;
import pageUIs.admin.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
    public AdminHomePageObject() {
    }
    public OrganizationalStructurePageObject clickOrganizational() {
//        selectItemInCustomDropdown(AdminHomePageUI.SYSTEM_MANGEMANT,AdminHomePageUI.ORGANIZATIONAL_MANAGER);
        waitForElementVisible(AdminHomePageUI.ORGANIZATIONAL_MANAGER);
        clickToElement(AdminHomePageUI.ORGANIZATIONAL_MANAGER);
        return new OrganizationalStructurePageObject();
    }

    public UserManagerPageObject clickUserManager() {
//        selectItemInCustomDropdown(AdminHomePageUI.SYSTEM_MANGEMANT,AdminHomePageUI.USER_MANAGER);
        waitForElementVisible(AdminHomePageUI.USER_MANAGER);
        clickToElement(AdminHomePageUI.USER_MANAGER);
        return new UserManagerPageObject();
    }

    public GroupUserManagerPageObject clickGroupUserManager() {
        selectItemInCustomDropdown(AdminHomePageUI.SYSTEM_MANGEMANT,AdminHomePageUI.GROUP_USER_MANAGER);
        return new GroupUserManagerPageObject();
    }

    public CaManagerPageObject clickCaManager() {
        waitForElementVisible(AdminHomePageUI.CA_MANAGER);
        clickToElement(AdminHomePageUI.CA_MANAGER);
        return new CaManagerPageObject();
    }

    public RegisterDigitalCertificatesPageObject clickRegisterDigitalCertificate() {
        selectItemInCustomDropdown(AdminHomePageUI.CREATE_CERTIFICATE_MANAGER,AdminHomePageUI.REGISTER_DIGITAL_CERTIFICATES);
        return new RegisterDigitalCertificatesPageObject();
    }

    public ListDigitalCertificateApprovalsPageObject clickListDigitalCertificateApprovals() {
        selectItemInCustomDropdown(AdminHomePageUI.SYSTEM_MANGEMANT,AdminHomePageUI.LIST_DIGITAL_CERTIFICATE_APPROVALS);
        return new ListDigitalCertificateApprovalsPageObject();
    }

    public ListDigitalCertificatesPageObject clickListDigitalCertificate() {
        selectItemInCustomDropdown(AdminHomePageUI.SYSTEM_MANGEMANT,AdminHomePageUI.LIST_DIGITAL_CERTIFICATE);
        return new ListDigitalCertificatesPageObject();
    }
}