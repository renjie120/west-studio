import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.thinkgem.jeesite.common.utils.excel.ImportExcel;

public class GenerateTestData {

	public static void main(String[] args) {
		File file = new File("d://temp/53_fdm_4957725.xls");
		try {
			ImportExcel importx= new ImportExcel(file,1);
			int dataRowNum = importx.getLastDataRowNum();

			System.out.println("total:"+dataRowNum);
			
		for(int i = 0; i < dataRowNum; i ++)
			{
			
			Row row = importx.getRow(i);
			short lastCellNum = row.getLastCellNum();
			StringBuffer values = new StringBuffer();
			values.append("INSERT INTO `kibana_data`.`bad_comment_data` (`sku_id`, `first_category`, `second_category`, `third_category`, `brand_id`, `brand_name`, `reply_count`, `one_count`, `two_count`, `three_count`, `four_count`, `five_count`, `gernal_deal_count`, `poor_deal_count`, `showorder_count`,  `days`, `create_date`, `modify_date`) ");
			values.append(" values(");
			for(int j = 0; j < lastCellNum; j ++)
			{
				Cell cell = row.getCell(j);
				if(j == 5 || j == 15)
				{
					values.append("'").append(cell.getStringCellValue()).append("'");
				}else
				{
					try {
						values.append(cell.getStringCellValue());
					} catch (Exception e) {
						System.out.println(j+":"+row.getRowNum());
						e.printStackTrace();
					}
				}
				
				if(j != (lastCellNum-1))
				{
					values.append(",");
				}else
				{
					values.append(",now(),now());\r\n");
				}

			}
			FileUtils.writeStringToFile(new File("d:/temp/test_data2.txt"), values.toString(),true);
			
//			System.out.println(values.toString());

//			System.out.println("total cell:"+lastCellNum);
			
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
