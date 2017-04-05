package com.jd.kibana.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bucuoa.west.orm.app.common.Expression;
import com.bucuoa.west.orm.app.common.WPage;
import com.jd.kibana.JdbcDataGather;
import com.jd.kibana.entity.DataTable;
import com.jd.kibana.entity.DataView;
import com.jd.kibana.entity.Datasource;
import com.jd.kibana.service.DataTableService;
import com.jd.kibana.service.DatasourceService;

/**
 * 数据表
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "/dataTable")
public class DataTableController {
	@Autowired
	private DatasourceService datasourceService;
	@Autowired
	private DataTableService dataTableService;

	/**
	 * 报表展示
	 */
	@RequestMapping(value = "/tableShow")
	public String datashow( Model model, Long id) {
		try {
			DataTable table = dataTableService.findEntityById(id);
			Long datasourceId = table.getDatasourceId();
			
			Datasource ds = datasourceService.findEntityById(datasourceId);
			JdbcDataGather gather = new JdbcDataGather(ds);
			List<Map<String, Object>> list = gather.getData(table.getScript());
			List<String> metaData = gather.getMetaData(table.getScript());
			
			model.addAttribute("list", list);
			model.addAttribute("metaDatas", metaData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/table_show";
	}

}
