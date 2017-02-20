package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bucuoa.west.orm.app.common.Expression;
import com.bucuoa.west.orm.app.common.WPage;
import com.jd.kibana.entity.DataView;
import com.jd.kibana.service.DataViewService;

/**
 * 数据视图
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/dataView")
public class DataViewController {

	@Autowired
	private DataViewService dataViewService;

	@RequestMapping(value = "/add")
	public String add(Model model, Long id) {
		
		if(id != null)
		{
			try {
				DataView entity = dataViewService.findEntityById(id);
				
				model.addAttribute("entity", entity);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "/modules/dataView/add";
	}

	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes, DataView entity) {

		try {
			if(entity.getId() != null)
			{
				dataViewService.updateEntity(entity);
			}else{
				dataViewService.saveEntity(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model, WPage page) {

		try {
			List<Expression> where = new ArrayList<Expression>();

			List<DataView> findEntityList = dataViewService.findEntityList(where, page);
			
			page.setData(findEntityList);
			
			int totalCount = dataViewService.getEntityCount(where);
			page.setTotalCount(totalCount);
			
			model.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/modules/dataView/list";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {

		try {

			dataViewService.deleteEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}
