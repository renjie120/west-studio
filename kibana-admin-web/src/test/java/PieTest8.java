import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.series.Pie;

public class PieTest8 {

	@Test
	public void test() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Chrome", 80);
		map.put("Firefox", 160);
		map.put("Safari", 320);
		map.put("IE9+", 640);
		map.put("IE8-", 1280);
		
		String[] sdata = new String[map.size()];

		int i = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			sdata[i] = entry.getKey();
			i++;
		}

		EnhancedOption option = new EnhancedOption();

		option.title().text("浏览器占比变化").subtext("纯属虚构");
		option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
		option.legend().x(X.right).orient(Orient.vertical).data(sdata);

		Pie pie = getPie(map).center("50%", "45%").radius("50%");

		pie.label().normal().show(true).formatter("{b}{c}({d}%)");
		option.series(pie);

		option.exportToHtml("pie7-k3.html");
		option.view();
	}

	/**
	 * 获取饼图数据
	 *
	 * @param idx
	 * @return
	 */
	public Pie getPie(Map<String, Object> map) {
		PieData[] pdata = new PieData[map.size()];

		int i = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			pdata[i] = new PieData(entry.getKey(), entry.getValue());
			i++;
		}

		return new Pie().name("浏览器（数据纯属虚构）").data(pdata);
	}
}
