package com.Enno.production.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Enno.production.mapper.ProBareMapper;
import com.Enno.production.domain.ProBare;
import com.Enno.production.service.IProBareService;
import com.ruoyi.common.core.text.Convert;

/**
 * 裸机Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
@Service
public class ProBareServiceImpl implements IProBareService 
{
    @Autowired
    private ProBareMapper proBareMapper;

    /**
     * 查询裸机
     * 
     * @param bareId 裸机ID
     * @return 裸机
     */
    @Override
    public ProBare selectProBareById(Integer bareId)
    {
        return proBareMapper.selectProBareById(bareId);
    }

    /**
     * 查询裸机列表
     * 
     * @param proBare 裸机
     * @return 裸机
     */
    @Override
    public List<ProBare> selectProBareList(ProBare proBare)
    {
        return proBareMapper.selectProBareList(proBare);
    }

    /**
     * 新增裸机
     * 
     * @param proBare 裸机
     * @return 结果
     */
    @Override
    public int insertProBare(ProBare proBare)
    {
        return proBareMapper.insertProBare(proBare);
    }

    /**
     * 修改裸机
     * 
     * @param proBare 裸机
     * @return 结果
     */
    @Override
    public int updateProBare(ProBare proBare)
    {
        return proBareMapper.updateProBare(proBare);
    }

    /**
     * 删除裸机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProBareByIds(String ids)
    {
        return proBareMapper.deleteProBareByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除裸机信息
     * 
     * @param bareId 裸机ID
     * @return 结果
     */
    @Override
    public int deleteProBareById(Integer bareId)
    {
        return proBareMapper.deleteProBareById(bareId);
    }
}
