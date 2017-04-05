package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.Date;
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
import com.jd.kibana.entity.ProjectUser;
import com.jd.kibana.service.ProjectUserService;

/**
 * 项目成员
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/projectUser")
public class ProjectUserController {

	@Autowired
	private ProjectUserService projectUserService;

	@RequestMapping(value = "/add")
	public String add(RedirectAttributes redirectAttributes, ProjectUser entity) {

		return "/modules/member/add";
	}

	@RequestMapping(value = "/saveentity", method = RequestMethod.POST)
	public String save(RedirectAttributes redirectAttributes, ProjectUser entity) {

		try {

			if (entity != null && entity.getId() != null) {
				projectUserService.updateEntity(entity);
			} else {
				entity.setStatux(1);
				entity.setCreateDate(new Date());
				projectUserService.saveEntity(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list?projectId=" + entity.getProjectId();
	}

	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model, WPage page, Long projectId) {

		try {

			List<Expression> where = new ArrayList<Expression>();
			Expression ex = new Expression("project_id", projectId);
			where.add(ex);

			List<ProjectUser> data = projectUserService.findEntityList(where, page);

			int entityCount = projectUserService.getEntityCount(where);

			page.setData(data);
			page.setTotalCount(entityCount);

			model.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/modules/member/list";
	}

	@RequestMapping(value = "/delete")
	public String delete(RedirectAttributes redirectAttributes, @RequestParam("id") Long id) {
		ProjectUser user = null;
		try {
			user = projectUserService.findEntityById(id);
			projectUserService.deleteEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addAttribute("message", "删除成功!");
		return "redirect:list?projectId="+user.getProjectId();
	}

}
