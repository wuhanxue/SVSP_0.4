package com.jdlink.service;

import com.jdlink.domain.Produce.WastesSummary;

import java.util.List;

public interface SecondaryWastesSummaryService {

    /**
     * 获取危废汇总信息
     * @param wastesSummary 查询参数
     * @return 汇总信息
     */
    List<WastesSummary> get(WastesSummary wastesSummary);

    /**
     * 计算危废汇总信息的数量
     * @param wastesSummary 危废汇总对象
     * @return 数量
     */
    int count(WastesSummary wastesSummary);
}
