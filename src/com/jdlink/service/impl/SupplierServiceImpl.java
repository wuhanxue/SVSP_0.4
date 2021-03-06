package com.jdlink.service.impl;

import com.jdlink.domain.Page;
import com.jdlink.domain.Supplier;
import com.jdlink.mapper.SupplierMapper;
import com.jdlink.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by matt on 2018/5/17.
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public void add(Supplier supplier) {
        supplierMapper.add(supplier);
    }

    @Override
    public void delete(String supplierId) {
        supplierMapper.delete(supplierId);
    }

    @Override
    public void enable(String supplierId) {
        supplierMapper.enable(supplierId);
    }

    @Override
    public void disable(String supplierId) {
        supplierMapper.disable(supplierId);
    }

    @Override
    public Supplier getBySupplierId(String supplierId) {
        return supplierMapper.getBySupplierId(supplierId);
    }

    @Override
    public Supplier getByName(String companyName) {
        return supplierMapper.getByName(companyName);
    }

    @Override
    public List<Supplier> search(Supplier supplier) {
        return supplierMapper.search(supplier);
    }

    @Override
    public int searchCount(Supplier supplier) {
        return supplierMapper.searchCount(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierMapper.update(supplier);
    }

    @Override
    public List<Supplier> list() {
        return supplierMapper.list();
    }

    @Override
    public List<Supplier> listPage(Page page){ return supplierMapper.listPage(page); }

    @Override
    public void setCheckStateToSubmit(String supplierId) {
        supplierMapper.setCheckStateToSubmit(supplierId);
    }

    @Override
    public void setCheckStateExamining(String supplierId) {
        supplierMapper.setCheckStateExamining(supplierId);
    }

    @Override
    public void setCheckStateFinished(String supplierId) {
        supplierMapper.setCheckStateFinished(supplierId);
    }

    @Override
    public void setCheckStateBacked(String supplierId) {
        supplierMapper.setCheckStateBacked(supplierId);
    }

    @Override
    public int count() {
        return supplierMapper.count();
    }

    @Override
    public void setFilePath(Supplier supplier) {
        supplierMapper.setFilePath(supplier);
    }

    @Override
    public List<Supplier> transportList(Page page) {
        return supplierMapper.transportList(page);
    }

    @Override
    public List<Supplier> secondaryList(Page page) {
        return supplierMapper.secondaryList(page);
    }

    @Override
    public List<Supplier> procurementList(Page page) {
        return supplierMapper.procurementList(page);
    }

    @Override
    public List<Supplier> otherList(Page page) {
        return supplierMapper.otherList(page);
    }

    @Override
    public int totalSupplierSecondaryRecord() {
        return supplierMapper.totalSupplierSecondaryRecord();
    }

    @Override
    public int totalSupplierTransportsRecord() {
        return supplierMapper.totalSupplierTransportsRecord();
    }

    @Override
    public int totalSupplierProcurementRecord() {
        return supplierMapper.totalSupplierProcurementRecord();
    }

    @Override
    public int totalSupplierOtherRecord() {
        return supplierMapper.totalSupplierOtherRecord();
    }

    @Override
    public String getCurrentId() {
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(4);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(4);
        // 获取最新编号
        String id;
        int index = count();
        // 获取唯一的编号
        do {
            index += 1;
            id = nf.format(index);
        } while (getBySupplierId(id) != null);
        return id;
    }
}
