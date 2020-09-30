package com.ruoyi.production.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 规格属性对象 pro_sizeproperty
 * 
 * @author SueLiu
 * @date 2020-09-25
 */
public class ProSizeproperty extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long sizepId;

    /** 名称 */
    @Excel(name = "名称")
    private String sizepName;

    /** 父节点 */
    @Excel(name = "父节点")
    private Long sizepParentid;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sizepOrdernum;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private String sizepUnable;

    /** 创建者 */
    @Excel(name = "创建者")
    private String sizepCreator;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sizepCreattime;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sizepUpdatatime;

    public void setSizepId(Long sizepId) 
    {
        this.sizepId = sizepId;
    }

    public Long getSizepId() 
    {
        return sizepId;
    }
    public void setSizepName(String sizepName) 
    {
        this.sizepName = sizepName;
    }

    public String getSizepName() 
    {
        return sizepName;
    }
    public void setSizepParentid(Long sizepParentid)
    {
        this.sizepParentid = sizepParentid;
    }

    public Long getSizepParentid()
    {
        return sizepParentid;
    }
    public void setSizepOrdernum(Integer sizepOrdernum) 
    {
        this.sizepOrdernum = sizepOrdernum;
    }

    public Integer getSizepOrdernum() 
    {
        return sizepOrdernum;
    }
    public void setSizepUnable(String sizepUnable) 
    {
        this.sizepUnable = sizepUnable;
    }

    public String getSizepUnable() 
    {
        return sizepUnable;
    }
    public void setSizepCreator(String sizepCreator) 
    {
        this.sizepCreator = sizepCreator;
    }

    public String getSizepCreator() 
    {
        return sizepCreator;
    }
    public void setSizepCreattime(Date sizepCreattime) 
    {
        this.sizepCreattime = sizepCreattime;
    }

    public Date getSizepCreattime() 
    {
        return sizepCreattime;
    }
    public void setSizepUpdatatime(Date sizepUpdatatime) 
    {
        this.sizepUpdatatime = sizepUpdatatime;
    }

    public Date getSizepUpdatatime() 
    {
        return sizepUpdatatime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sizepId", getSizepId())
            .append("sizepName", getSizepName())
            .append("sizepParentid", getSizepParentid())
            .append("sizepOrdernum", getSizepOrdernum())
            .append("sizepUnable", getSizepUnable())
            .append("sizepCreator", getSizepCreator())
            .append("sizepCreattime", getSizepCreattime())
            .append("sizepUpdatatime", getSizepUpdatatime())
            .toString();
    }
}
