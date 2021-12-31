package export;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import entities.ToDo;
import entities.User;
import enums.priorityType;
import enums.stateType;
import interfaces.exportDocument;
import lombok.AllArgsConstructor;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
public class toPdf implements exportDocument {

    private User user;

    @Override
    public void export() {
       File list = new File("list.pdf");
       try (PdfWriter pdfWriter = new PdfWriter(list)) {
           ArrayList<User> a = createDataUser();
           ArrayList<ToDo> b = createDataToDo();
           PdfDocument pdfDocument = new PdfDocument(pdfWriter);
           Document documento = new Document(pdfDocument);
           Paragraph p = new Paragraph(String.valueOf(a));
           Paragraph c = new Paragraph(String.valueOf(b));
           documento.add(p);
           documento.add(c);

           System.out.println("PDF creado!");
       } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage());
       } catch (IOException ex) {
           System.out.println(ex.getMessage());
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
