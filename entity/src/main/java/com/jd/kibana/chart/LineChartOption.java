package com.jd.kibana.chart;

import java.util.Arrays;
import java.util.List;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Symbol;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Line;

public class LineChartOption {
	
	public static void main(String[] arg)
	{
		Object[] legend = new Object[]{"邮件营销", "联盟广告", "直接访问", "搜索引擎"};
		List<Object> legendx = (List<Object>) Arrays.asList(legend);
		
		Object[] x = new Object[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
		List<Object> xx = (List<Object>) Arrays.asList(x);

		Object[] data = new Object[]{120, 132, 301, 134, 90, 230, 210};
		List<Object> datax = (List<Object>) Arrays.asList(data);

		String title = "邮件营销";
		String build = build(legendx,xx,datax,title);
		
		System.out.println(build);


	}

	public static String build(List<Object> legendx,List<Object> x,List<Object> data,String title) {

		Option option = new Option();
		option.title(title);
		option.tooltip().trigger(Trigger.axis);
		option.legend(legendx.toArray());
		option.toolbox().show(true);
		option.calculable(true);
		option.xAxis(new CategoryAxis().boundaryGap(false).data(x.toArray()));
		option.yAxis(new ValueAxis());
		option.series(new Line().smooth(true).name("").stack("").symbol(Symbol.none).data(data.toArray()));

		return GsonUtil.format(option);
	}
	
	

}
