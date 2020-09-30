package com.ruoyi.production.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProSizepropertyMapper;
import com.ruoyi.production.domain.ProSizeproperty;
import com.ruoyi.production.service.IProSizepropertyService;
import com.ruoyi.common.core.text.Convert;
/**
 * 规格属性Service业务层处理
 *
 * @author SueLiu
 * @date 2020-09-25
 */
@Service
public class ProSizepropertyServiceImpl implements IProSizepropertyService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private ProSizepropertyMapper proSizepropertyMapper;
    /**
     * 查询规格属性
     *
     * @param sizepId 规格属性ID
     * @return 规格属性
     */
    @Override
    public ProSizeproperty selectProSizepropertyById(Long sizepId)
    {
        return proSizepropertyMapper.selectProSizepropertyById(sizepId);
    }

    /**
     * 查询规格属性列表
     * 
     * @param proSizeproperty 规格属性
     * @return 规格属性
     */
    @Override
    public List<ProSizeproperty> selectProSizepropertyList(ProSizeproperty proSizeproperty)
    {
        return proSizepropertyMapper.selectProSizepropertyList(proSizeproperty);
    }

    /**
     * 新增规格属性
     * 
     * @param proSizeproperty 规格属性
     * @return 结果
     */
    @Override
    public int insertProSizeproperty(ProSizeproperty proSizeproperty)
    {
        return proSizepropertyMapper.insertProSizeproperty(proSizeproperty);
    }

    /**
     * 修改规格属性
     * 
     * @param proSizeproperty 规格属性
     * @return 结果
     */
    @Override
    public int updateProSizeproperty(ProSizeproperty proSizeproperty)
    {
        return proSizepropertyMapper.updateProSizeproperty(proSizeproperty);
    }

    /**
     * 删除规格属性对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProSizepropertyByIds(String ids)
    {
        return proSizepropertyMapper.deleteProSizepropertyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除规格属性信息
     * 
     * @param sizepId 规格属性ID
     * @return 结果
     */
    @Override
    public int deleteProSizepropertyById(Long sizepId)
    {
        return proSizepropertyMapper.deleteProSizepropertyById(sizepId);
    }

    /**
     * 查询规格属性树列表
     * 
     * @return 所有规格属性信息
     */
    @Override
    public List<Ztree> selectProSizepropertyTree()
    {
        List<ProSizeproperty> proSizepropertyList = proSizepropertyMapper.selectProSizepropertyList(new ProSizeproperty());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (ProSizeproperty proSizeproperty : proSizepropertyList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(proSizeproperty.getSizepId());
            ztree.setpId(proSizeproperty.getSizepParentid());
            ztree.setName(proSizeproperty.getSizepName());
            ztree.setTitle(proSizeproperty.getSizepName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public String importProduction(List<ProProduction> proList, Boolean isUpdateSupport, String operName) {
        return null;
    }


    @Override
    public String importSizeproperty(List<ProSizeproperty> proList, Boolean updateSupport,String operName){
        if (StringUtils.isNull(proList) || proList.size() == 0)
        {
            throw new BusinessException("导入产品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (ProSizeproperty proSizeproperty : proList)
        {
            try
            {
                // 验证是否存在这个产品\
                ProSizeproperty pf = proSizepropertyMapper.selectProSizepropertyByName(proSizeproperty);

                if (StringUtils.isNull(pf))
                {
                    proSizeproperty.setCreateBy(operName);
                    this.insertProSizeproperty(proSizeproperty); //insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、产品 " + proSizeproperty.getSizepName() + " 导入成功");
                } else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、产品 " + proSizeproperty.getSizepName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、产品 " + proSizeproperty.getSizepName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
