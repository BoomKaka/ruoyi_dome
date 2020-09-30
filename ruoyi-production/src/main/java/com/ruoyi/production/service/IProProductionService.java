package com.ruoyi.production.service;

import java.util.List;
import com.ruoyi.production.domain.ProProduction;

/**
 * 产品Service接口
 * 
 * @author Jonie
 * @date 2020-09-21
 */
public interface IProProductionService 
{
    /**
     * 查询产品
     * 
     * @param proId 产品ID
     * @return 产品
     */
    public ProProduction selectProProductionById(Long proId);

    /**
     * 查询产品列表
     * 
     * @param proProduction 产品
     * @return 产品集合
     */
    public List<ProProduction> selectProProductionList(ProProduction proProduction);

    public List<ProProduction> selectProProductionToProClass();
    public List<ProProduction> selectProProductionByProClass(String proClass);



    /**
     * 新增产品
     * 
     * @param proProduction 产品
     * @return 结果
     */
    public int insertProProduction(ProProduction proProduction);

    /**
     * 修改产品
     * 
     * @param proProduction 产品
     * @return 结果
     */
    public int updateProProduction(ProProduction proProduction);

    /**
     * 批量删除产品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProProductionByIds(String ids);

    /**
     * 删除产品信息
     * 
     * @param proId 产品ID
     * @return 结果
     */
    public int deleteProProductionById(Long proId);

    /**
     * 导入产品数据
     * @param proList
     * @param isUpdateSupport
     * @param operName
     * @return
     */
    public String importProduction(List<ProProduction> proList, Boolean isUpdateSupport, String operName);

    /**
     * 运行公式
     * @param data
     * @return
     */
    public int execSql(String data);
}
