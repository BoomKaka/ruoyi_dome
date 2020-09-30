package com.ruoyi.production.mapper;

import java.util.List;
import com.ruoyi.production.domain.ProSizeproperty;

/**
 * 规格属性Mapper接口
 * 
 * @author SueLiu
 * @date 2020-09-25
 */
public interface ProSizepropertyMapper 
{
    /**
     * 查询规格属性
     * 
     * @param sizepId 规格属性ID
     * @return 规格属性
     */
    public ProSizeproperty selectProSizepropertyById(Long sizepId);

    /**
     * 查询规格属性列表
     * 
     * @param proSizeproperty 规格属性
     * @return 规格属性集合
     */
    public List<ProSizeproperty> selectProSizepropertyList(ProSizeproperty proSizeproperty);

    /**
     * 新增规格属性
     * 
     * @param proSizeproperty 规格属性
     * @return 结果
     */
    public int insertProSizeproperty(ProSizeproperty proSizeproperty);

    /**
     * 修改规格属性
     * 
     * @param proSizeproperty 规格属性
     * @return 结果
     */
    public int updateProSizeproperty(ProSizeproperty proSizeproperty);

    /**
     * 删除规格属性
     * 
     * @param sizepId 规格属性ID
     * @return 结果
     */
    public int deleteProSizepropertyById(Long sizepId);

    /**
     * 批量删除规格属性
     * 
     * @param sizepIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProSizepropertyByIds(String[] sizepIds);

    public ProSizeproperty selectProSizepropertyByName(ProSizeproperty proSizeproperty);
}
