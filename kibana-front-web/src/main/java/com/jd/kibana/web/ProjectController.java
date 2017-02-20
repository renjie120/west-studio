package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bucuoa.west.orm.app.common.Expression;
import com.bucuoa.west.orm.app.common.OrderBy;
import com.bucuoa.west.orm.app.common.WPage;
import com.jd.kibana.PageComponnet;
import com.jd.kibana.entity.Project;
import com.jd.kibana.entity.ProjectPage;
import com.jd.kibana.service.ProjectPageService;
import com.jd.kibana.service.ProjectService;
import com.jd.kibana.service.ReportChartService;
import com.jd.kibana.utils.KJsonUtils;

/**
 * 项目
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private ReportChartService reportChartService;
	@Autowired
	private ProjectPageService projectPageService;

	@RequestMapping(value = "/index")
	public String list(Long id, Model model, WPage page) {

		Project pageinfo = null;
		try {
			pageinfo = projectService.findEntityById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			List<Expression> where = new ArrayList<Expression>();
			Expression ex = new Expression("project_id",id);
			Expression ex2 = new Expression("statux",1);

			where.add(ex);
			where.add(ex2);

			OrderBy oderby = new OrderBy("sortx","asc ");
			List<ProjectPage> pages = projectPageService.findEntityList(where, oderby,page);
			 
			model.addAttribute("pages", pages);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("projectinfo", pageinfo);

		return "/frame";
	}
	
	
	@RequestMapping(value = "/page/{id}")
	public String showpage(@PathVariable("id") Long id, Model model, WPage page) {

		ProjectPage pageinfo = null;
		try {
			pageinfo = projectPageService.findEntityById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		String schema = pageinfo.getSchema();

		String componnets = pageinfo.getComponnet();
		if (componnets != null && !componnets.equals("")) {
			try {
				List<PageComponnet> list = KJsonUtils.json2list(componnets, PageComponnet.class);

				for (PageComponnet com : list) {
					if (com.getType().equals("chart")) {
						Long idx = com.getId();
						String script = reportChartService.buildScript(idx);
						if (script != null) {
							com.setScript(script);
						}
					}
				}
				
				model.addAttribute("componnets", list);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		model.addAttribute("pageinfo", pageinfo);
		return "/show_page";
	}
	
	@RequestMapping(value = "/empty")
	public String empty(Long id, Model model, WPage page) {


		return "/empty";
	}


}
