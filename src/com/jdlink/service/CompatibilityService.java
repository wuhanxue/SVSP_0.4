package com.jdlink.service;

import com.jdlink.domain.Page;
import com.jdlink.domain.Produce.Compatibility;
import com.jdlink.domain.Produce.CompatibilityItem;
import com.jdlink.domain.Produce.MaterialRequire;
import com.jdlink.domain.Produce.MaterialRequireItem;

import java.util.List;

public interface CompatibilityService {
    int total();
    Compatibility getByCompatibilityId(String pwId);
    int getLastId();
    List<String> check();
    List<String> check1();
    List<Compatibility> list(String compatibilityId);
    Compatibility getByPwId1(String pwId);
    void  approval(String pwId,String opinion);
    void  back(String pwId,String opinion);
    void  cancel(String pwId);
    List<Compatibility> search(Compatibility compatibility);
    void add(Compatibility compatibility);
    void addCompatibility(Compatibility compatibility);
    void addCompatibilityItem(CompatibilityItem compatibilityItem);
    List<Compatibility>getWeekPlanList(Page page);
    List<CompatibilityItem>getWeekById(String compatibilityId);
    void submit(String compatibilityId);
    void approvalCompatibility(String compatibilityId);
    void  updateCompatibilityItem(CompatibilityItem compatibilityItem);
    void updateCompatibility(Compatibility compatibility);
    List<Compatibility> searchCompatibility(Compatibility compatibility);
    int totalCompatibilityRecord();
    List<java.lang.String>  searchCompatibilityItem(CompatibilityItem compatibilityItem);
    int searchCount(CompatibilityItem compatibilityItem);
    int count(Compatibility compatibility);
    List<CompatibilityItem> getCompatibilityItemById(String compatibilityId);
    List<String> getNewestMaterialRequireId();
    void addMaterialRequireItem(MaterialRequireItem materialRequireItem);
    void addMaterialRequire(MaterialRequire materialRequire);
    void disabledMaterialRequire(String compatibilityId);

}
