 package com.jd.kibana.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.entity.DataView;
import com.jd.kibana.repository.DataViewDao;


@Service
public class DataViewService  extends SingleBaseService<DataView, Long>{
	@Autowired
	private DataViewDao dao;
	
	public DataViewDao getDao() {
		return dao;
	}

}
 
								 
								