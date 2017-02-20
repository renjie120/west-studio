package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bucuoa.west.orm.app.common.Expression;
import com.bucuoa.west.orm.app.common.WPage;
import com.jd.kibana.entity.Project;
import com.jd.kibana.service.ProjectService;

/**
 * 项目
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/add")
	public String add(RedirectAttributes redirectAttributes,Model model, Long id) {

		if(id != null)
		{
			Project entity2 =  null;
			try {
				entity2 = projectService.findEntityById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("entity", entity2);
		}
		return "/modules/project/projectAdd";
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(RedirectAttributes redirectAttributes, Project entity) {
		
		try {
			
			if(entity !=null && entity.getId() != null)
			{
				projectService.updateEntity(entity);
			}else{
				projectService.saveEntity(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		return "redirect:list";
	}

	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model, WPage page) {

		try {
			List<Expression> es = new ArrayList<Expression>();
			List<Project> findEntityList = projectService.findEntityList(es, page);
			 WPage page2 = new  WPage();
			 page2.setData(findEntityList);
			 
			 int entityCount = projectService.getEntityCount(es);
			 
			 page2.setTotalCount(entityCount);
			 
			 model.addAttribute("page", page2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/modules/project/projectList";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {

		try {

			boolean deleteEntityById = projectService.deleteEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}
