package com.ruoyi.production.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProFormulaMapper;
import com.ruoyi.production.domain.ProFormula;
import com.ruoyi.production.service.IProFormulaService;
import com.ruoyi.common.core.text.Convert;

/**
 * 固定公式Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
@Service
public class ProFormulaServiceImpl implements IProFormulaService 
{
    @Autowired
    private ProFormulaMapper proFormulaMapper;

    /**
     * 查询固定公式
     * 
     * @param forId 固定公式ID
     * @return 固定公式
     */
    @Override
    public ProFormula selectProFormulaById(Long forId)
    {
        return proFormulaMapper.selectProFormulaById(forId);
    }

    /**
     * 查询固定公式列表
     * 
     * @param proFormula 固定公式
     * @return 固定公式
     */
    @Override
    public List<ProFormula> selectProFormulaList(ProFormula proFormula)
    {
        return proFormulaMapper.selectProFormulaList(proFormula);
    }

    /**
     * 新增固定公式
     * 
     * @param proFormula 固定公式
     * @return 结果
     */
    @Override
    public int insertProFormula(ProFormula proFormula)
    {
        return proFormulaMapper.insertProFormula(proFormula);
    }

    /**
     * 修改固定公式
     * 
     * @param proFormula 固定公式
     * @return 结果
     */
    @Override
    public int updateProFormula(ProFormula proFormula)
    {
        return proFormulaMapper.updateProFormula(proFormula);
    }

    /**
     * 删除固定公式对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProFormulaByIds(String ids)
    {
        return proFormulaMapper.deleteProFormulaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除固定公式信息
     * 
     * @param forId 固定公式ID
     * @return 结果
     */
    @Override
    public int deleteProFormulaById(Long forId)
    {
        return proFormulaMapper.deleteProFormulaById(forId);
    }
}
