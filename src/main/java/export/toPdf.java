package export;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.ToDo;
import entities.User;
import interfaces.exportDocument;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@AllArgsConstructor
public class toPdf implements exportDocument {
    com.itextpdf.text.Document documento;
    FileOutputStream archivo;
    com.itextpdf.text.Paragraph titulo;
    User user;
    private static final Logger logger = LogManager.getLogger(toPdf.class.getClass());

    public toPdf(User user){
        this.user = user;
        documento = new Document();
        titulo = new com.itextpdf.text.Paragraph("ToDos");
    }

    @Override
    public void export() {
        try {
            archivo = new FileOutputStream("Exports/ToDos.pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1);
            documento.add(titulo);
            documento.add(new Paragraph("Nombre: " + this.user.getName()));
            documento.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            PdfPCell name = new PdfPCell(new Phrase("Title"));
            name.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell prioriry = new PdfPCell(new Phrase("Priority"));
            prioriry.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell deadLine = new PdfPCell(new Phrase("DeadLine"));
            deadLine.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell status = new PdfPCell(new Phrase("Status"));
            status.setBackgroundColor(BaseColor.LIGHT_GRAY);

            table.addCell(name);
            table.addCell(prioriry);
            table.addCell(deadLine);
            table.addCell(status);

            for (ToDo toDo: this.user.getToDos()) {
                table.addCell(toDo.getTitle());
                table.addCell(toDo.getPriority().toString());
                table.addCell(toDo.getDate_range().getEndDate().toString());
                table.addCell(toDo.getState().toString());
            }

            documento.add(table);
            documento.add(Chunk.NEWLINE);
            documento.close();
            logger.info("Event export Pdf: Successful");
        } catch (DocumentException ex) {
            ex.printStackTrace();
            logger.error("Export Pdf: Error : "+ex);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            logger.error("Export Pdf: Error : "+ex);
        }
    }
}

