package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bucuoa.west.orm.app.common.Expression;
import com.bucuoa.west.orm.app.common.WPage;
import com.jd.kibana.entity.DataTable;
import com.jd.kibana.entity.Datasource;
import com.jd.kibana.service.DatasourceService;
/**
 * 数据源
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/datasource")
public class DatasourceController {

	@Autowired
	private DatasourceService datasourceService;
	
	@RequestMapping(value = "/add")
	public String add(Model model, Long id) {

		if(id != null)
		{
			try {
				Datasource entity = datasourceService.findEntityById(id);
				
				model.addAttribute("entity", entity);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "/modules/datasource/add";
	}
	
	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes,Datasource entity) {
		
	
		try {
			if(entity.getId() != null)
			{
				datasourceService.updateEntity(entity);
			}else
			{
				datasourceService.saveEntity(entity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,Model model,WPage page) {
		
		try {
			List<Expression> where = new ArrayList<Expression>();

			List<Datasource> list = datasourceService.findEntityList(where, page);
			page.setData(list);
			
			int totalCount = datasourceService.getEntityCount(where);
			page.setTotalCount(totalCount);
			
			model.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "/modules/datasource/list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {
		
		try {
			
			datasourceService.deleteEntityById(id);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}