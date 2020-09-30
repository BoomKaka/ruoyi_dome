package com.ruoyi.production.service.impl;

import java.util.List;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProProductionMapper;
import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.production.service.IProProductionService;
import com.ruoyi.common.core.text.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 产品Service业务层处理
 * 
 * @author Jonie
 * @date 2020-09-21
 */
@Service
public class ProProductionServiceImpl implements IProProductionService 
{

    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private ProProductionMapper proProductionMapper;


    /**
     * 查询产品
     * 
     * @param proId 产品ID
     * @return 产品
     */
    @Override
    public ProProduction selectProProductionById(Long proId)
    {
        return proProductionMapper.selectProProductionById(proId);
    }

    /**
     * 查询产品列表
     * 
     * @param proProduction 产品
     * @return 产品
     */
    @Override
    public List<ProProduction> selectProProductionList(ProProduction proProduction)
    {
        return proProductionMapper.selectProProductionList(proProduction);
    }

    @Override
    public List<ProProduction> selectProProductionToProClass() {
        return proProductionMapper.selectProProductionToProClass();
    }


    @Override
    public List<ProProduction> selectProProductionByProClass(String proClass) {
        return proProductionMapper.selectProProductionByProClass(proClass);
    }

    /**
     * 新增产品
     * 
     * @param proProduction 产品
     * @return 结果
     */
    @Override
    public int insertProProduction(ProProduction proProduction)
    {
        return proProductionMapper.insertProProduction(proProduction);
    }

    /**
     * 修改产品
     * 
     * @param proProduction 产品
     * @return 结果
     */
    @Override
    public int updateProProduction(ProProduction proProduction)
    {
        return proProductionMapper.updateProProduction(proProduction);
    }

    /**
     * 删除产品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProProductionByIds(String ids)
    {
        return proProductionMapper.deleteProProductionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息
     * 
     * @param proId 产品ID
     * @return 结果
     */
    @Override
    public int deleteProProductionById(Long proId)
    {
        return proProductionMapper.deleteProProductionById(proId);
    }

    /**
     * 产品导入数据
     * @param proList
     * @param isUpdateSupport
     * @param operName
     * @return
     */
    @Override
    public String importProduction(List<ProProduction> proList, Boolean isUpdateSupport, String operName) {
        //System.out.println("导入产品数据不能为空！**************");
        if (StringUtils.isNull(proList) || proList.size() == 0)
        {
            throw new BusinessException("导入产品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (ProProduction productions : proList)
        {
            try
            {
                // 验证是否存在这个产品\
                ProProduction pf = null;
                String a = "";
                if(productions.getProClass().startsWith("整机")){
                    pf = proProductionMapper.selectProProductionByClassAndCompNo(productions);
                    a = productions.getProProCompmodelno();
                }else if(productions.getProClass().startsWith("裸机")){
                    pf = proProductionMapper.selectProProductionByClassAndBareNo(productions);
                    a = productions.getProProBaremodelno();
                }else if(productions.getProClass().startsWith("配件")){
                    pf = proProductionMapper.selectProProductionByClassAndEnnoNo(productions);
                    a = productions.getProFitEnnomodelno();
                }else{
                    throw new BusinessException("导入产品的分类属性不能为空！");
                }

                if (StringUtils.isNull(pf))
                {
                    productions.setCreateBy(operName);
                    this.insertProProduction(productions); //insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、产品 " + a + " 导入成功");
                } else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、产品 " + a + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、产品 " + productions.getProFitEnnomodelno() +" "+ productions.getProProBaremodelno()+" "+ productions.getProProCompmodelno()+ " 导入失败：";
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

    /**
     * 运行公式
     * @param data
     * @return
     */
    public int execSql(String data){

        //从字符串中将 保存到的字段 提取出来
        String saveMath = data.substring(0,data.indexOf("="));   // = 号前面的 用于判断字段
        String needSave = data.substring(data.indexOf("=")+1,data.length());
        needSave = "\" " + needSave + "\" ";
        String formulaInsert = " ";
        if(saveMath.equals("pro_class")){formulaInsert+="for_class" ;}
        else if(saveMath.equals("pro_type")){formulaInsert+="for_type" ;}
        else if(saveMath.equals("pro_decribes")){formulaInsert+="for_decribes" ;}
        else if(saveMath.equals("pro_pro_cpu")){formulaInsert+="for_pro_cpu" ;}
        else if(saveMath.equals("pro_pro_memory")){formulaInsert+="for_pro_memory" ;}
        else if(saveMath.equals("pro_pro_storage1")){formulaInsert+="for_pro_storage1" ;}
        else if(saveMath.equals("pro_pro_storage2")){formulaInsert+="for_pro_storage2" ;}
        else if(saveMath.equals("pro_pro_other")){formulaInsert+="for_pro_other" ;}
        else if(saveMath.equals("pro_pro_bareModelNo")){formulaInsert+="for_pro_bareModelNo" ;}
        else if(saveMath.equals("pro_pro_compModelNO")){formulaInsert+="for_pro_compModelNO" ;}
        else if(saveMath.equals("pro_pro_price_1")){formulaInsert+="for_pro_price_1" ;}
        else if(saveMath.equals("pro_pro_price_2")){formulaInsert+="for_pro_price_2" ;}
        else if(saveMath.equals("pro_pro_price_3")){formulaInsert+="for_pro_price_3" ;}
        else if(saveMath.equals("pro_pro_price_4")){formulaInsert+="for_pro_price_4" ;}
        else if(saveMath.equals("pro_pro_belongTo")){formulaInsert+="for_pro_belongTo" ;}
        else if(saveMath.equals("pro_cost")){formulaInsert+="for_cost" ;}
        else if(saveMath.equals("pro_cost_includeTax")){formulaInsert+="for_cost_includeTax" ;}
        else if(saveMath.equals("pro_reverse")){formulaInsert+="for_reverse" ;}
        else if(saveMath.equals("pro_pro_GP_1")){formulaInsert+="for_pro_GP_1" ;}
        else if(saveMath.equals("pro_pro_GP_2")){formulaInsert+="for_pro_GP_2" ;}
        else if(saveMath.equals("pro_pro_GP_3")){formulaInsert+="for_pro_GP_3" ;}
        else if(saveMath.equals("pro_pro_GP_4")){formulaInsert+="for_pro_GP_4" ;}
        else if(saveMath.equals("pro_fit_subClass")){formulaInsert+="for_fit_subClass" ;}
        else if(saveMath.equals("pro_fit_ennoModelNO")){formulaInsert+="for_fit_ennoModelNO" ;}
        else if(saveMath.equals("pro_fit_partNumber")){formulaInsert+="for_fit_partNumber" ;}
        else if(saveMath.equals("pro_fit_MQQ")){formulaInsert+="for_fit_MQQ" ;}
        else if(saveMath.equals("pro_fit_price")){formulaInsert+="for_fit_price" ;}
        else if(saveMath.equals("pro_fit_priceIncludeTax")){formulaInsert+="for_fit_priceIncludeTax" ;}
        else if(saveMath.equals("pro_fit_NoMove")){formulaInsert+="for_fit_NoMove" ;}
        else if(saveMath.equals("pro_fit_GP")){formulaInsert+="for_fit_GP" ;}
        else if(saveMath.equals("pro_fit_supplier")){formulaInsert+="for_fit_supplier" ;}
        else if(saveMath.equals("pro_fit_suppPartNumber")){formulaInsert+="for_fit_suppPartNumber" ;}
        else if(saveMath.equals("pro_fit_other")){formulaInsert+="for_fit_other" ;}
        else if(saveMath.equals("pro_fit_Pn")){formulaInsert+="for_fit_Pn" ;}
        else if(saveMath.equals("pro_fit_FanPrice")){formulaInsert+="for_fit_FanPrice" ;}
        else if(saveMath.equals("pro_fit_fanprice1")){formulaInsert+="for_fit_fanprice1" ;}
        else if(saveMath.equals("pro_fit_fanCost")){formulaInsert+="for_fit_fanCost" ;}
        else if(saveMath.equals("pro_fit_manufacturnTax")){formulaInsert+="for_fit_manufacturnTax" ;}
        else if(saveMath.equals("pro_fit_costTax")){formulaInsert+="for_fit_costTax" ;}
        else if(saveMath.equals("pro_fit_fanGP")){formulaInsert+="for_fit_fanGP" ;}

        formulaInsert = formulaInsert +  " = " + needSave + " where for_id = 1";


        int i = proProductionMapper.saveMath(formulaInsert);
        return proProductionMapper.execSql(data);
    }
}
