package export;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import entities.ToDo;
import entities.User;

import interfaces.exportDocument;
import lombok.AllArgsConstructor;


import javax.swing.*;
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

            System.out.println("PDF creado!");
            JOptionPane.showMessageDialog(null, "The ToDo List has been exported successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

