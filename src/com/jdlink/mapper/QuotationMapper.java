package com.jdlink.mapper;

import com.jdlink.domain.Quotation;

import java.util.List;

/**
 * Created by matt on 2018/4/23.
 */
public interface QuotationMapper {

    void add(Quotation quotation);

    void update(Quotation quotation);

    List<Quotation> list();

}