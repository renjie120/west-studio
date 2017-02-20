/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.SysWorkArea;
import com.thinkgem.jeesite.modules.sys.service.SysWorkAreaService;

/**
 * 办公场地管理Controller
 * @author 吴江
 * @version 2016-04-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysWorkArea")
public class SysWorkAreaController extends BaseController {

	@Autowired
	private SysWorkAreaService sysWorkAreaService;
	
	@ModelAttribute
	public SysWorkArea get(@RequestParam(required=false) String id) {
		SysWorkArea entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysWorkAreaService.get(id);
		}
		if (entity == null){
			entity = new SysWorkArea();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysWorkArea:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysWorkArea sysWorkArea, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<SysWorkArea> list = sysWorkAreaService.findList(sysWorkArea); 
		model.addAttribute("list", list);
		return "modules/sys/sysWorkAreaList";
	}

	@RequiresPermissions("sys:sysWorkArea:view")
	@RequestMapping(value = "form")
	public String form(SysWorkArea sysWorkArea, Model model) {
		if (sysWorkArea.getParent()!=null && StringUtils.isNotBlank(sysWorkArea.getParent().getId())){
			sysWorkArea.setParent(sysWorkAreaService.get(sysWorkArea.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(sysWorkArea.getId())){
				SysWorkArea sysWorkAreaChild = new SysWorkArea();
				sysWorkAreaChild.setParent(new SysWorkArea(sysWorkArea.getParent().getId()));
				List<SysWorkArea> list = sysWorkAreaService.findList(sysWorkArea); 
				if (list.size() > 0){
					sysWorkArea.setSort(list.get(list.size()-1).getSort());
					if (sysWorkArea.getSort() != null){
						sysWorkArea.setSort(sysWorkArea.getSort() + 30);
					}
				}
			}
		}
		if (sysWorkArea.getSort() == null){
			sysWorkArea.setSort(30);
		}
		model.addAttribute("sysWorkArea", sysWorkArea);
		return "modules/sys/sysWorkAreaForm";
	}

	@RequiresPermissions("sys:sysWorkArea:edit")
	@RequestMapping(value = "save")
	public String save(SysWorkArea sysWorkArea, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysWorkArea)){
			return form(sysWorkArea, model);
		}
		sysWorkAreaService.save(sysWorkArea);
		addMessage(redirectAttributes, "保存职场管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysWorkArea/?repage";
	}
	
	@RequiresPermissions("sys:sysWorkArea:edit")
	@RequestMapping(value = "delete")
	public String delete(SysWorkArea sysWorkArea, RedirectAttributes redirectAttributes) {
		sysWorkAreaService.delete(sysWorkArea);
		addMessage(redirectAttributes, "删除职场管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysWorkArea/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<SysWorkArea> list = sysWorkAreaService.findList(new SysWorkArea());
		for (int i=0; i<list.size(); i++){
			SysWorkArea e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}