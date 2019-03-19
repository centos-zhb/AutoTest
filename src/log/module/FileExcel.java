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
	
	//�����ļ���ȡ�û�������
	public String username() {
		// TODO Auto-generated method stub
		try {
			String fileName = "./test.xls";  //Excel �ļ����·�����û����������ļ�����
			File file = new File(fileName);
			Workbook wb = Workbook.getWorkbook(file); //��ȡ�ļ�
			Sheet sheet = wb.getSheet(0);  //��ȡ�ļ���sheet
			Cell cell = sheet.getCell(0,0);  //��2����Ԫ��
			String username = cell.getContents();  //��ȡ��һ����Ԫ���ֵ���ظ��û���
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
	
	//�����ļ���ȡ�������
	public String password() {
		try {
			String fileName = "./test.xls";  //Excel �ļ����·�����û����������ļ�����
			File file = new File(fileName);
			Workbook wb = Workbook.getWorkbook(file); //��ȡ�ļ�
			Sheet sheet = wb.getSheet(0);  //��ȡ�ļ���sheet
			Cell cell = sheet.getCell(1,0);  //��2����Ԫ��
			String password = cell.getContents();  //��ȡ�ڶ�����Ԫ���ֵ���ظ�����
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