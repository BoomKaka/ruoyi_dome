package com.ruoyi.production.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 固定公式对象 pro_formula
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
public class ProFormula extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long forId;

    /** 分类 */
    private String forClass;

    /** 类型 */
    private String forType;

    /** 产品描述 */
    private String forDecribes;

    /** CPU/芯片 */
    private String forProCpu;

    /** 内存 */
    private String forProMemory;

    /** 存储1 */
    private String forProStorage1;

    /** 存储2 */
    private String forProStorage2;

    /** 其他 */
    private String forProOther;

    /** 裸机型号 */
    private String forProBaremodelno;

    /** 整机型号 */
    private String forProCompmodelno;

    /** 台北价 */
    @Excel(name = "台北价")
    private String forProPrice1;

    /** 白金价 */
    @Excel(name = "白金价")
    private String forProPrice2;

    /** 专营价 */
    @Excel(name = "专营价")
    private String forProPrice3;

    /** 特约价 */
    @Excel(name = "特约价")
    private String forProPrice4;

    /** 所属 */
    private String forProBelongto;

    /** cost */
    @Excel(name = "cost")
    private String forCost;

    /** 含税成本 */
    @Excel(name = "含税成本")
    private String forCostIncludetax;

    /** 预留 */
    private String forReverse;

    /** GP台北 */
    private Double forProGp1;

    /** GP白金 */
    private Double forProGp2;

    /** GP专营 */
    private Double forProGp3;

    /** GP特约 */
    private Double forProGp4;

    /** 辅类 */
    private String forFitSubclass;

    /** 桦汉型号 */
    private String forFitEnnomodelno;

    /** 料号 */
    private String forFitPartnumber;

    /** MQQ(pcs) */
    private Integer forFitMqq;

    /** Price */
    @Excel(name = "Price")
    private String forFitPrice;

    /** 含税价格 */
    @Excel(name = "含税价格")
    private String forFitPriceincludetax;

    /** update */
    @Excel(name = "update", width = 30, dateFormat = "yyyy-MM-dd")
    private Date forFitUpdate;

    /** 不可动 */
    private Double forFitNomove;

    /** GP */
    private String forFitGp;

    /** 供应商 */
    private String forFitSupplier;

    /** 供应商料号 */
    private String forFitSupppartnumber;

    /** 其他 */
    private String forFitOther;

    /** P/N */
    private String forFitPn;

    /** Fan Price */
    @Excel(name = "Fan Price")
    private String forFitFanprice;

    /** 风扇价格 */
    @Excel(name = "风扇价格")
    private String forFitFanprice1;

    /** 未税成本 */
    @Excel(name = "未税成本")
    private String forFitFancost;

    /** 厂商税 */
    private Double forFitManufacturntax;

    /** 含税成本 */
    @Excel(name = "含税成本")
    private String forFitCosttax;

    /** GP */
    private Double forFitFangp;

    /** 汇率 */
    @Excel(name = "汇率")
    private Double forExchangerate;

    /** 税率 */
    @Excel(name = "税率")
    private Double forTaxrate;

    public void setForId(Long forId) 
    {
        this.forId = forId;
    }

    public Long getForId() 
    {
        return forId;
    }
    public void setForClass(String forClass) 
    {
        this.forClass = forClass;
    }

    public String getForClass() 
    {
        return forClass;
    }
    public void setForType(String forType) 
    {
        this.forType = forType;
    }

    public String getForType() 
    {
        return forType;
    }
    public void setForDecribes(String forDecribes) 
    {
        this.forDecribes = forDecribes;
    }

    public String getForDecribes() 
    {
        return forDecribes;
    }
    public void setForProCpu(String forProCpu) 
    {
        this.forProCpu = forProCpu;
    }

    public String getForProCpu() 
    {
        return forProCpu;
    }
    public void setForProMemory(String forProMemory) 
    {
        this.forProMemory = forProMemory;
    }

    public String getForProMemory() 
    {
        return forProMemory;
    }
    public void setForProStorage1(String forProStorage1) 
    {
        this.forProStorage1 = forProStorage1;
    }

    public String getForProStorage1() 
    {
        return forProStorage1;
    }
    public void setForProStorage2(String forProStorage2) 
    {
        this.forProStorage2 = forProStorage2;
    }

    public String getForProStorage2() 
    {
        return forProStorage2;
    }
    public void setForProOther(String forProOther) 
    {
        this.forProOther = forProOther;
    }

    public String getForProOther() 
    {
        return forProOther;
    }
    public void setForProBaremodelno(String forProBaremodelno) 
    {
        this.forProBaremodelno = forProBaremodelno;
    }

    public String getForProBaremodelno() 
    {
        return forProBaremodelno;
    }
    public void setForProCompmodelno(String forProCompmodelno) 
    {
        this.forProCompmodelno = forProCompmodelno;
    }

    public String getForProCompmodelno() 
    {
        return forProCompmodelno;
    }
    public void setForProPrice1(String forProPrice1) 
    {
        this.forProPrice1 = forProPrice1;
    }

    public String getForProPrice1() 
    {
        return forProPrice1;
    }
    public void setForProPrice2(String forProPrice2) 
    {
        this.forProPrice2 = forProPrice2;
    }

    public String getForProPrice2() 
    {
        return forProPrice2;
    }
    public void setForProPrice3(String forProPrice3) 
    {
        this.forProPrice3 = forProPrice3;
    }

    public String getForProPrice3() 
    {
        return forProPrice3;
    }
    public void setForProPrice4(String forProPrice4) 
    {
        this.forProPrice4 = forProPrice4;
    }

    public String getForProPrice4() 
    {
        return forProPrice4;
    }
    public void setForProBelongto(String forProBelongto) 
    {
        this.forProBelongto = forProBelongto;
    }

    public String getForProBelongto() 
    {
        return forProBelongto;
    }
    public void setForCost(String forCost) 
    {
        this.forCost = forCost;
    }

    public String getForCost() 
    {
        return forCost;
    }
    public void setForCostIncludetax(String forCostIncludetax) 
    {
        this.forCostIncludetax = forCostIncludetax;
    }

    public String getForCostIncludetax() 
    {
        return forCostIncludetax;
    }
    public void setForReverse(String forReverse) 
    {
        this.forReverse = forReverse;
    }

    public String getForReverse() 
    {
        return forReverse;
    }
    public void setForProGp1(Double forProGp1) 
    {
        this.forProGp1 = forProGp1;
    }

    public Double getForProGp1() 
    {
        return forProGp1;
    }
    public void setForProGp2(Double forProGp2) 
    {
        this.forProGp2 = forProGp2;
    }

    public Double getForProGp2() 
    {
        return forProGp2;
    }
    public void setForProGp3(Double forProGp3) 
    {
        this.forProGp3 = forProGp3;
    }

    public Double getForProGp3() 
    {
        return forProGp3;
    }
    public void setForProGp4(Double forProGp4) 
    {
        this.forProGp4 = forProGp4;
    }

    public Double getForProGp4() 
    {
        return forProGp4;
    }
    public void setForFitSubclass(String forFitSubclass) 
    {
        this.forFitSubclass = forFitSubclass;
    }

    public String getForFitSubclass() 
    {
        return forFitSubclass;
    }
    public void setForFitEnnomodelno(String forFitEnnomodelno) 
    {
        this.forFitEnnomodelno = forFitEnnomodelno;
    }

    public String getForFitEnnomodelno() 
    {
        return forFitEnnomodelno;
    }
    public void setForFitPartnumber(String forFitPartnumber) 
    {
        this.forFitPartnumber = forFitPartnumber;
    }

    public String getForFitPartnumber() 
    {
        return forFitPartnumber;
    }
    public void setForFitMqq(Integer forFitMqq) 
    {
        this.forFitMqq = forFitMqq;
    }

    public Integer getForFitMqq() 
    {
        return forFitMqq;
    }
    public void setForFitPrice(String forFitPrice) 
    {
        this.forFitPrice = forFitPrice;
    }

    public String getForFitPrice() 
    {
        return forFitPrice;
    }
    public void setForFitPriceincludetax(String forFitPriceincludetax) 
    {
        this.forFitPriceincludetax = forFitPriceincludetax;
    }

    public String getForFitPriceincludetax() 
    {
        return forFitPriceincludetax;
    }
    public void setForFitUpdate(Date forFitUpdate) 
    {
        this.forFitUpdate = forFitUpdate;
    }

    public Date getForFitUpdate() 
    {
        return forFitUpdate;
    }
    public void setForFitNomove(Double forFitNomove) 
    {
        this.forFitNomove = forFitNomove;
    }

    public Double getForFitNomove() 
    {
        return forFitNomove;
    }
    public void setForFitGp(String forFitGp) 
    {
        this.forFitGp = forFitGp;
    }

    public String getForFitGp() 
    {
        return forFitGp;
    }
    public void setForFitSupplier(String forFitSupplier) 
    {
        this.forFitSupplier = forFitSupplier;
    }

    public String getForFitSupplier() 
    {
        return forFitSupplier;
    }
    public void setForFitSupppartnumber(String forFitSupppartnumber) 
    {
        this.forFitSupppartnumber = forFitSupppartnumber;
    }

    public String getForFitSupppartnumber() 
    {
        return forFitSupppartnumber;
    }
    public void setForFitOther(String forFitOther) 
    {
        this.forFitOther = forFitOther;
    }

    public String getForFitOther() 
    {
        return forFitOther;
    }
    public void setForFitPn(String forFitPn) 
    {
        this.forFitPn = forFitPn;
    }

    public String getForFitPn() 
    {
        return forFitPn;
    }
    public void setForFitFanprice(String forFitFanprice) 
    {
        this.forFitFanprice = forFitFanprice;
    }

    public String getForFitFanprice() 
    {
        return forFitFanprice;
    }
    public void setForFitFanprice1(String forFitFanprice1) 
    {
        this.forFitFanprice1 = forFitFanprice1;
    }

    public String getForFitFanprice1() 
    {
        return forFitFanprice1;
    }
    public void setForFitFancost(String forFitFancost) 
    {
        this.forFitFancost = forFitFancost;
    }

    public String getForFitFancost() 
    {
        return forFitFancost;
    }
    public void setForFitManufacturntax(Double forFitManufacturntax) 
    {
        this.forFitManufacturntax = forFitManufacturntax;
    }

    public Double getForFitManufacturntax() 
    {
        return forFitManufacturntax;
    }
    public void setForFitCosttax(String forFitCosttax) 
    {
        this.forFitCosttax = forFitCosttax;
    }

    public String getForFitCosttax() 
    {
        return forFitCosttax;
    }
    public void setForFitFangp(Double forFitFangp) 
    {
        this.forFitFangp = forFitFangp;
    }

    public Double getForFitFangp() 
    {
        return forFitFangp;
    }
    public void setForExchangerate(Double forExchangerate) 
    {
        this.forExchangerate = forExchangerate;
    }

    public Double getForExchangerate() 
    {
        return forExchangerate;
    }
    public void setForTaxrate(Double forTaxrate) 
    {
        this.forTaxrate = forTaxrate;
    }

    public Double getForTaxrate() 
    {
        return forTaxrate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("forId", getForId())
            .append("forClass", getForClass())
            .append("forType", getForType())
            .append("forDecribes", getForDecribes())
            .append("forProCpu", getForProCpu())
            .append("forProMemory", getForProMemory())
            .append("forProStorage1", getForProStorage1())
            .append("forProStorage2", getForProStorage2())
            .append("forProOther", getForProOther())
            .append("forProBaremodelno", getForProBaremodelno())
            .append("forProCompmodelno", getForProCompmodelno())
            .append("forProPrice1", getForProPrice1())
            .append("forProPrice2", getForProPrice2())
            .append("forProPrice3", getForProPrice3())
            .append("forProPrice4", getForProPrice4())
            .append("forProBelongto", getForProBelongto())
            .append("forCost", getForCost())
            .append("forCostIncludetax", getForCostIncludetax())
            .append("forReverse", getForReverse())
            .append("forProGp1", getForProGp1())
            .append("forProGp2", getForProGp2())
            .append("forProGp3", getForProGp3())
            .append("forProGp4", getForProGp4())
            .append("forFitSubclass", getForFitSubclass())
            .append("forFitEnnomodelno", getForFitEnnomodelno())
            .append("forFitPartnumber", getForFitPartnumber())
            .append("forFitMqq", getForFitMqq())
            .append("forFitPrice", getForFitPrice())
            .append("forFitPriceincludetax", getForFitPriceincludetax())
            .append("forFitUpdate", getForFitUpdate())
            .append("forFitNomove", getForFitNomove())
            .append("forFitGp", getForFitGp())
            .append("forFitSupplier", getForFitSupplier())
            .append("forFitSupppartnumber", getForFitSupppartnumber())
            .append("forFitOther", getForFitOther())
            .append("forFitPn", getForFitPn())
            .append("forFitFanprice", getForFitFanprice())
            .append("forFitFanprice1", getForFitFanprice1())
            .append("forFitFancost", getForFitFancost())
            .append("forFitManufacturntax", getForFitManufacturntax())
            .append("forFitCosttax", getForFitCosttax())
            .append("forFitFangp", getForFitFangp())
            .append("forExchangerate", getForExchangerate())
            .append("forTaxrate", getForTaxrate())
            .toString();
    }
}
