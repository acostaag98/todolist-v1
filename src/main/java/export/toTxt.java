package export;
import entities.ToDo;
import entities.User;
import enums.priorityType;
import enums.stateType;
import interfaces.exportDocument;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class toTxt implements exportDocument {
    public void export() throws IOException {
        FileWriter list = new FileWriter("list.txt");
        ArrayList<User> a = createDataUser();
        ArrayList<ToDo> b = createDataToDo();
        list.write(String.valueOf(a));
        list.write(String.valueOf(b));
        list.close();
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
