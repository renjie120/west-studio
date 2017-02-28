package com.jd.kibana.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.entity.Project;
import com.jd.kibana.repository.ProjectDao;

@Service
public class ProjectService extends SingleBaseService<Project, Long> {
	@Autowired
	private ProjectDao dao;

	public ProjectDao getDao() {
		return dao;
	}

	// select * from project p left join project_user pu on p.id=pu.project_id
	// where username='w1' and p.statux=1

	public List<Map<String, Object>> getMyProjectList(String username) {
		String sql = "select p.* from project p left join project_user pu on p.id=pu.project_id where username='"+username+"' and p.statux=1";
		List<Map<String, Object>> queryListMap = dao.queryListMap(sql);
		
		return queryListMap;
	}

}
