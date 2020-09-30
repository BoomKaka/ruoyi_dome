package com.ruoyi.production.mapper;

import java.util.List;
import com.ruoyi.production.domain.ProProduction;
import org.apache.ibatis.annotations.Param;

/**
 * 产品Mapper接口
 * 
 * @author Jonie
 * @date 2020-09-21
 */
public interface ProProductionMapper 
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
     * 删除产品
     * 
     * @param proId 产品ID
     * @return 结果
     */
    public int deleteProProductionById(Long proId);

    /**
     * 批量删除产品
     * 
     * @param proIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProProductionByIds(String[] proIds);


    public ProProduction selectProProductionByClassAndCompNo(ProProduction proProduction);
    public ProProduction selectProProductionByClassAndBareNo(ProProduction proProduction);
    public ProProduction selectProProductionByClassAndEnnoNo(ProProduction proProduction);

    /**
     * 运行公式
     * @param data
     * @return
     */
    public int execSql(@Param("data") String data); //@Param声明参数，可以方便前端解析#{}、${}都可，且传参的数量更多

    /**
     * 保存公式
     */
    public int saveMath(@Param("needSave") String needSave);


}
