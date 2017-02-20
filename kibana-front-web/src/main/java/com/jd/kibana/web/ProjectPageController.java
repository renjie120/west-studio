package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bucuoa.west.orm.app.common.Expression;
import com.bucuoa.west.orm.app.common.WPage;
import com.jd.kibana.PageComponnet;
import com.jd.kibana.entity.ProjectPage;
import com.jd.kibana.service.ProjectPageService;
import com.jd.kibana.service.ReportChartService;
import com.jd.kibana.utils.KJsonUtils;

/**
 * 项目组件
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/projectPage")
public class ProjectPageController {
	@Autowired
	private ReportChartService reportChartService;
	@Autowired
	private ProjectPageService projectPageService;

	@RequestMapping(value = "/add")
	public String add(RedirectAttributes redirectAttributes, ProjectPage entity) {

		return "/modules/projectPage/add";
	}

	@RequestMapping(value = "/show")
	public String showpage(Model model, Long id) {
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
		return "/modules/projectPage/showpage";
	}

	@RequestMapping(value = "/list/{projectId}")
	public String list(HttpServletRequest request, Model model, WPage page, @PathVariable("projectId") Long projectId) {

		try {

			List<Expression> where = new ArrayList<Expression>();
			if (projectId != null) {
				Expression ex = new Expression("project_id", projectId);

				where.add(ex);
			}

			List<ProjectPage> findEntityList = projectPageService.findEntityList(where, page);
			int entityCount = projectPageService.getEntityCount(where);

			page.setTotalCount(entityCount);
			page.setData(findEntityList);

			model.addAttribute("page", page);

			model.addAttribute("projectId", projectId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/modules/projectPage/list";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {

		try {

			projectPageService.deleteEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}
