package com.jd.kibana.repository;

import org.springframework.stereotype.Repository;
import com.jd.kibana.entity.ProjectUser;
import com.bucuoa.west.orm.app.extend.ISingleBaseDao;
import com.bucuoa.west.orm.app.extend.spring.SpringSingleBaseDao;

@Repository
public class ProjectUserDao extends SpringSingleBaseDao<ProjectUser, Long>
		implements ISingleBaseDao<ProjectUser, Long> {

}
