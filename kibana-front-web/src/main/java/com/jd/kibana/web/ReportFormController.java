package com.jd.kibana.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bucuoa.west.orm.app.common.WPage;
import com.jd.kibana.entity.ReportForm;
import com.jd.kibana.service.ReportFormService;
/**
 * 报表
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/projectForm")
public class ReportFormController {

	@Autowired
	private ReportFormService reportFormService;
	
	@RequestMapping(value = "/add")
	public String add(RedirectAttributes redirectAttributes,ReportForm entity) {
		

		return "/modules/reportForm/add";
	}
	
	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes,ReportForm entity) {
		
	
		
		
		try {
			reportFormService.saveEntity(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}
	

	
	@RequestMapping(value = "/saveapi")
	@ResponseBody
	public void save2(RedirectAttributes redirectAttributes,ReportForm entity) {
		
	
	
		try {
			 reportFormService.saveEntity(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,Model model,WPage page) {
		
		try {
			
		//	WPage entityPage = reportFormService.getEntityPage(request);
			
		//	model.addAttribute("page", entityPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "/modules/reportForm/list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {
		
		try {
			
			boolean deleteEntityById = reportFormService.deleteEntityById(id);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

} 
								 
								 
								