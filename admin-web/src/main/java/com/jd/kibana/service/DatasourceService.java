package com.jd.kibana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.entity.Datasource;
import com.jd.kibana.repository.DatasourceDao;

@Service
public class DatasourceService extends SingleBaseService<Datasource, Long> {
	@Autowired
	private DatasourceDao dao;

	public DatasourceDao getDao() {
		return dao;
	}
	


}
