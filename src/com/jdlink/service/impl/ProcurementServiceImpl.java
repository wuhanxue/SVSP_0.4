package com.jdlink.service.impl;

import com.jdlink.domain.Produce.Material;
import com.jdlink.domain.Produce.Procurement;
import com.jdlink.mapper.ProcurementMapper;
import com.jdlink.service.ProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementServiceImpl implements ProcurementService {
    @Autowired
    ProcurementMapper procurementMapper;
    @Override
    public void add(Procurement procurement) {
        procurementMapper.add(procurement);
    }

    @Override
    public List<String> getNewestId() {
        return procurementMapper.getNewestId();
    }

    @Override
    public void addMaterial(Material material) {
        procurementMapper.addMaterial(material);
    }

    @Override
    public List<Procurement> getProcurementList() {
        return procurementMapper.getProcurementList();
    }

    @Override
    public List<Procurement> getProcurementListById(String receiptNumber) {
        return procurementMapper.getProcurementListById(receiptNumber);
    }

    @Override
    public List<Procurement> searchProcurement(Procurement procurement) {
        return procurementMapper.searchProcurement(procurement);
    }
}