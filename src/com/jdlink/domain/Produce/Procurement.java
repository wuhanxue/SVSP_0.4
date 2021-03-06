package com.jdlink.domain.Produce;

import com.jdlink.domain.CheckState;
import com.jdlink.domain.Dictionary.CheckStateItem;
import com.jdlink.domain.Dictionary.MaterialCategoryItem;
import com.jdlink.domain.Dictionary.NonMaterialItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 采购数据结构
 */
public class Procurement {
    /**
     * 物资类别(应急同)
     */
    private String suppliesCategory;
    /**
     * 申请单编号
     */
    private String receiptNumber;
    /**
     * 申请月份
     */
    private String applyMouth;
    /**
     * 需求时间(应急同)
     */
    private Date demandTime;
    /**
     * 申请日期
     */
    private Date applyDate;
    /**
     * 申请部门
     */
    private String applyDepartment;
//    /**
//     * 需求数量(应急同)
//     */
//    private float demandQuantity;
    /**
     * 申购部门负责人
     */
    private String proposer;
    /**
     * 申购部门分管领导
     */
    private String divisionHead;
    /**
     * 采购部门负责人
     */
    private String purchasingDirector;
    /**
     * 采购部门分管领导
     */
    private String purchasingHead;
    /**
     * 总经理
     */
    private String generalManager;
    /**
     * 编号
     */
    private String Id1;
    /**
     * 序号
     */
    private float Id2;
    /**
     *物资需求清单列表
     */
    List<Material> materialList = new ArrayList<>();
    /**
     * 模糊查询关键字
     */
    private String keywords;
    /**
     * 日期模糊查询
     */
    private String date;
    /**
     * 入库状态
     */
    private CheckState state;
    /**
     * 采购类别(true 为月季采购，false为应急采购)
     */
    /**
     * 创建日期
     */
    private  Date createDate;

    /**
     * 开始日期
     */
    private Date beginTime;

    /**
     * 结束日期
     */
    private Date endTime;

    /**
     * 采购附件
     */
    private MultipartFile procurementFile;

    /**
     * 附件路径
     */
    private String procurementFileURL;

    /**
     * 应急月度(0应急 ,1月度)
     */
    private boolean procurementCategory;

    /**
     * 物资非物资(0为物资,1为非物资)
     * @return
     */
    private boolean nonMaterial;


    //状态字典
    private CheckStateItem checkStateItem;

    //物资类别数据字典
   private MaterialCategoryItem materialCategoryItem;

   //非物资类别数据字典
    private NonMaterialItem nonMaterialItem;

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public NonMaterialItem getNonMaterialItem() {
        return nonMaterialItem;
    }

    public void setNonMaterialItem(NonMaterialItem nonMaterialItem) {
        this.nonMaterialItem = nonMaterialItem;
    }

    public MultipartFile getProcurementFile() {
        return procurementFile;
    }

    public void setProcurementFile(MultipartFile procurementFile) {
        this.procurementFile = procurementFile;
    }

    public String getProcurementFileURL() {
        return procurementFileURL;
    }

    public void setProcurementFileURL(String procurementFileURL) {
        this.procurementFileURL = procurementFileURL;
    }

    public MaterialCategoryItem getMaterialCategoryItem() {
        return materialCategoryItem;
    }

    public void setMaterialCategoryItem(MaterialCategoryItem materialCategoryItem) {
        this.materialCategoryItem = materialCategoryItem;
    }

    public CheckStateItem getCheckStateItem() {
        return checkStateItem;
    }

    public void setCheckStateItem(CheckStateItem checkStateItem) {
        this.checkStateItem = checkStateItem;
    }

    public CheckState getState() {
        return state;
    }

    public void setState(CheckState state) {
        this.state = state;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }


    public Date getDemandTime() {
        return demandTime;
    }

    public void setDemandTime(Date demandTime) {
        this.demandTime = demandTime;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }


    //    /**
//     * 物资名称(应急同)
//     */
//    private String suppliesName;
//    /**
//     * 规格型号(应急同)
//     */
//    private String specifications;
//    /**
//     * 单位(应急同)
//     */
//    private String unit;
//    /**
//     * 库存量(应急同)
//     */
//    private String inventory;
//    /**
//     * 备注
//     */
//    private String note;


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public boolean isNonMaterial() {
        return nonMaterial;
    }

    public void setNonMaterial(boolean nonMaterial) {
        this.nonMaterial = nonMaterial;
    }

    public String getSuppliesCategory() {
        return suppliesCategory;
    }

    public void setSuppliesCategory(String suppliesCategory) {
        this.suppliesCategory = suppliesCategory;
    }

    public String getApplyMouth() {
        return applyMouth;
    }

    public void setApplyMouth(String applyMouth) {
        this.applyMouth = applyMouth;
    }

    public String getApplyDepartment() {
        return applyDepartment;
    }

    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment;
    }



    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getDivisionHead() {
        return divisionHead;
    }

    public void setDivisionHead(String divisionHead) {
        this.divisionHead = divisionHead;
    }

    public String getPurchasingDirector() {
        return purchasingDirector;
    }

    public void setPurchasingDirector(String purchasingDirector) {
        this.purchasingDirector = purchasingDirector;
    }

    public String getPurchasingHead() {
        return purchasingHead;
    }

    public void setPurchasingHead(String purchasingHead) {
        this.purchasingHead = purchasingHead;
    }

    public String getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    public String getId1() {
        return Id1;
    }

    public void setId1(String id1) {
        Id1 = id1;
    }

    public float getId2() {
        return Id2;
    }

    public void setId2(float id2) {
        Id2 = id2;
    }

//    public String getSuppliesName() {
//        return suppliesName;
//    }
//
//    public void setSuppliesName(String suppliesName) {
//        this.suppliesName = suppliesName;
//    }
//
//    public String getSpecifications() {
//        return specifications;
//    }
//
//    public void setSpecifications(String specifications) {
//        this.specifications = specifications;
//    }
//
//    public String getUnit() {
//        return unit;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }
//
//    public String getInventory() {
//        return inventory;
//    }
//
//    public void setInventory(String inventory) {
//        this.inventory = inventory;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }


    public boolean isProcurementCategory() {
        return procurementCategory;
    }

    public void setProcurementCategory(boolean procurementCategory) {
        this.procurementCategory = procurementCategory;
    }

    @Override
    public String toString() {
        return "Procurement{" +
                "suppliesCategory='" + suppliesCategory + '\'' +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", applyMouth='" + applyMouth + '\'' +
                ", demandTime=" + demandTime +
                ", applyDepartment='" + applyDepartment + '\'' +
                ", proposer='" + proposer + '\'' +
                ", divisionHead='" + divisionHead + '\'' +
                ", purchasingDirector='" + purchasingDirector + '\'' +
                ", purchasingHead='" + purchasingHead + '\'' +
                ", generalManager='" + generalManager + '\'' +
                ", Id1='" + Id1 + '\'' +
                ", Id2=" + Id2 +
                ", materialList=" + materialList +
                ", procurementCategory=" + procurementCategory +
                '}';
    }
}
