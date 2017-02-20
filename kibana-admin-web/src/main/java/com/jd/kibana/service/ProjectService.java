 package com.jd.kibana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.entity.Project;
import com.jd.kibana.repository.ProjectDao;



@Service
public class ProjectService  extends SingleBaseService<Project, Long>{
	@Autowired
	private ProjectDao dao;
	
	public ProjectDao getDao() {
		return dao;
	}

}
 
								