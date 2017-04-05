 package com.jd.kibana.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.entity.ReportForm;
import com.jd.kibana.repository.ReportFormDao;


@Service
public class ReportFormService  extends SingleBaseService<ReportForm, Long>{
	@Autowired
	private ReportFormDao dao;
	
	public ReportFormDao getDao() {
		return dao;
	}

}
 
								 
								