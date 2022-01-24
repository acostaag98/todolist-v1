package export;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import entities.ToDo;
import entities.User;

import interfaces.exportDocument;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@AllArgsConstructor
public class toPdf implements exportDocument {

    private User user;
    private static final Logger logger = LogManager.getLogger(toPdf.class.getClass());

    @Override
    public void export() {
        File list = new File("list.pdf");
        try (PdfWriter pdfWriter = new PdfWriter(list)) {
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document documento = new Document(pdfDocument);
            for (ToDo todo : this.user.getToDos() ) {
                Paragraph setTitle = new Paragraph("Tarea a realizar:");
                Paragraph title = new Paragraph(String.valueOf(todo.getTitle()));
                Paragraph setDescription = new Paragraph("Description: ");
                Paragraph description = new Paragraph(String.valueOf(todo.getDescription()));
                Paragraph setPriority = new Paragraph("Priority: ");
                Paragraph priority = new Paragraph(String.valueOf(todo.getPriority()));
                Paragraph setStatus = new Paragraph("State:");
                Paragraph status = new Paragraph(String.valueOf(todo.getState()));
                Paragraph space = new Paragraph("---------------------------------");

                documento.add(setTitle);
                documento.add(title);
                documento.add(setDescription);
                documento.add(description);
                documento.add(setPriority);
                documento.add(priority);
                documento.add(setStatus);
                documento.add(status);
                documento.add(space);
            }

            documento.close();

            JOptionPane.showMessageDialog(null, "The ToDo List has been exported successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            logger.info("Event export pdf: Successful");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            logger.error("Event export pdf: Error : "+ex);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            logger.error("Event export pdf: Error : "+ex);
        }
    }
}

