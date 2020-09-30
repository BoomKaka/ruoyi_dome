package com.ruoyi.production.controller;

import java.util.List;
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
import com.ruoyi.production.domain.ProFormula;
import com.ruoyi.production.service.IProFormulaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 固定公式Controller
 * 
 * @author ruoyi
 * @date 2020-09-23
 */
@Controller
@RequestMapping("/production/formula")
public class ProFormulaController extends BaseController
{
    private String prefix = "production/formula";

    @Autowired
    private IProFormulaService proFormulaService;

    @RequiresPermissions("production:formula:view")
    @GetMapping()
    public String formula()
    {
        return prefix + "/formula";
    }

    /**
     * 查询固定公式列表
     */
    @RequiresPermissions("production:formula:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProFormula proFormula)
    {
        startPage();
        List<ProFormula> list = proFormulaService.selectProFormulaList(proFormula);
        return getDataTable(list);
    }

    /**
     * 导出固定公式列表
     */
    @RequiresPermissions("production:formula:export")
    @Log(title = "固定公式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProFormula proFormula)
    {
        List<ProFormula> list = proFormulaService.selectProFormulaList(proFormula);
        ExcelUtil<ProFormula> util = new ExcelUtil<ProFormula>(ProFormula.class);
        return util.exportExcel(list, "formula");
    }

    /**
     * 新增固定公式
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存固定公式
     */
    @RequiresPermissions("production:formula:add")
    @Log(title = "固定公式", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProFormula proFormula)
    {
        return toAjax(proFormulaService.insertProFormula(proFormula));
    }

    /**
     * 修改固定公式
     */
    @GetMapping("/edit/{forId}")
    public String edit(@PathVariable("forId") Long forId, ModelMap mmap)
    {
        ProFormula proFormula = proFormulaService.selectProFormulaById(forId);
        mmap.put("proFormula", proFormula);
        return prefix + "/edit";
    }

    /**
     * 修改保存固定公式
     */
    @RequiresPermissions("production:formula:edit")
    @Log(title = "固定公式", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProFormula proFormula)
    {
        return toAjax(proFormulaService.updateProFormula(proFormula));
    }

    /**
     * 删除固定公式
     */
    @RequiresPermissions("production:formula:remove")
    @Log(title = "固定公式", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proFormulaService.deleteProFormulaByIds(ids));
    }
}
