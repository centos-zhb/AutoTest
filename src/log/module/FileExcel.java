package log.module;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import logo.log.SelLogger;

public class FileExcel {
	private static final SelLogger logger = SelLogger.getLogger(FileExcel.class);
	
	//根据文件获取用户名的类
	public String username() {
		// TODO Auto-generated method stub
		try {
			String fileName = "./test.xls";  //Excel 文件相对路径，用户名参数化文件数据
			File file = new File(fileName);
			Workbook wb = Workbook.getWorkbook(file); //获取文件
			Sheet sheet = wb.getSheet(0);  //获取文件的sheet
			Cell cell = sheet.getCell(0,0);  //第2个单元格
			String username = cell.getContents();  //获取第一个单元格的值返回给用户名
			return username;
		}catch (BiffException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	//根据文件获取密码的类
	public String password() {
		try {
			String fileName = "./test.xls";  //Excel 文件相对路径，用户名参数化文件数据
			File file = new File(fileName);
			Workbook wb = Workbook.getWorkbook(file); //获取文件
			Sheet sheet = wb.getSheet(0);  //获取文件的sheet
			Cell cell = sheet.getCell(1,0);  //第2个单元格
			String password = cell.getContents();  //获取第二个单元格的值返回给密码
			return password;
		} catch (BiffException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}