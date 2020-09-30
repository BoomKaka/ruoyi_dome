package com.ruoyi.production.service;

import java.util.List;

import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.production.domain.ProSizeproperty;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 规格属性Service接口
 * 
 * @author SueLiu
 * @date 2020-09-25
 */
public interface IProSizepropertyService 
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
     * 批量删除规格属性
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProSizepropertyByIds(String ids);

    /**
     * 删除规格属性信息
     * 
     * @param sizepId 规格属性ID
     * @return 结果
     */
    public int deleteProSizepropertyById(Long sizepId);

    /**
     * 查询规格属性树列表
     * 
     * @return 所有规格属性信息
     */
    public List<Ztree> selectProSizepropertyTree();

    public String importProduction(List<ProProduction> proList, Boolean isUpdateSupport, String operName);

    String importSizeproperty(List<ProSizeproperty> proList, Boolean updateSupport, String operName);
}
