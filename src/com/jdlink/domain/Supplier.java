package com.jdlink.domain;

import com.jdlink.domain.Dictionary.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by matt on 2018/4/23.
 * 供应商类
 */
public class Supplier {
    /**
     * 集团编号
     */
    private String groupId;
    // 基本信息
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 供应商编码
     */
    private String supplierId;
    /**
     * 组织机构代码
     */
    private String organizationCode;
    /**
     * 营业执照注册号
     */
    private String licenseCode;
    /**
     * 法人代表
     */
    private String representative;
    /**
     * 工商注册地邮编
     */
    private String postCode;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 主要产品
     */
    private String product;

    /**
     * 企业类型
     */
    private EnterpriseType enterpriseType;
    /**
     * 企业类型条目
     */
    private EnterpriseTypeItem enterpriseTypeItem;
    /**
     * 经营方式
     */
    private OperationMode operationMode;
    /**
     * 经营方式条目
     */
    private OperationModelItem operationModelItem;
    /**
     * 经营单位类别
     */
    private OperationType operationType;
    /**
     * 经营单位类别条目
     */
    private OperationTypeItem operationTypeItem;
    /**
     * 事故防范和应急预案
     */
    private ContingencyPlan contingencyPlan;
    /**
     * 事故防范和应急预案
     */
    private ContingencyPlanItem contingencyPlanItem;
    /**
     * 建立危废经营记录情况
     */
    private OperationRecord operationRecord;
    /**
     * 危废经营记录情况条目
     */
    private OperationRecordItem operationRecordItem;
    /**
     * 供应商类型
     */
    private SupplierType supplierType;
    /**
     * 供应商类型条目
     */
    private SupplierTypeItem supplierTypeItem;
    /**
     * 工商注册地址
     */
    private String location;
    /**
     * 所属街道
     */
    private String street;
    /**
     * 申报状态
     */
    private ApplicationStatus applicationStatus;
    /**
     * 申报状态条目
     */
    private ApplicationStatusItem applicationStatusItem;

    // 环评信息
    /**
     * 原辅材料附件地址
     */
    private String materialAttachmentUrl;
    /**
     * 原辅材料附件
     */
    private MultipartFile materialAttachment;

    /**
     * 工艺流程图附件地址
     */
    private String processAttachmentUrl;
    /**
     * 工艺流程图附件
     */
    private MultipartFile processAttachment;
    /**
     * 工艺描述
     */
    private String processDesp;

    // 联系信息
    /**
     * 联系人
     */
    private String contactName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 审核状态
     */
    private CheckState checkState;
    /**
     * 审核状态条目
     */
    private CheckStateItem checkStateItem;
    /**
     * 账号状态
     */
    private ClientState supplierState;
    /**
     * 账号状态条目
     */
    private ClientStateItem supplierStateItem;
    /**
     * 税号
     */
    private String taxNumber;
    /**
     * 注册资本
     */
    private String registeredCapital;
    /**
     * 成立日期
     */
    private Date createDate;
    /**
     * 营业期限
     */
    private String businessLimit;
    /**
     * 道路运输许可证号
     */
    private String transportLicense;
    /**
     * 证件有效期
     */
    private Date expirationDate;
    /**
     * 开户行名称
     */
    private String bankName;
    /**
     * 开户行账号
     */
    private String bankAccount;
    /**
     * 开票税率
     */
    private TicketRate1 ticketRate;
    /**
     * 开票税率条目
     */
    private TicketRateItem ticketRateItem;
    /**
     * 当前时间
     */
    private Date nowTime;
    /**
     * 营业执照
     */
    private String licenseFile1Url;
    /**
     * 道路运输许可证
     */
    private String licenseFile2Url;
    /**
     * 其他文件1
     */
    private MultipartFile otherFile3;
    /**
     * 其他文件1地址
     */
    private String otherFile3Url;
    /**
     * 其他文件2
     */
    private MultipartFile otherFile4;
    /**
     * 其他文件2地址
     */
    private String otherFile4Url;

    private String keyword;

    private Page page;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public OperationMode getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(OperationMode operationMode) {
        this.operationMode = operationMode;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public ContingencyPlan getContingencyPlan() {
        return contingencyPlan;
    }

    public void setContingencyPlan(ContingencyPlan contingencyPlan) {
        this.contingencyPlan = contingencyPlan;
    }

    public OperationRecord getOperationRecord() {
        return operationRecord;
    }

    public void setOperationRecord(OperationRecord operationRecord) {
        this.operationRecord = operationRecord;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getMaterialAttachmentUrl() {
        return materialAttachmentUrl;
    }

    public void setMaterialAttachmentUrl(String materialAttachmentUrl) {
        this.materialAttachmentUrl = materialAttachmentUrl;
    }

    public MultipartFile getMaterialAttachment() {
        return materialAttachment;
    }

    public void setMaterialAttachment(MultipartFile materialAttachment) {
        this.materialAttachment = materialAttachment;
    }

    public String getProcessAttachmentUrl() {
        return processAttachmentUrl;
    }

    public void setProcessAttachmentUrl(String processAttachmentUrl) {
        this.processAttachmentUrl = processAttachmentUrl;
    }

    public MultipartFile getProcessAttachment() {
        return processAttachment;
    }

    public void setProcessAttachment(MultipartFile processAttachment) {
        this.processAttachment = processAttachment;
    }

    public String getProcessDesp() {
        return processDesp;
    }

    public void setProcessDesp(String processDesp) {
        this.processDesp = processDesp;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CheckState getCheckState() {
        return checkState;
    }

    public void setCheckState(CheckState checkState) {
        this.checkState = checkState;
    }

    public ClientState getSupplierState() {
        return supplierState;
    }

    public void setSupplierState(ClientState supplierState) {
        this.supplierState = supplierState;
    }

    public SupplierType getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(SupplierType supplierType) {
        this.supplierType = supplierType;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBusinessLimit() {
        return businessLimit;
    }

    public void setBusinessLimit(String businessLimit) {
        this.businessLimit = businessLimit;
    }

    public String getTransportLicense() {
        return transportLicense;
    }

    public void setTransportLicense(String transportLicense) {
        this.transportLicense = transportLicense;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public TicketRate1 getTicketRate() {
        return ticketRate;
    }

    public void setTicketRate(TicketRate1 ticketRate) {
        this.ticketRate = ticketRate;
    }

    public Date getNowTime() {
        return nowTime;
    }

    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    public String getLicenseFile1Url() {
        return licenseFile1Url;
    }

    public void setLicenseFile1Url(String licenseFile1Url) {
        this.licenseFile1Url = licenseFile1Url;
    }

    public String getLicenseFile2Url() {
        return licenseFile2Url;
    }

    public void setLicenseFile2Url(String licenseFile2Url) {
        this.licenseFile2Url = licenseFile2Url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public EnterpriseTypeItem getEnterpriseTypeItem() {
        return enterpriseTypeItem;
    }

    public void setEnterpriseTypeItem(EnterpriseTypeItem enterpriseTypeItem) {
        this.enterpriseTypeItem = enterpriseTypeItem;
    }

    public OperationModelItem getOperationModelItem() {
        return operationModelItem;
    }

    public void setOperationModelItem(OperationModelItem operationModelItem) {
        this.operationModelItem = operationModelItem;
    }

    public OperationTypeItem getOperationTypeItem() {
        return operationTypeItem;
    }

    public void setOperationTypeItem(OperationTypeItem operationTypeItem) {
        this.operationTypeItem = operationTypeItem;
    }

    public ContingencyPlanItem getContingencyPlanItem() {
        return contingencyPlanItem;
    }

    public void setContingencyPlanItem(ContingencyPlanItem contingencyPlanItem) {
        this.contingencyPlanItem = contingencyPlanItem;
    }

    public OperationRecordItem getOperationRecordItem() {
        return operationRecordItem;
    }

    public void setOperationRecordItem(OperationRecordItem operationRecordItem) {
        this.operationRecordItem = operationRecordItem;
    }

    public SupplierTypeItem getSupplierTypeItem() {
        return supplierTypeItem;
    }

    public void setSupplierTypeItem(SupplierTypeItem supplierTypeItem) {
        this.supplierTypeItem = supplierTypeItem;
    }

    public ApplicationStatusItem getApplicationStatusItem() {
        return applicationStatusItem;
    }

    public void setApplicationStatusItem(ApplicationStatusItem applicationStatusItem) {
        this.applicationStatusItem = applicationStatusItem;
    }

    public CheckStateItem getCheckStateItem() {
        return checkStateItem;
    }

    public void setCheckStateItem(CheckStateItem checkStateItem) {
        this.checkStateItem = checkStateItem;
    }

    public ClientStateItem getSupplierStateItem() {
        return supplierStateItem;
    }

    public void setSupplierStateItem(ClientStateItem supplierStateItem) {
        this.supplierStateItem = supplierStateItem;
    }

    public TicketRateItem getTicketRateItem() {
        return ticketRateItem;
    }

    public void setTicketRateItem(TicketRateItem ticketRateItem) {
        this.ticketRateItem = ticketRateItem;
    }

    public MultipartFile getOtherFile3() {
        return otherFile3;
    }

    public void setOtherFile3(MultipartFile otherFile3) {
        this.otherFile3 = otherFile3;
    }

    public String getOtherFile3Url() {
        return otherFile3Url;
    }

    public void setOtherFile3Url(String otherFile3Url) {
        this.otherFile3Url = otherFile3Url;
    }

    public MultipartFile getOtherFile4() {
        return otherFile4;
    }

    public void setOtherFile4(MultipartFile otherFile4) {
        this.otherFile4 = otherFile4;
    }

    public String getOtherFile4Url() {
        return otherFile4Url;
    }

    public void setOtherFile4Url(String otherFile4Url) {
        this.otherFile4Url = otherFile4Url;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "groupId='" + groupId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                ", licenseCode='" + licenseCode + '\'' +
                ", representative='" + representative + '\'' +
                ", postCode='" + postCode + '\'' +
                ", industry='" + industry + '\'' +
                ", product='" + product + '\'' +
                ", enterpriseType=" + enterpriseType +
                ", operationMode=" + operationMode +
                ", operationType=" + operationType +
                ", contingencyPlan=" + contingencyPlan +
                ", operationRecord=" + operationRecord +
                ", supplierType=" + supplierType +
                ", location='" + location + '\'' +
                ", street='" + street + '\'' +
                ", applicationStatus=" + applicationStatus +
                ", materialAttachmentUrl='" + materialAttachmentUrl + '\'' +
                ", materialAttachment=" + materialAttachment +
                ", processAttachmentUrl='" + processAttachmentUrl + '\'' +
                ", processAttachment=" + processAttachment +
                ", processDesp='" + processDesp + '\'' +
                ", contactName='" + contactName + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", checkState=" + checkState +
                ", supplierState=" + supplierState +
                ", taxNumber='" + taxNumber + '\'' +
                ", registeredCapital='" + registeredCapital + '\'' +
                ", createDate=" + createDate +
                ", businessLimit='" + businessLimit + '\'' +
                ", transportLicense='" + transportLicense + '\'' +
                ", expirationDate=" + expirationDate +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", ticketRate=" + ticketRate +
                ", nowTime=" + nowTime +
                ", licenseFile1Url='" + licenseFile1Url + '\'' +
                ", licenseFile2Url='" + licenseFile2Url + '\'' +
                '}';
    }
}
