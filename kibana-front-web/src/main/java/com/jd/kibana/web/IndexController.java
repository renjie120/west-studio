package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bucuoa.west.orm.app.common.Expression;
import com.jd.kibana.entity.Project;
import com.jd.kibana.service.ProjectService;

/**
 * 数据源
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {
	@Autowired
	private ProjectService projectService;

	/**
	 * 我的项目
	 */
	@RequestMapping(value = "")
	public String index(Model model) {
		
		try {
			List<Expression> where = new ArrayList<Expression>();
			
			Expression ex2 = new Expression("statux",1);
			where.add(ex2);

			List<Project> projectlist = projectService.findEntityList(where, null);
			
			model.addAttribute("projectlist",projectlist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "home";
	}

}