package jxl_exel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.*;
import jxl.read.biff.BiffException;

public class Read {
	
	public static void main(String[] args) {
		Workbook workbook	= null;
		Sheet sheet			= null;
		Cell cell			= null;
		String file			= "new.xls";
		
		try {
			workbook = Workbook.getWorkbook(new File(file));	// 파일 읽기
			
			if(workbook != null) {
//				sheet = workbook.getSheets(); 파일 안의 sheet들을 배열로 리턴
				sheet = workbook.getSheet(0); // sheet 이름 또는 인덱스 번호로 가져옴
			}
			
			if(sheet != null) {
				// 셀 단위로 접근		Cell a1 = sheet.getCell(column index, row index);
				// 해당 셀 내용		String a1Data = a1.getContents();
				
				int rlen = sheet.getRows();
				int clen = sheet.getColumns();
				
				for(int row = 0; row < rlen; row++) {
					for(int col = 0; col < clen; col++) {
						cell = sheet.getCell(col, row);
						System.out.printf("%2s ", cell.getContents());
					}
					System.out.println("");
				}
			}
		} catch(BiffException be) {
			be.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
