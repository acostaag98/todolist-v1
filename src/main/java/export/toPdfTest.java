package export;


import alerts.alert;
import entities.ToDo;
import entities.User;
import enums.priorityType;
import enums.stateType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class toPdfTest {

    public static void main(String[] args) throws IOException {
        try{
            alert s1 = new alert(); // create obj alert
            Workbook workbook = new XSSFWorkbook(); // for .xsl use new HSSF
            //Create sheet
            Sheet sh = workbook.createSheet("List");
            // Create top row with column headings
            String[] columnHeadings = {" ",
                    "Name",
                    "Email",
                    "Title",
                    "Description",
                    "Priority",
                    "Init Date",
                    "End Date",
                    "State"};

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
            ArrayList<User> a = createDataUser();
            int rownum = 1;
            int rownumTodo = 2;
            for (User i : a) {
                Row row = sh.createRow(rownum++);
                row.createCell(1).setCellValue(i.getName());
                row.createCell(2).setCellValue(i.getEmail());
            }
            ArrayList<ToDo> b = createDataToDo();
            for (ToDo i : b) {
                Row row = sh.createRow(rownumTodo++);
                row.createCell(1).setCellValue(" ");
                row.createCell(2).setCellValue(i.getTitle());
                row.createCell(3).setCellValue(i.getDescription());
                row.createCell(4).setCellValue(i.getPriority().getValue());
                row.createCell(5).setCellValue(i.getInitDate());
                row.createCell(6).setCellValue(i.getEndDate());
                row.createCell(7).setCellValue(i.getState().getValue());
            }
            //Autosize colums
            for (int i = 0; i<columnHeadings.length; i++) {
                sh.autoSizeColumn(i);
            }
            //Write the output file
            FileOutputStream fileout = new FileOutputStream("list.xlsx");
            workbook.write(fileout);
            fileout.close();
            workbook.close();
            s1.setVisible(true); // show alert

            System.out.println("Excel creado!");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static ArrayList<User> createDataUser() {
        ArrayList<User> a = new ArrayList();
        a.add(new User("11599959", "Agustín Acosta", "acostaag98@gmail.com", new ArrayList<ToDo>()));
        return a;
    }
    private static ArrayList<ToDo> createDataToDo() {
        ArrayList<ToDo> b = new ArrayList();
        b.add(new ToDo(1,"p1","p1", priorityType.LOW, new Date(11, 11, 11),
                new Date(11, 11, 11), stateType.IN_PROCESS));
        b.add(new ToDo(2,"p1","p1", priorityType.LOW, new Date(11, 11, 11),
                new Date(11, 11, 11), stateType.IN_PROCESS));
        b.add(new ToDo(3,"p1","p1", priorityType.LOW, new Date(11, 11, 11),
                new Date(11, 11, 11), stateType.IN_PROCESS));
        return b;
    }
}
