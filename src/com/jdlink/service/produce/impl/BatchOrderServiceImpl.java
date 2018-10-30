package com.jdlink.service.produce.impl;

import com.jdlink.domain.Inventory.BatchingOrder;
import com.jdlink.domain.Inventory.MaterialRequisitionOrder;
import com.jdlink.domain.Inventory.OutboundOrder;
import com.jdlink.domain.Inventory.WasteInventory;
import com.jdlink.domain.Page;
import com.jdlink.mapper.produce.BatchOrderMapper;
import com.jdlink.service.produce.BatchOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchOrderServiceImpl implements BatchOrderService{
    @Autowired
    BatchOrderMapper batchOrderMapper;

    @Override
    public void addBatchList(BatchingOrder batchingOrder) {
        batchOrderMapper.addBatchList(batchingOrder);
    }

    @Override
    public List<BatchingOrder> BatchList(Page page) {
        return batchOrderMapper.BatchList(page);
    }

    @Override
    public List<WasteInventory> getWasteInventoryListBat() {
        return batchOrderMapper.getWasteInventoryListBat();
    }

    @Override
    public List<WasteInventory> getWasteInventoryByInboundOrderId(String id) {
        return batchOrderMapper.getWasteInventoryByInboundOrderId(id);
    }

    @Override
    public List<String> getBatchingOrderIdList() {
        return batchOrderMapper.getBatchingOrderIdList();
    }

    @Override
    public void addBatchingOrderBat(BatchingOrder batchingOrder) {
        batchOrderMapper.addBatchingOrderBat(batchingOrder);
    }

    @Override
    public void deducNumber(String inboundOrderItemId, float actualCount) {
        batchOrderMapper.deducNumber(inboundOrderItemId,actualCount);
    }

    @Override
    public void addRequisition(MaterialRequisitionOrder materialRequisitionOrder) {
        batchOrderMapper.addRequisition(materialRequisitionOrder);
    }

    @Override
    public List<MaterialRequisitionOrder> getMaterialRequisitionList() {
        return batchOrderMapper.getMaterialRequisitionList();
    }

    @Override
    public void updateMaterialRequisitionOrder(MaterialRequisitionOrder materialRequisitionOrder) {
        batchOrderMapper.updateMaterialRequisitionOrder(materialRequisitionOrder);
    }

    @Override
    public MaterialRequisitionOrder getByMaterialRequisitionId(String id) {
        return batchOrderMapper.getByMaterialRequisitionId(id);
    }

    @Override
    public void addOutBoundOrder(OutboundOrder outboundOrder) {
        batchOrderMapper.addOutBoundOrder(outboundOrder);
    }

    @Override
    public List<OutboundOrder> loadWastesOutBoundList(Page page) {
        return batchOrderMapper.loadWastesOutBoundList(page);
    }
}