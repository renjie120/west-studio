package com.jd.kibana.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bucuoa.west.orm.app.common.Expression;
import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.entity.ProjectUser;
import com.jd.kibana.repository.ProjectUserDao;

@Service
public class ProjectUserService extends SingleBaseService<ProjectUser, Long> {
	@Autowired
	private ProjectUserDao dao;

	public ProjectUserDao getDao() {
		return dao;
	}
	
	public boolean checkProjectMember(String username,Long id)
	{
		List<Expression> where = new ArrayList<Expression>();
		Expression ex = new Expression("project_id",id);
		Expression ex2 = new Expression("username","'"+username+"'");
		
		where.add(ex2);
		where.add(ex);;
		
		List<ProjectUser> data = getDao().findEntityList(where, null);
		if(data != null && data.size() > 0)
		{
			return true;
		}
		
		return false;
	}

}
