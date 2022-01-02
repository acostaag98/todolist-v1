package export;

import entities.User;
import interfaces.exportDocument;
import lombok.AllArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;

@AllArgsConstructor
public class toTxt implements exportDocument {

    private User user;

    @Override
    public void export() throws IOException {
        FileWriter list = new FileWriter("list.txt");
        list.write(String.valueOf(this.user.getToDos()));
        list.close();
    }

}
