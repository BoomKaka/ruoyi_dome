package com.Enno.production.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 整机对象 pro_complete
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
public class ProComplete extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer completeId;

    /** 分类 */
    @Excel(name = "分类")
    private String compClass;

    /** 类型 */
    @Excel(name = "类型")
    private String compType;

    /** CPU/芯片 */
    @Excel(name = "CPU/芯片")
    private String compCpu;

    /** 内存 */
    @Excel(name = "内存")
    private String compMemory;

    /** 存储1 */
    @Excel(name = "存储1")
    private String compStore1;

    /** 存储2 */
    @Excel(name = "存储2")
    private String compStore2;

    /** 其他 */
    @Excel(name = "其他")
    private String compOther;

    /** 产品简述 */
    @Excel(name = "产品简述")
    private String compDescribe;

    /** 裸机型号 */
    @Excel(name = "裸机型号")
    private String compBareModel;

    /** 整机型号 */
    @Excel(name = "整机型号")
    private String compComplModel;

    /** 台北 */
    @Excel(name = "台北")
    private BigDecimal compPrice1;

    /** 白金 */
    @Excel(name = "白金")
    private BigDecimal compPrice2;

    /** 专营 */
    @Excel(name = "专营")
    private BigDecimal compPrice3;

    /** 特约 */
    @Excel(name = "特约")
    private BigDecimal compPrice4;

    /** cost */
    @Excel(name = "cost")
    private BigDecimal compCost;

    /** 所属 */
    @Excel(name = "所属")
    private String compBelong;

    /** 成本(含税) */
    @Excel(name = "成本(含税)")
    private BigDecimal compCostTax;

    /** GP-台北 */
    @Excel(name = "GP-台北")
    private Long compGp1;

    /** GP-白金 */
    @Excel(name = "GP-白金")
    private Long compGp2;

    /** GP-专营 */
    @Excel(name = "GP-专营")
    private Long compGp3;

    /** GP-特约 */
    @Excel(name = "GP-特约")
    private Long compGp4;

    /** 预留 */
    @Excel(name = "预留")
    private BigDecimal compReserve;

    /** 预留1 */
    private String compReserve1;

    /** 预留2 */
    private String compReserve2;

    /** 预留3 */
    private String compReserve3;

    /** 预留4 */
    private String compReserve4;

    /** 预留5 */
    private String compReserve5;

    public void setCompleteId(Integer completeId) 
    {
        this.completeId = completeId;
    }

    public Integer getCompleteId() 
    {
        return completeId;
    }
    public void setCompClass(String compClass) 
    {
        this.compClass = compClass;
    }

    public String getCompClass() 
    {
        return compClass;
    }
    public void setCompType(String compType) 
    {
        this.compType = compType;
    }

    public String getCompType() 
    {
        return compType;
    }
    public void setCompCpu(String compCpu) 
    {
        this.compCpu = compCpu;
    }

    public String getCompCpu() 
    {
        return compCpu;
    }
    public void setCompMemory(String compMemory) 
    {
        this.compMemory = compMemory;
    }

    public String getCompMemory() 
    {
        return compMemory;
    }
    public void setCompStore1(String compStore1) 
    {
        this.compStore1 = compStore1;
    }

    public String getCompStore1() 
    {
        return compStore1;
    }
    public void setCompStore2(String compStore2) 
    {
        this.compStore2 = compStore2;
    }

    public String getCompStore2() 
    {
        return compStore2;
    }
    public void setCompOther(String compOther) 
    {
        this.compOther = compOther;
    }

    public String getCompOther() 
    {
        return compOther;
    }
    public void setCompDescribe(String compDescribe) 
    {
        this.compDescribe = compDescribe;
    }

    public String getCompDescribe() 
    {
        return compDescribe;
    }
    public void setCompBareModel(String compBareModel) 
    {
        this.compBareModel = compBareModel;
    }

    public String getCompBareModel() 
    {
        return compBareModel;
    }
    public void setCompComplModel(String compComplModel) 
    {
        this.compComplModel = compComplModel;
    }

    public String getCompComplModel() 
    {
        return compComplModel;
    }
    public void setCompPrice1(BigDecimal compPrice1) 
    {
        this.compPrice1 = compPrice1;
    }

    public BigDecimal getCompPrice1() 
    {
        return compPrice1;
    }
    public void setCompPrice2(BigDecimal compPrice2) 
    {
        this.compPrice2 = compPrice2;
    }

    public BigDecimal getCompPrice2() 
    {
        return compPrice2;
    }
    public void setCompPrice3(BigDecimal compPrice3) 
    {
        this.compPrice3 = compPrice3;
    }

    public BigDecimal getCompPrice3() 
    {
        return compPrice3;
    }
    public void setCompPrice4(BigDecimal compPrice4) 
    {
        this.compPrice4 = compPrice4;
    }

    public BigDecimal getCompPrice4() 
    {
        return compPrice4;
    }
    public void setCompCost(BigDecimal compCost) 
    {
        this.compCost = compCost;
    }

    public BigDecimal getCompCost() 
    {
        return compCost;
    }
    public void setCompBelong(String compBelong) 
    {
        this.compBelong = compBelong;
    }

    public String getCompBelong() 
    {
        return compBelong;
    }
    public void setCompCostTax(BigDecimal compCostTax) 
    {
        this.compCostTax = compCostTax;
    }

    public BigDecimal getCompCostTax() 
    {
        return compCostTax;
    }
    public void setCompGp1(Long compGp1) 
    {
        this.compGp1 = compGp1;
    }

    public Long getCompGp1() 
    {
        return compGp1;
    }
    public void setCompGp2(Long compGp2) 
    {
        this.compGp2 = compGp2;
    }

    public Long getCompGp2() 
    {
        return compGp2;
    }
    public void setCompGp3(Long compGp3) 
    {
        this.compGp3 = compGp3;
    }

    public Long getCompGp3() 
    {
        return compGp3;
    }
    public void setCompGp4(Long compGp4) 
    {
        this.compGp4 = compGp4;
    }

    public Long getCompGp4() 
    {
        return compGp4;
    }
    public void setCompReserve(BigDecimal compReserve) 
    {
        this.compReserve = compReserve;
    }

    public BigDecimal getCompReserve() 
    {
        return compReserve;
    }
    public void setCompReserve1(String compReserve1) 
    {
        this.compReserve1 = compReserve1;
    }

    public String getCompReserve1() 
    {
        return compReserve1;
    }
    public void setCompReserve2(String compReserve2) 
    {
        this.compReserve2 = compReserve2;
    }

    public String getCompReserve2() 
    {
        return compReserve2;
    }
    public void setCompReserve3(String compReserve3) 
    {
        this.compReserve3 = compReserve3;
    }

    public String getCompReserve3() 
    {
        return compReserve3;
    }
    public void setCompReserve4(String compReserve4) 
    {
        this.compReserve4 = compReserve4;
    }

    public String getCompReserve4() 
    {
        return compReserve4;
    }
    public void setCompReserve5(String compReserve5) 
    {
        this.compReserve5 = compReserve5;
    }

    public String getCompReserve5() 
    {
        return compReserve5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("completeId", getCompleteId())
            .append("compClass", getCompClass())
            .append("compType", getCompType())
            .append("compCpu", getCompCpu())
            .append("compMemory", getCompMemory())
            .append("compStore1", getCompStore1())
            .append("compStore2", getCompStore2())
            .append("compOther", getCompOther())
            .append("compDescribe", getCompDescribe())
            .append("compBareModel", getCompBareModel())
            .append("compComplModel", getCompComplModel())
            .append("compPrice1", getCompPrice1())
            .append("compPrice2", getCompPrice2())
            .append("compPrice3", getCompPrice3())
            .append("compPrice4", getCompPrice4())
            .append("compCost", getCompCost())
            .append("compBelong", getCompBelong())
            .append("compCostTax", getCompCostTax())
            .append("compGp1", getCompGp1())
            .append("compGp2", getCompGp2())
            .append("compGp3", getCompGp3())
            .append("compGp4", getCompGp4())
            .append("compReserve", getCompReserve())
            .append("compReserve1", getCompReserve1())
            .append("compReserve2", getCompReserve2())
            .append("compReserve3", getCompReserve3())
            .append("compReserve4", getCompReserve4())
            .append("compReserve5", getCompReserve5())
            .toString();
    }
}
