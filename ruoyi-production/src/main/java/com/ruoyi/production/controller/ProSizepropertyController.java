package com.ruoyi.production.controller;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.production.domain.ProProduction;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.production.domain.ProSizeproperty;
import com.ruoyi.production.service.IProSizepropertyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规格属性Controller
 * 
 * @author SueLiu
 * @date 2020-09-25
 */
@Controller
@RequestMapping("/production/sizeproperty")
public class ProSizepropertyController extends BaseController
{
    private String prefix = "production/sizeproperty";

    @Autowired
    private IProSizepropertyService proSizepropertyService;

    @RequiresPermissions("production:sizeproperty:view")
    @GetMapping()
    public String sizeproperty()
    {
        return prefix + "/sizeproperty";
    }

    /**
     * 查询规格属性树列表
     */
    @RequiresPermissions("production:sizeproperty:list")
    @PostMapping("/list")
    @ResponseBody
    public List<ProSizeproperty> list(ProSizeproperty proSizeproperty)
    {
        List<ProSizeproperty> list = proSizepropertyService.selectProSizepropertyList(proSizeproperty);
        return list;
    }

    /**
     * 导出规格属性列表
     */
    @RequiresPermissions("production:sizeproperty:export")
    @Log(title = "规格属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProSizeproperty proSizeproperty)
    {
        List<ProSizeproperty> list = proSizepropertyService.selectProSizepropertyList(proSizeproperty);
        ExcelUtil<ProSizeproperty> util = new ExcelUtil<ProSizeproperty>(ProSizeproperty.class);
        return util.exportExcel(list, "sizeproperty");
    }

    /**
     *  导入产品
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "规格属性管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("production:sizeproperty:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        //System.out.println("导入产品数据不能为空！**************1");
        ExcelUtil<ProSizeproperty> util = new ExcelUtil<ProSizeproperty>(ProSizeproperty.class);
        List<ProSizeproperty> SizepropertyList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = proSizepropertyService.importSizeproperty(SizepropertyList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("production:sizeproperty:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        //System.out.println("导入规格属性数据不能为空！**************2");
        ExcelUtil<ProSizeproperty> util = new ExcelUtil<ProSizeproperty>(ProSizeproperty.class);
        return util.importTemplateExcel("规格属性数据");
    }

    /**
     * 新增规格属性
     */
    @GetMapping(value = { "/add/{sizepId}", "/add/" })
    public String add(@PathVariable(value = "sizepId", required = false) Long sizepId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(sizepId))
        {
            mmap.put("proSizeproperty", proSizepropertyService.selectProSizepropertyById(sizepId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存规格属性
     */
    @RequiresPermissions("production:sizeproperty:add")
    @Log(title = "规格属性", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProSizeproperty proSizeproperty)
    {
        return toAjax(proSizepropertyService.insertProSizeproperty(proSizeproperty));
    }

    /**
     * 修改规格属性
     */
    @GetMapping("/edit/{sizepId}")
    public String edit(@PathVariable("sizepId") Long sizepId, ModelMap mmap)
    {
        ProSizeproperty proSizeproperty = proSizepropertyService.selectProSizepropertyById(sizepId);
        mmap.put("proSizeproperty", proSizeproperty);
        return prefix + "/edit";
    }

    /**
     * 修改保存规格属性
     */
    @RequiresPermissions("production:sizeproperty:edit")
    @Log(title = "规格属性", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProSizeproperty proSizeproperty)
    {
        return toAjax(proSizepropertyService.updateProSizeproperty(proSizeproperty));
    }

    /**
     * 删除
     */
    @RequiresPermissions("production:sizeproperty:remove")
    @Log(title = "规格属性", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{sizepId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("sizepId") Long sizepId)
    {
        return toAjax(proSizepropertyService.deleteProSizepropertyById(sizepId));
    }

    /**
     * 选择规格属性树
     */
    @GetMapping(value = { "/selectSizepropertyTree/{sizepId}", "/selectSizepropertyTree/" })
    public String selectSizepropertyTree(@PathVariable(value = "sizepId", required = false) Long sizepId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(sizepId))
        {
            mmap.put("proSizeproperty", proSizepropertyService.selectProSizepropertyById(sizepId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载规格属性树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = proSizepropertyService.selectProSizepropertyTree();
        return ztrees;
    }
}
