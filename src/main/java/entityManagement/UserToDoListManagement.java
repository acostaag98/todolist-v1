package entityManagement;

import entities.ToDo;
import entities.User;
import interfaces.addObject;
import interfaces.deleteObject;
import interfaces.updateObject;
import service.ToDoCommit;

public class UserToDoListManagement implements addObject, updateObject, deleteObject {

    private User user;
    private int idToDo;


    public void PrintList() {

    }

    @Override
    public void add() {
        for (ToDo toDo : user.getToDos()) {
            if (this.idToDo == toDo.getId()) {
                new ToDoCommit(user, toDo);
            } else {
                System.out.println("ToDo no encontrado");
            }
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }


}
