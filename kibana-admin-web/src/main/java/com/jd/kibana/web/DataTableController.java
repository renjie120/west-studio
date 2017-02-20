package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bucuoa.west.orm.app.common.Expression;
import com.bucuoa.west.orm.app.common.WPage;
import com.jd.kibana.JdbcDataGather;
import com.jd.kibana.entity.DataTable;
import com.jd.kibana.entity.Datasource;
import com.jd.kibana.service.DataTableService;
import com.jd.kibana.service.DatasourceService;

/**
 * 数据表
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/dataTable")
public class DataTableController {
	@Autowired
	private DatasourceService datasourceService;
	@Autowired
	private DataTableService dataTableService;

	@RequestMapping(value = "/add")
	public String add(Model model, Long id) {

		if(id != null)
		{
			try {
				DataTable entity = dataTableService.findEntityById(id);
				
				model.addAttribute("entity", entity);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<Expression> where = new ArrayList<Expression>();
		Expression ex = new Expression("statux",1);
		where.add(ex);
		
		List<Datasource> datasources = datasourceService.findEntityList(where, null);
		model.addAttribute("datasources", datasources);

		return "/modules/dataTable/add";
	}

	@RequestMapping(value = "/dataShow")
	public String datashow( Model model, Long id) {
		try {
			DataTable table = dataTableService.findEntityById(id);
			Long datasourceId = table.getDatasourceId();
			
			Datasource ds = datasourceService.findEntityById(datasourceId);
			JdbcDataGather gather = new JdbcDataGather(ds);
			List<Map<String, Object>> list = gather.getData(table.getScript());
			List<String> metaData = gather.getMetaData(table.getScript());
			
			model.addAttribute("list", list);
			model.addAttribute("metaDatas", metaData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/modules/dataTable/show";
	}
	
	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes, DataTable entity) {
		
		String script = entity.getScript();
		script = script.replace("'", "\\'");
		
		entity.setScript(script);
		try {
			if(entity.getId() != null)
			{
				dataTableService.updateEntity(entity);
			}else
			{
				dataTableService.saveEntity(entity);

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

			List<DataTable> findEntityList = dataTableService.findEntityList(where, page);
			
			int entityCount = dataTableService.getEntityCount(where);
			
			page.setData(findEntityList);
			page.setTotalCount(entityCount);
			
			model.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/modules/dataTable/list";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {

		try {

			dataTableService.deleteEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}
