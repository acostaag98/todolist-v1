package export;

import entities.ToDo;
import entities.User;
import interfaces.exportDocument;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

@AllArgsConstructor
public class toTxt implements exportDocument {

    private User user;
    private static final Logger logger = LogManager.getLogger(toTxt.class.getClass());

    @Override
    public void export() throws IOException {

        try{
            FileWriter list = new FileWriter("Exports/list.txt");

            for (ToDo todo : this.user.getToDos()) {
                list.write("Title: ");
                list.write(todo.getTitle());
                list.write("\r\n");
                list.write("Description: ");
                list.write(todo.getDescription());
                list.write("\r\n");
                list.write("Priority: ");
                list.write(todo.getPriority().getValue());
                list.write("\r\n");
                list.write("State: ");
                list.write(todo.getState().getValue());
                list.write("\r\n");
                list.write("-------------------------------");
                list.write("\r\n");
            }
            list.close();
            logger.info("Event export txt: Successful");
        }catch (IOException ex){
            logger.error("Event export txt: Error : "+ex);
        }

    }

}
