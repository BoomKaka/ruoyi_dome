package com.Enno.production.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Enno.production.mapper.ProCompleteMapper;
import com.Enno.production.domain.ProComplete;
import com.Enno.production.service.IProCompleteService;
import com.ruoyi.common.core.text.Convert;

/**
 * 整机Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
@Service
public class ProCompleteServiceImpl implements IProCompleteService 
{
    @Autowired
    private ProCompleteMapper proCompleteMapper;

    /**
     * 查询整机
     * 
     * @param completeId 整机ID
     * @return 整机
     */
    @Override
    public ProComplete selectProCompleteById(Integer completeId)
    {
        return proCompleteMapper.selectProCompleteById(completeId);
    }

    /**
     * 查询整机列表
     * 
     * @param proComplete 整机
     * @return 整机
     */
    @Override
    public List<ProComplete> selectProCompleteList(ProComplete proComplete)
    {
        return proCompleteMapper.selectProCompleteList(proComplete);
    }

    /**
     * 新增整机
     * 
     * @param proComplete 整机
     * @return 结果
     */
    @Override
    public int insertProComplete(ProComplete proComplete)
    {
        return proCompleteMapper.insertProComplete(proComplete);
    }

    /**
     * 修改整机
     * 
     * @param proComplete 整机
     * @return 结果
     */
    @Override
    public int updateProComplete(ProComplete proComplete)
    {
        return proCompleteMapper.updateProComplete(proComplete);
    }

    /**
     * 删除整机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProCompleteByIds(String ids)
    {
        return proCompleteMapper.deleteProCompleteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除整机信息
     * 
     * @param completeId 整机ID
     * @return 结果
     */
    @Override
    public int deleteProCompleteById(Integer completeId)
    {
        return proCompleteMapper.deleteProCompleteById(completeId);
    }
}
