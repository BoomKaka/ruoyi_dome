package com.Enno.production.mapper;

import java.util.List;
import com.Enno.production.domain.ProComplete;

/**
 * 整机Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
public interface ProCompleteMapper 
{
    /**
     * 查询整机
     * 
     * @param completeId 整机ID
     * @return 整机
     */
    public ProComplete selectProCompleteById(Integer completeId);

    /**
     * 查询整机列表
     * 
     * @param proComplete 整机
     * @return 整机集合
     */
    public List<ProComplete> selectProCompleteList(ProComplete proComplete);

    /**
     * 新增整机
     * 
     * @param proComplete 整机
     * @return 结果
     */
    public int insertProComplete(ProComplete proComplete);

    /**
     * 修改整机
     * 
     * @param proComplete 整机
     * @return 结果
     */
    public int updateProComplete(ProComplete proComplete);

    /**
     * 删除整机
     * 
     * @param completeId 整机ID
     * @return 结果
     */
    public int deleteProCompleteById(Integer completeId);

    /**
     * 批量删除整机
     * 
     * @param completeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProCompleteByIds(String[] completeIds);
}
