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
import com.jd.kibana.entity.ReportChart;
import com.jd.kibana.service.DataTableService;
import com.jd.kibana.service.ReportChartService;

/**
 * 图表
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/reportChart")
public class ReportChartController {
	@Autowired
	private DataTableService dataTableService;
	@Autowired
	private ReportChartService reportChartService;

	@RequestMapping(value = "/add")
	public String add(RedirectAttributes redirectAttributes, ReportChart entity) {

		return "/modules/reportChart/add";
	}
	
	@RequestMapping(value = "/add/pipe")
	public String addpipe(Model model, Long id) {
		if(id != null)
		{
			ReportChart chart =  null;
			try {
				chart = reportChartService.findEntityById(id);
				model.addAttribute("entity",chart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		List<Expression> where = new ArrayList<Expression>();
//		Expression ex = new Expression("project_id",chart.getProjectId());
		Expression ex2 = new Expression("project_id",0);

//		where.add(ex);
		where.add(ex2);
		List<DataTable> projectDataTable = dataTableService.findEntityList(where, null);
		model.addAttribute("dataTables",projectDataTable);
	
		return "/modules/reportChart/add-pipe-chart";
	}
	
	@RequestMapping(value = "/add/line")
	public String addline(Model model, Long id) {

		if(id != null)
		{
			ReportChart chart =  null;
			try {
				chart = reportChartService.findEntityById(id);
				model.addAttribute("entity",chart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		List<Expression> where = new ArrayList<Expression>();
//		Expression ex = new Expression("project_id",chart.getProjectId());
		Expression ex2 = new Expression("project_id",0);

//		where.add(ex);
		where.add(ex2);
		List<DataTable> projectDataTable = dataTableService.findEntityList(where, null);
		model.addAttribute("dataTables",projectDataTable);
		
		return "/modules/reportChart/add-line-chart";
	}

	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes, ReportChart entity) {

		try {
			if(entity.getId() != null)
			{
				reportChartService.updateEntity(entity);
			}else{
				reportChartService.saveEntity(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list?projectId="+entity.getProjectId();
	}
	
	@RequestMapping(value = "/show")
	public String show( Model model, Long id) {
		ReportChart chart = null;
		try {
			 chart = reportChartService.findEntityById(id);
			
			chart.getConfig();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		String result = "/modules/reportChart/show-line-chart";
		if(chart.getChartType().equals("pipe"))
		{
			result = "/modules/reportChart/show-pipe-chart";
		}
		
		model.addAttribute("chart", chart);
		return result;
	}

	@RequestMapping(value = "/list")
	public String list(Long projectId, Model model, WPage page) {

		try {
			if(projectId != null)
			{
			
				List<Expression> where = new ArrayList<Expression>();
				Expression ex = new Expression("project_id",projectId);
				where.add(ex);
	
				List<ReportChart> findEntityList = reportChartService.findEntityList(where, page);
	
				page.setData(findEntityList);
				page.setTotalCount(findEntityList.size());
	
				model.addAttribute("page", page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/modules/reportChart/list";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {

		try {

			reportChartService.deleteEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}
