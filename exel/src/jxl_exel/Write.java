package jxl_exel;

import java.io.File;
import jxl.*;
import jxl.format.Alignment;
import jxl.write.*;

public class Write {
	
	public static void main(String[] args) {
		
		WritableWorkbook workbook	= null;
		WritableSheet sheet			= null;
		Label label					= null;
		File file					= new File("new.xls");
		
		try {
			workbook = Workbook.createWorkbook(file);
			workbook.createSheet("sheet1", 0);	// 시트이름, 순번
			sheet = workbook.getSheet(0);		// 순번으로 가져옴
			
			// optional
			sheet.setColumnView(0, 20);		// Cell 넒이 (column index, column width)
			sheet.mergeCells(0, 0, 0, 1);	// Cell 병합 (시작 column, 시작 row, 끝 column, 끝 row)
			
			// 임의 데이터 삽입
			for(int row = 0; row < 3; row++) {
				for(int col = 0; col < 5; col++) {
					label = new Label(col, row, "contents");
					sheet.addCell(label);
				}
			}
			
			// execute
			workbook.write();
			workbook.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
