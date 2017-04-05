 package com.jd.kibana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.entity.ProjectPage;
import com.jd.kibana.repository.ProjectPageDao;


@Service
public class ProjectPageService  extends SingleBaseService<ProjectPage, Long>{
	@Autowired
	private ProjectPageDao dao;
	
	public ProjectPageDao getDao() {
		return dao;
	}

}
 
								 
								