 package com.jd.kibana.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 
								 
								