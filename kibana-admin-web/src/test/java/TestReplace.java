
public class TestReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String script = "select count(*) as y,case when sex = 0 then '女'   when sex = 1 then '男' else '未知' end x  from test group by sex";
		
		String replace = script.replace("'", "\\'");
		System.out.println(replace);
	}

}
