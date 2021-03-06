package export;

import entities.ToDo;
import entities.User;
import interfaces.exportDocument;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileOutputStream;

@AllArgsConstructor
public class toExcel implements exportDocument {

    private User user;
    private static final Logger logger = LogManager.getLogger(toExcel.class.getClass());

    @Override
    public void export() {
        try{
            Workbook workbook = new XSSFWorkbook(); // for .xsl use new HSSF
            //Create sheet
            Sheet sh = workbook.createSheet("List");
            // Create top row with column headings
            String[] columnHeadings = {"ToDo List", "Title", "Description", "Priority", "State"};
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.BLACK.index);
            //Create  a CellStyle with the font
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            //Create the header row
            Row headerRow = sh.createRow(0);
            //Iterate over the column heading to create columns
            for(int i = 0; i< columnHeadings.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
                cell.setCellStyle(headerStyle);
            }
            //Fill data
            int rownum = 1;
            for (ToDo i : this.user.getToDos()) {
                Row row = sh.createRow(rownum++);
                row.createCell(1).setCellValue(i.getTitle());
                row.createCell(2).setCellValue(i.getDescription());
                row.createCell(3).setCellValue(i.getPriority().getValue());
                row.createCell(4).setCellValue(i.getState().getValue());
            }

            //Autosize colums
            for (int i = 0; i<columnHeadings.length; i++) {
                sh.autoSizeColumn(i);
            }
            //Write the output file
            FileOutputStream fileout = new FileOutputStream("Exports/list.xlsx");
            workbook.write(fileout);
            fileout.close();
            workbook.close();
            logger.info("Event export excel: Successful");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Export excel: Error : "+ex);
        }
    }
}


