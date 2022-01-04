package export;

import entities.ToDo;
import entities.User;
import interfaces.exportDocument;
import lombok.AllArgsConstructor;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

@AllArgsConstructor
public class toTxt implements exportDocument {

    private User user;

    @Override
    public void export() throws IOException {
        FileWriter list = new FileWriter("list.txt");

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
        System.out.println("Txt creado!");
        JOptionPane.showMessageDialog(null, "The ToDo List has been exported successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        list.close();
    }

}
