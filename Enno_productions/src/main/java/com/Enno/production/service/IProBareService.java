package com.Enno.production.service;

import java.util.List;
import com.Enno.production.domain.ProBare;

/**
 * 裸机Service接口
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
public interface IProBareService 
{
    /**
     * 查询裸机
     * 
     * @param bareId 裸机ID
     * @return 裸机
     */
    public ProBare selectProBareById(Integer bareId);

    /**
     * 查询裸机列表
     * 
     * @param proBare 裸机
     * @return 裸机集合
     */
    public List<ProBare> selectProBareList(ProBare proBare);

    /**
     * 新增裸机
     * 
     * @param proBare 裸机
     * @return 结果
     */
    public int insertProBare(ProBare proBare);

    /**
     * 修改裸机
     * 
     * @param proBare 裸机
     * @return 结果
     */
    public int updateProBare(ProBare proBare);

    /**
     * 批量删除裸机
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProBareByIds(String ids);

    /**
     * 删除裸机信息
     * 
     * @param bareId 裸机ID
     * @return 结果
     */
    public int deleteProBareById(Integer bareId);
}
