package com.jdlink.domain.Produce;

import com.jdlink.domain.PackageType;
import com.jdlink.domain.Wastes;

import java.util.ArrayList;
import java.util.List;

public class MaterialRequire {
    /**
     * 物料需求单编号
     */
    private String materialRequireId;
    /**
     * 处置类别
     */
    private  HandleCategory handleCategory;
    /**
     * 目前库存量
     */
    private  float currentInventory;
    /**
     * 周生产计划量
     */
    private float weeklyDemand;
    /**
     * 安全库存量
     */
    private float safety;
    /**
     * 市场采购量
     */
    private float marketPurchases;
/**
 * 危废信息(形态、包装方式、一些物质的最大值最小值)
 */
  List<Wastes> wastesList=new ArrayList<>();

    public String getMaterialRequireId() {
        return materialRequireId;
    }

    public void setMaterialRequireId(String materialRequireId) {
        this.materialRequireId = materialRequireId;
    }

    public HandleCategory getHandleCategory() {
        return handleCategory;
    }

    public void setHandleCategory(HandleCategory handleCategory) {
        this.handleCategory = handleCategory;
    }

    public float getCurrentInventory() {
        return currentInventory;
    }

    public void setCurrentInventory(float currentInventory) {
        this.currentInventory = currentInventory;
    }

    public float getWeeklyDemand() {
        return weeklyDemand;
    }

    public void setWeeklyDemand(float weeklyDemand) {
        this.weeklyDemand = weeklyDemand;
    }

    public float getSafety() {
        return safety;
    }

    public void setSafety(float safety) {
        this.safety = safety;
    }

    public float getMarketPurchases() {
        return marketPurchases;
    }

    public void setMarketPurchases(float marketPurchases) {
        this.marketPurchases = marketPurchases;
    }

    public List<Wastes> getWastesList() {
        return wastesList;
    }

    public void setWastesList(List<Wastes> wastesList) {
        this.wastesList = wastesList;
    }

    @Override
    public String toString() {
        return "MaterialRequire{" +
                "materialRequireId='" + materialRequireId + '\'' +
                ", handleCategory=" + handleCategory +
                ", currentInventory=" + currentInventory +
                ", weeklyDemand=" + weeklyDemand +
                ", safety=" + safety +
                ", marketPurchases=" + marketPurchases +
                ", wastesList=" + wastesList +
                '}';
    }
}
