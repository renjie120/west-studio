 package com.jd.kibana.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.JdbcDataGather;
import com.jd.kibana.entity.DataTable;
import com.jd.kibana.entity.Datasource;
import com.jd.kibana.entity.ReportForm;
import com.jd.kibana.repository.DataTableDao;
import com.jd.kibana.repository.DatasourceDao;
import com.jd.kibana.repository.ReportFormDao;


@Service
public class ReportFormService  extends SingleBaseService<ReportForm, Long>{
	@Autowired
	private ReportFormDao dao;
	@Autowired
	private DataTableDao talbeDao;
	@Autowired
	private DatasourceDao datasourceDao;
	
	public ReportFormDao getDao() {
		return dao;
	}
	
	public String getNumberData(Long id)
	{
		String result = "0";
		try {
			ReportForm form = getDao() .findEntityById(id);
			
			DataTable table = talbeDao.findEntityById( form.getTableId());
			
			String script = table.getScript();
			Datasource datasource =  null;
			
			datasource = datasourceDao.findEntityById(table.getDatasourceId());
			JdbcDataGather gather = new JdbcDataGather(datasource);
			Object singleData = gather.getSingleData(script);
			result = singleData.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}

}
 
								 
								