package com.jdlink.mapper;

import com.jdlink.domain.Produce.DocumentControl;

import java.util.List;


/**
 * Created by Leon on 2018/8/30.
 */
public interface DocumentControlMapper {

    /**
     * 列出所有的受控文档
     * @return 受控文档列表
     */
    List<DocumentControl> list(DocumentControl documentControl);

    /**
     * 计算受控文档的数量
     * @param documentControl 参数
     * @return 数量
     */
    int count(DocumentControl documentControl);

    /**
     * 增加受控文档
     * @param documentControl 受控文档
     */
    void add(DocumentControl documentControl);

    /**
     * 更新受控文档
     * @param documentControl 受控文档
     */
    void update(DocumentControl documentControl);

    /**
     * 获取受控文档
     * @param ID 编号
     * @return 文档
     */
    DocumentControl get(String ID);

    /**
     * 作废
     * @param ID 编号
     */
    void setInvalid(String ID);

    /**
     * 设置生效
     * @param ID 编号
     */
    void setEffective(String ID);

    /**
     * 设置失效
     * @param ID 编号
     */
    void setUnEffective(String ID);

}
