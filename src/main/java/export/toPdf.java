package export;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class toPdf {
    public static void main(String[] args) throws IOException {
        File list = new File("list.pdf");
        String archivo = new String("asdasdasdasdasdasd");
        try (PdfWriter pdfWriter = new PdfWriter(list)) {
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document documento = new Document(pdfDocument);
            Paragraph p = new Paragraph(archivo);
            documento.add(p);


            pdfDocument.close();
            documento.close();

            System.out.println("PDF creado!");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
