package export;

import entities.User;
import interfaces.exportDocument;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

@AllArgsConstructor
public class toExcel implements exportDocument {

    private User user;

    @Override
    public void export() {
        try{
            Workbook workbook = new XSSFWorkbook(); // for .xsl use new HSSF
            //Create sheet
            Sheet sh = workbook.createSheet("Invoices");
            // Create top row with column headings
            String[] columnHeadings = {"Item Id", "Item Name", "Qty", "Item price"};
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeight((short) 12);
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
            ArrayList<User> a = createData();
            int rownum = 1;
            for (User i : a) {
                Row row = sh.createRow(rownum++);
                row.createCell(1).setCellValue(i.getName());
                row.createCell(2).setCellValue(i.getEmail());
                row.createCell(3).setCellValue((RichTextString) i.getToDos());

            }
            //Autosize colums
            for (int i = 0; i<columnHeadings.length; i++) {
                sh.autoSizeColumn(i);
            }
            Sheet sh2 = workbook.createSheet("Second");
            //Write the output file
            FileOutputStream fileout = new FileOutputStream("list.xlsx");
            workbook.write(fileout);
            fileout.close();
            workbook.close();
            System.out.println("Excel creado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<User> createData() {
        ArrayList<User> a = new ArrayList();
        a.add(new User("11599959", "Agustín Acosta", "acostaag98@gmail.com", new ArrayList<>()));
        return a;
    }
}


