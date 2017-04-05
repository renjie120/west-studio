package com.jd.kibana.chart;

import java.util.HashMap;
import java.util.Map;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Pie;

public class PipeChartOption {
	public static void main(String[] arg) {
		String title = "浏览器占比变化";
		String subTitle = "纯属虚构";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Chrome", 80);
		map.put("Firefox", 160);
		map.put("Safari", 320);
		map.put("IE9+", 640);
		map.put("IE8-", 1280);

		String build = build(title, subTitle, map);

		System.out.println(build);

	}

	public static String build(String title, String subTitle, Map<String, Object> map) {
		Object[] sdata = new Object[map.size()];

		int i = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			sdata[i] = entry.getKey();
			i++;
		}

		Option option = new Option();

		option.title().text(title).subtext(subTitle);
		option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
		option.legend().x(X.right).orient(Orient.vertical).data(sdata);

		Pie pie = getPie(map).center("50%", "45%").radius("50%");

		pie.label().normal().show(true).formatter("{b}{c}({d}%)");
		option.series(pie);

		return GsonUtil.format(option);
	}

	private static Pie getPie(Map<String, Object> map) {
		Object[] pdata = new Object[map.size()];

		int i = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			pdata[i] = new PieData(entry.getKey(), entry.getValue());
			i++;
		}

		return new Pie().name("").data(pdata);
	}
}
