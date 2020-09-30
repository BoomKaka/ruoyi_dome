package com.ruoyi.production.service;

import java.util.List;
import com.ruoyi.production.domain.ProFormula;

/**
 * 固定公式Service接口
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
public interface IProFormulaService 
{
    /**
     * 查询固定公式
     * 
     * @param forId 固定公式ID
     * @return 固定公式
     */
    public ProFormula selectProFormulaById(Long forId);

    /**
     * 查询固定公式列表
     * 
     * @param proFormula 固定公式
     * @return 固定公式集合
     */
    public List<ProFormula> selectProFormulaList(ProFormula proFormula);

    /**
     * 新增固定公式
     * 
     * @param proFormula 固定公式
     * @return 结果
     */
    public int insertProFormula(ProFormula proFormula);

    /**
     * 修改固定公式
     * 
     * @param proFormula 固定公式
     * @return 结果
     */
    public int updateProFormula(ProFormula proFormula);

    /**
     * 批量删除固定公式
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProFormulaByIds(String ids);

    /**
     * 删除固定公式信息
     * 
     * @param forId 固定公式ID
     * @return 结果
     */
    public int deleteProFormulaById(Long forId);
}
