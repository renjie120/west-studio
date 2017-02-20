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
import com.jd.kibana.entity.ReportForm;
import com.jd.kibana.service.DataTableService;
import com.jd.kibana.service.ReportFormService;

/**
 * 报表
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/projectForm")
public class ReportFormController {
	@Autowired
	private DataTableService dataTableService;
	@Autowired
	private ReportFormService reportFormService;

	@RequestMapping(value = "/add")
	public String add( Model model, Long id) {

		ReportForm entity;
		try {
			entity = reportFormService.findEntityById(id);
			model.addAttribute("entity", entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Expression> where = new ArrayList<Expression>();
		Expression ex2 = new Expression("project_id",0);

//		where.add(ex);
		where.add(ex2);
		List<DataTable> projectDataTable = dataTableService.findEntityList(where, null);
		model.addAttribute("dataTables",projectDataTable);

		return "/modules/reportForm/add";
	}

	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes, ReportForm entity) {

		try {
			if (entity.getId() != null) {
				reportFormService.updateEntity(entity);
			} else {
				reportFormService.saveEntity(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list?projectId=" + entity.getProjectId();
	}

	@RequestMapping(value = "/list")
	public String list(Long projectId, HttpServletRequest request, Model model, WPage page) {

		try {
			List<Expression> where = new ArrayList<Expression>();
			Expression ex = new Expression("project_id", projectId);
			where.add(ex);

			List<ReportForm> findEntityList = reportFormService.findEntityList(where, page);
			page.setData(findEntityList);
			page.setTotalCount(findEntityList.size());

			model.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/modules/reportForm/list";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {

		try {

			reportFormService.deleteEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}
