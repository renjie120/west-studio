package com.jd.kibana.chart;

import java.util.Arrays;
import java.util.List;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Bar;

public class BarChartOption {
	public static void main(String[] arg)
	{
		Object[] legend = new Object[]{"邮件营销", "联盟广告", "直接访问", "搜索引擎"};
		List<Object> legendx = (List<Object>) Arrays.asList(legend);
		
		Object[] x = new Object[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
		List<Object> xx = (List<Object>) Arrays.asList(x);

		Object[] data = new Object[]{120, 132, 301, 134, 90, 230, 210};
		List<Object> datax = (List<Object>) Arrays.asList(data);

		String title = "ECharts例子个数统计";
		String build = build(xx,datax,title);
		
		System.out.println(build);


	}

	public static String build(List<Object> x,List<Object> data,String title) {

		Option option = new Option();
		
        option.title().text(title).subtext("").x(X.center);
        option.tooltip().trigger(Trigger.item);
        option.calculable(true);
        option.grid().borderWidth(0).y(80).y2(60);
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
        option.xAxis(new CategoryAxis().data(x.toArray()));
        option.yAxis(new ValueAxis().show(false));

        Bar bar = new Bar(title);
        bar.itemStyle().normal().color("function(params) {" +
                "                        var colorList = [" +
                "                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'," +
                "                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD'," +
                "                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'" +
                "                        ];" +
                "                        return colorList[params.dataIndex]" +
                "                    }")
                .label().show(true).position(Position.top).formatter("{b}\n{c}");
        bar.data(data.toArray());

        option.series(bar);

		return GsonUtil.format(option);
	}
}
