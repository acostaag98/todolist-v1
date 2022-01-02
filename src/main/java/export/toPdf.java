package export;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import entities.User;
import interfaces.exportDocument;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


@AllArgsConstructor
public class toPdf implements exportDocument {

    private User user;

    @Override
    public void export() {
       File list = new File("list.pdf");
       try (PdfWriter pdfWriter = new PdfWriter(list)) {
           PdfDocument pdfDocument = new PdfDocument(pdfWriter);
           Document documento = new Document(pdfDocument);
           Paragraph p = new Paragraph(String.valueOf(this.user.getName()));

           documento.add(p);

           System.out.println("PDF creado!");
       } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage());
       } catch (IOException ex) {
           System.out.println(ex.getMessage());
       }
   }


}
