package entityManagement;

import entities.ToDo;
import interfaces.createObject;
import interfaces.deleteObject;
import interfaces.updateObject;

public class ToDoManagement implements createObject, updateObject, deleteObject {

    private ToDo toDo;


    @Override
    public void create() {
        System.out.println("Hola Soy un cambio");
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }
}
