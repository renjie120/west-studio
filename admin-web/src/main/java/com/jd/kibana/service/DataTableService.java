 package com.jd.kibana.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.entity.DataTable;
import com.jd.kibana.repository.DataTableDao;


@Service
public class DataTableService  extends SingleBaseService<DataTable, Long>{
	@Autowired
	private DataTableDao dao;
	
	public DataTableDao getDao() {
		return dao;
	}

}
 
								 
								