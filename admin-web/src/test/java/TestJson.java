import java.util.ArrayList;
import java.util.List;

import com.jd.kibana.PageComponnet;
import com.thinkgem.jeesite.modules.sys.utils.JSONUtils;

public class TestJson {

	public static void main(String[] args) {
		String componnets = createJson();
		
		try {
			List<PageComponnet> list = JSONUtils.json2list(componnets,PageComponnet.class);
			for(PageComponnet com : list)
			{
				System.out.println(com.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		
	}

	private static String createJson() {
		List<PageComponnet> dataps = new ArrayList<PageComponnet>();
		PageComponnet p = new PageComponnet();
		p.setId(11l);
		p.setName("我的表单");
		p.setStyle("");
		p.setType("chart");
		
		PageComponnet p2 = new PageComponnet();
		p2.setId(12l);
		p2.setName("我的表单2");
		p2.setStyle("");
		p2.setType("chart");
		
		dataps.add(p);
		dataps.add(p2);
		String jsonString = "";
		
		try {
			 jsonString =  JSONUtils.obj2json(dataps);
			
			System.out.println(jsonString);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}

}
