 package com.jd.kibana.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucuoa.west.orm.app.extend.SingleBaseService;
import com.jd.kibana.JdbcDataGather;
import com.jd.kibana.chart.BarChartOption;
import com.jd.kibana.chart.LineChartOption;
import com.jd.kibana.chart.PipeChartOption;
import com.jd.kibana.entity.DataTable;
import com.jd.kibana.entity.Datasource;
import com.jd.kibana.entity.ReportChart;
import com.jd.kibana.repository.DataTableDao;
import com.jd.kibana.repository.DatasourceDao;
import com.jd.kibana.repository.ReportChartDao;


@Service
public class ReportChartService  extends SingleBaseService<ReportChart, Long>{
	@Autowired
	private ReportChartDao dao;
	@Autowired
	private DataTableDao talbeDao;
	@Autowired
	private DatasourceDao datasourceDao;
	
	public ReportChartDao getDao() {
		return dao; 
	}
	
	public String buildScript(Long id)
	{
		ReportChart chartx = null;
		try {
			chartx = dao.findEntityById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		Long dataTableId = chartx.getDataTableId();
		String chartType = chartx.getChartType();
		Datasource datasource =  null;
		DataTable table = null;
		try {
			table = talbeDao.findEntityById(dataTableId);
			
			datasource = datasourceDao.findEntityById(table.getDatasourceId());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 
		String	script = "";
		
    	JdbcDataGather gather = new JdbcDataGather(datasource);
		List<Map<String, Object>> list = gather.getData(table.getScript());

		if(chartType != null && chartType.equals("line"))
		{
			script = buildLineChart(chartx, list);
		}else if(chartType.equals("pipe"))
		{
			script = buildPipeChart(chartx, list);
		}else if(chartType.equals("bar"))
		{
			script = buildBarChart(chartx, list);
		}
		
		return script;
	}

	private String buildBarChart(ReportChart chartx, List<Map<String, Object>> list) {
		String script;

		List<Object> xlist = new ArrayList<Object>();
		List<Object> legend = new ArrayList<Object>();
		List<Object> ylist = new ArrayList<Object>();
		
		legend.add("x");
		
		for(Map<String, Object> map : list)
		{
			String x = (String)map.get("x");
			Object y = map.get("y");
			
			xlist.add(x);
			ylist.add(y);
		}
		
		script = BarChartOption.build(xlist, ylist, chartx.getName());

		return script;
	}
	
	private String buildLineChart(ReportChart chartx, List<Map<String, Object>> list) {
		String script;

		
		List<Object> xlist = new ArrayList<Object>();
		List<Object> legend = new ArrayList<Object>();
		List<Object> ylist = new ArrayList<Object>();
		
		legend.add("x");
		
		for(Map<String, Object> map : list)
		{
			String x = (String)map.get("x");
			Object y = map.get("y");
			
			xlist.add(x);
			ylist.add(y);
		}
		
		script = LineChartOption.build(legend,xlist, ylist, chartx.getName());

		return script;
	}
	
	private String buildPipeChart(ReportChart chartx,  List<Map<String, Object>> list) {
		Map<String, Object> data = new HashMap<String, Object>();
		for(Map<String, Object> map : list)
		{
			String x = (String)map.get("x");
			Object y = map.get("y");
			
			data.put(x, y);
		}
		
		String script = PipeChartOption.build(chartx.getName(), chartx.getSubtitle(), data);
		return script;
	}
}
 
								 
								