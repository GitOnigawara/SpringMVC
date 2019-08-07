package poi_exel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class Write {

	public void inputData() throws Exception {
		try {
			String filePath			= "./";
			String fileName			= "poi-write.xls";
			FileOutputStream fos	= setFile(filePath, fileName);
			HSSFWorkbook workbook	= setExcel(fileName);
			
			workbook.write(fos);
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private FileOutputStream setFile(String filePath, String fileName) throws FileNotFoundException {
		File dir = new File(filePath);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		return new FileOutputStream(filePath + fileName);
	}
	
	private HSSFWorkbook setExcel(String fileName) throws IOException {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = null;
		HSSFCell cell = null;
		
		// sheet setting
		sheet.setGridsPrinted(true);
		sheet.setFitToPage(true);
		sheet.setDisplayGuts(true);
		
		// sheet name
		workbook.setSheetName(0, "sheet1");
		
		// data hard coding
		String[] title1		= {"no"	, "name"	, ""};
		String[] title2		= {"no"	, "first"	, "last"};
		String[] contents	= {""	, "gildong"	, "hong"};
		int[] cellWidth		= {6	, 20		, 20};
		short width = 256;
		
		row = sheet.createRow(0);
		row.setHeight((short) 500); // row height
		for(int i = 0; i < title1.length; i++) {
			sheet.setColumnWidth(i, cellWidth[i] * width);
			cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(title1[i]));
			if(i == 1) {
				sheet.addMergedRegion(new CellRangeAddress(0, 0, i, i + 1));
			}
		}
		
		row = sheet.createRow(1);
		row.setHeight((short)500); // row height
        for(int i = 0;	 i < title2.length;	i++){
        	sheet.setColumnWidth(i, (cellWidth[i] * width));
        	cell = row.createCell((i));
        	cell.setCellValue(new HSSFRichTextString(title2[i]));
        }
        
        row = sheet.createRow(2);
        row.setHeight((short)500); // row height
        for(int i = 0;	 i < contents.length;	i++){
        	sheet.setColumnWidth(i, (cellWidth[i] * width));
        	cell = row.createCell((i));
        	if(i==0) {
        		cell.setCellValue(new HSSFRichTextString(String.valueOf(i)));
        	} else {
        		cell.setCellValue(new HSSFRichTextString(contents[i]));
        	}
        }
        
        // print setting
        HSSFPrintSetup hps = sheet.getPrintSetup();
        hps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);
        hps.setLandscape(false);
        hps.setScale((short)100);
        HSSFFooter footer = sheet.getFooter();
        footer.setCenter(HSSFFooter.page() + " / " + HSSFFooter.numPages());
        
        // sheet margin
        sheet.setMargin(HSSFSheet.TopMargin, 0.6);
        sheet.setMargin(HSSFSheet.BottomMargin, 0.6);
        sheet.setMargin(HSSFSheet.LeftMargin, 0.6);
        sheet.setMargin(HSSFSheet.RightMargin, 0.6);
        
		return workbook;
	}
	
	public static void main(String[] args){
    	
    	Write write = new Write();
    	
    	try {
    		write.inputData();	
		} catch (Exception e) {
			System.out.println("error!!");
			e.printStackTrace();
		}
    }
}
