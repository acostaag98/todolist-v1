package entities;

import java.io.Serializable;
import java.util.ArrayList;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private String DNI;
    private String Name;
    private String Email;
    private ArrayList<ToDo> ToDos;
}
