package com.jdlink.domain.Inventory;

import com.jdlink.domain.*;
import com.jdlink.domain.Dictionary.*;
import com.jdlink.domain.Produce.HandleCategory;
import com.jdlink.domain.Produce.LaboratoryTest;
import com.jdlink.domain.Produce.ProcessWay;

import java.util.Date;

/**
 * Created by matt on 2018/8/20.
 * DoubleClickTo 666
 */
public class InboundOrderItem {
    /**
     * 联单编号
     */
    private String transferDraftId;
    /**
     * 入库单明细编号
     */
    private String inboundOrderItemId;
    /**
     * 入库单号
     */
    private String inboundOrderId;
    /**
     * 入库计划单号
     */
    private String inboundPlanOrderId;
    /**
     * 产废单位
     */
    private Client produceCompany;
    /**
     * 危废(危废名称、危废代码、危废类别)
     */
    private Wastes wastes;
    /**
     * 危废数量
     */
    private float wastesAmount;
    /**
     * 单位
     */
    private Unit wastesUnit;
    /**
     * 单价
     */
    private float unitPriceTax;
    /**
     * 总价金额
     */
    private float totalPrice;
    /**
     * 处理方式
     */
    private ProcessWay processWay;
    /**
     * 进料方式
     */
    private HandleCategory handleCategory;
    /**
     * 物质形态
     */
    private FormType formType;
    /**
     * 包装方式
     */
    private PackageType packageType;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 库区
     */
    private String warehouseArea;
    /**
     * 记录状态
     */
    private RecordState recordState;
    /**
     * 化验单
     */
    private LaboratoryTest laboratoryTest;
    /**
     * 化验结果是否合格
     */
    private boolean isQualified;
    /**
     * 入库日期
     */
    private Date inboundDate;

    /**
     * 进料方式数据字典
     */
    private HandleCategoryItem handleCategoryItem;

    /**
     * 处置方式数据字典
     */
    private ProcessWayItem processWayItem;

    /**
     * 包装方式数据字典
     */
    private PackageTypeItem packageTypeItem;

    /**
     * 物质形态数据字典
     */
    private FormTypeItem formTypeItem;

    /**
     * 记录状态数据字典
     */
    private RecordStateItem recordStateItem;

    /**
     * 单位数据字典
     */
    private UnitDataItem unitDataItem;

    /**
     * 次生名称数据字典
     */
    private SecondaryCategoryItem secondaryCategoryItem;
    /**
     * 所在仓库
     */
    private WareHouse wareHouse;
    /**
     * 开票税率
     */
    private TicketRateItem ticketRateItem;

    public SecondaryCategoryItem getSecondaryCategoryItem() {
        return secondaryCategoryItem;
    }

    public void setSecondaryCategoryItem(SecondaryCategoryItem secondaryCategoryItem) {
        this.secondaryCategoryItem = secondaryCategoryItem;
    }

    public UnitDataItem getUnitDataItem() {
        return unitDataItem;
    }

    public void setUnitDataItem(UnitDataItem unitDataItem) {
        this.unitDataItem = unitDataItem;
    }

    public HandleCategoryItem getHandleCategoryItem() {
        return handleCategoryItem;
    }

    public void setHandleCategoryItem(HandleCategoryItem handleCategoryItem) {
        this.handleCategoryItem = handleCategoryItem;
    }

    public ProcessWayItem getProcessWayItem() {
        return processWayItem;
    }

    public void setProcessWayItem(ProcessWayItem processWayItem) {
        this.processWayItem = processWayItem;
    }

    public PackageTypeItem getPackageTypeItem() {
        return packageTypeItem;
    }

    public void setPackageTypeItem(PackageTypeItem packageTypeItem) {
        this.packageTypeItem = packageTypeItem;
    }

    public FormTypeItem getFormTypeItem() {
        return formTypeItem;
    }

    public void setFormTypeItem(FormTypeItem formTypeItem) {
        this.formTypeItem = formTypeItem;
    }

    public RecordStateItem getRecordStateItem() {
        return recordStateItem;
    }

    public void setRecordStateItem(RecordStateItem recordStateItem) {
        this.recordStateItem = recordStateItem;
    }

    public boolean isQualified() {
        return isQualified;
    }

    public void setQualified(boolean qualified) {
        isQualified = qualified;
    }

    public Date getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(Date inboundDate) {
        this.inboundDate = inboundDate;
    }

    public String getTransferDraftId() {
        return transferDraftId;
    }

    public void setTransferDraftId(String transferDraftId) {
        this.transferDraftId = transferDraftId;
    }

    public String getInboundOrderItemId() {
        return inboundOrderItemId;
    }

    public void setInboundOrderItemId(String inboundOrderItemId) {
        this.inboundOrderItemId = inboundOrderItemId;
    }

    public String getInboundOrderId() {
        return inboundOrderId;
    }

    public void setInboundOrderId(String inboundOrderId) {
        this.inboundOrderId = inboundOrderId;
    }

    public Client getProduceCompany() {
        return produceCompany;
    }

    public void setProduceCompany(Client produceCompany) {
        this.produceCompany = produceCompany;
    }

    public Wastes getWastes() {
        return wastes;
    }

    public void setWastes(Wastes wastes) {
        this.wastes = wastes;
    }

    public ProcessWay getProcessWay() {
        return processWay;
    }

    public void setProcessWay(ProcessWay processWay) {
        this.processWay = processWay;
    }

    public HandleCategory getHandleCategory() {
        return handleCategory;
    }

    public void setHandleCategory(HandleCategory handleCategory) {
        this.handleCategory = handleCategory;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(String warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public RecordState getRecordState() {
        return recordState;
    }

    public void setRecordState(RecordState recordState) {
        this.recordState = recordState;
    }

    public boolean getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(boolean qualified) {
        isQualified = qualified;
    }

    public String getInboundPlanOrderId() {
        return inboundPlanOrderId;
    }

    public void setInboundPlanOrderId(String inboundPlanOrderId) {
        this.inboundPlanOrderId = inboundPlanOrderId;
    }

    public float getWastesAmount() {
        return wastesAmount;
    }

    public void setWastesAmount(float wastesAmount) {
        this.wastesAmount = wastesAmount;
    }

    public Unit getWastesUnit() {
        return wastesUnit;
    }

    public void setWastesUnit(Unit wastesUnit) {
        this.wastesUnit = wastesUnit;
    }

    public float getUnitPriceTax() {
        return unitPriceTax;
    }

    public void setUnitPriceTax(float unitPriceTax) {
        this.unitPriceTax = unitPriceTax;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LaboratoryTest getLaboratoryTest() {
        return laboratoryTest;
    }

    public void setLaboratoryTest(LaboratoryTest laboratoryTest) {
        this.laboratoryTest = laboratoryTest;
    }

    public FormType getFormType() {
        return formType;
    }

    public void setFormType(FormType formType) {
        this.formType = formType;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    public TicketRateItem getTicketRateItem() {
        return ticketRateItem;
    }

    public void setTicketRateItem(TicketRateItem ticketRateItem) {
        this.ticketRateItem = ticketRateItem;
    }

    @Override
    public String toString() {
        return "InboundOrderItem{" +
                "inboundOrderItemId='" + inboundOrderItemId + '\'' +
                ", inboundOrderId='" + inboundOrderId + '\'' +
                ", inboundPlanOrderId='" + inboundPlanOrderId + '\'' +
                ", produceCompany=" + produceCompany +
                ", wastes=" + wastes +
                ", wastesAmount=" + wastesAmount +
                ", unitPriceTax=" + unitPriceTax +
                ", totalPrice=" + totalPrice +
                ", processWay=" + processWay +
                ", handleCategory=" + handleCategory +
                ", remarks='" + remarks + '\'' +
                ", warehouseArea='" + warehouseArea + '\'' +
                ", recordState=" + recordState +
                ", isQualified=" + isQualified +
                '}';
    }
}
