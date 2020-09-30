package com.ruoyi.production.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.production.domain.ProFittings;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.production.service.IProProductionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 产品Controller
 * 
 * @author Jonie
 * @date 2020-09-21
 */
@Controller
@RequestMapping("/production/production")
public class ProProductionController extends BaseController
{
    private String prefix = "production/production";

    @Autowired
    private IProProductionService proProductionService;

    @RequiresPermissions("production:production:view")
    @GetMapping()
    public String production(Model model)
    {
//        List<ProProduction> proClassList = proProductionService.selectProProductionToProClass();//查询
//        model.addAttribute("proClassList",proClassList);
        return prefix + "/production";
    }

    /**
     * 通过分类选择做类型的联级搜索
     * @param request
     * @return
     */
    @RequiresPermissions("production:production:selectProType")
    @PostMapping("/selectProType")
    @ResponseBody
    public List<ProProduction> selectProType(HttpServletRequest request){
        String proClass = request.getParameter("proClass");
        return proProductionService.selectProProductionByProClass(proClass);
    }
//    public List<ProProduction> selectProType(HttpServletRequest request){
//        String proClass = request.getParameter("proClass");
//        List<ProProduction> proClassList = proProductionService.selectProProductionByProClass(proClass);
//        HashSet<String> set  = new HashSet<String>();
//        for(int i = 0; i < proClassList.size(); i++){
//            ProProduction proProduction = (ProProduction)proClassList.get(i);
//            set.add(proProduction.getProType());
//        }
//        List<ProProduction> proList1  = new ArrayList<ProProduction>();
//        for(int i = 0; i < proClassList.size(); i++){
//            ProProduction proProduction = (ProProduction)proClassList.get(i);
//            if(set.contains(proProduction.getProType())){
//                proList1.add(proProduction);
//                set.remove(proProduction.getProType());
//            }
//        }
//        return proList1;
//    }

    /**
     * 执行公式 并且保存到公式表中
     * @param request
     * @return
     */
    @RequiresPermissions("production:production:execSql")
    @PostMapping("/execSql")
    @ResponseBody
    public int execSql(HttpServletRequest request){

        String data = request.getParameter("Sql");
        int res = proProductionService.execSql(data);
        return res;
    }

    /**
     * 查询产品列表
     */
    @RequiresPermissions("production:production:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProProduction proProduction)
    {
        startPage();
        List<ProProduction> list = proProductionService.selectProProductionList(proProduction);
        return getDataTable(list);
    }


    /**
     * 导出产品列表
     */
    @RequiresPermissions("production:production:export")
    @Log(title = "产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProProduction proProduction)
    {
        List<ProProduction> list = proProductionService.selectProProductionList(proProduction);
        ExcelUtil<ProProduction> util = new ExcelUtil<ProProduction>(ProProduction.class);
        return util.exportExcel(list, "production");
    }

    /**
     *  导入产品
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "产品管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("production:production:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        System.out.println("导入产品数据不能为空！**************1");
        ExcelUtil<ProProduction> util = new ExcelUtil<ProProduction>(ProProduction.class);
        List<ProProduction> productionList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = proProductionService.importProduction(productionList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("production:production:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        System.out.println("导入产品数据不能为空！**************2");
        ExcelUtil<ProProduction> util = new ExcelUtil<ProProduction>(ProProduction.class);
        return util.importTemplateExcel("产品数据");
    }

    /**
     * 新增产品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品
     */
    @RequiresPermissions("production:production:add")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProProduction proProduction)
    {
        return toAjax(proProductionService.insertProProduction(proProduction));
    }

    /**
     * 修改产品
     */
    @GetMapping("/edit/{proId}")
    public String edit(@PathVariable("proId") Long proId, ModelMap mmap)
    {
        ProProduction proProduction = proProductionService.selectProProductionById(proId);
        mmap.put("proProduction", proProduction);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品
     */
    @RequiresPermissions("production:production:edit")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProProduction proProduction)
    {
        return toAjax(proProductionService.updateProProduction(proProduction));
    }

    /**
     * 删除产品
     */
    @RequiresPermissions("production:production:remove")
    @Log(title = "产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proProductionService.deleteProProductionByIds(ids));
    }
}
