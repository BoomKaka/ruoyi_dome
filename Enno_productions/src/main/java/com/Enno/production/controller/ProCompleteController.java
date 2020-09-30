package com.Enno.production.controller;

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
import com.Enno.production.domain.ProComplete;
import com.Enno.production.service.IProCompleteService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 整机Controller
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
@Controller
@RequestMapping("/production/complete")
public class ProCompleteController extends BaseController
{
    private String prefix = "production/complete";

    @Autowired
    private IProCompleteService proCompleteService;

    @RequiresPermissions("production:complete:view")
    @GetMapping()
    public String complete()
    {
        return prefix + "/complete";
    }

    /**
     * 查询整机列表
     */
    @RequiresPermissions("production:complete:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProComplete proComplete)
    {
        startPage();
        List<ProComplete> list = proCompleteService.selectProCompleteList(proComplete);
        return getDataTable(list);
    }

    /**
     * 导出整机列表
     */
    @RequiresPermissions("production:complete:export")
    @Log(title = "整机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProComplete proComplete)
    {
        List<ProComplete> list = proCompleteService.selectProCompleteList(proComplete);
        ExcelUtil<ProComplete> util = new ExcelUtil<ProComplete>(ProComplete.class);
        return util.exportExcel(list, "complete");
    }

    /**
     * 新增整机
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存整机
     */
    @RequiresPermissions("production:complete:add")
    @Log(title = "整机", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProComplete proComplete)
    {
        return toAjax(proCompleteService.insertProComplete(proComplete));
    }

    /**
     * 修改整机
     */
    @GetMapping("/edit/{completeId}")
    public String edit(@PathVariable("completeId") Integer completeId, ModelMap mmap)
    {
        ProComplete proComplete = proCompleteService.selectProCompleteById(completeId);
        mmap.put("proComplete", proComplete);
        return prefix + "/edit";
    }

    /**
     * 修改保存整机
     */
    @RequiresPermissions("production:complete:edit")
    @Log(title = "整机", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProComplete proComplete)
    {
        return toAjax(proCompleteService.updateProComplete(proComplete));
    }

    /**
     * 删除整机
     */
    @RequiresPermissions("production:complete:remove")
    @Log(title = "整机", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proCompleteService.deleteProCompleteByIds(ids));
    }
}
