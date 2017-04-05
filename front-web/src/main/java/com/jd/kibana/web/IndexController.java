package com.jd.kibana.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.kibana.service.ProjectService;
import com.jd.common.web.LoginContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 我的项目
	 */
	@RequestMapping(value = "")
	public String index(Model model) {
		
		try {
			
			LoginContext loginContext = LoginContext.getLoginContext();
			
			String username = loginContext.getPin();
			logger.info(username+"==>登录");
			
			List<Map<String, Object>> myProjectList = projectService.getMyProjectList(username);
			model.addAttribute("projectlist",myProjectList);
			model.addAttribute("username",username);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "home";
	}

}