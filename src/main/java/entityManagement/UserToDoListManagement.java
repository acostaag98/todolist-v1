package entityManagement;

import entities.ToDo;
import entities.User;
import interfaces.*;
import lombok.Setter;

import javax.swing.*;

public class UserToDoListManagement implements addObject, updateObjectIntoObject, deleteObjectIntoObject, showObjectDetail_IntoObject {


    private ToDoManagement toDoManagement = new ToDoManagement();

    @Override
    public void showDetail(Object user, String toDoID) {
        int position = searchToDo( (User) user, toDoID);

        if (position < 0){
            JOptionPane.showMessageDialog(null, "The ToDo doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.toDoManagement.showDetail( ((User) user).getToDos().get(position) );
    }


    @Override
    public void add( Object user ) {
        Object obj = this.toDoManagement.create();

        if (obj != null){
            ( (User) user ).getToDos().add( (ToDo) obj );
        }
    }

    @Override
    public void delete( Object user, String toDoID ) {
        int position = searchToDo( (User) user, toDoID);

        if (position < 0){
            JOptionPane.showMessageDialog(null, "The ToDo doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.toDoManagement.delete( ((User) user).getToDos().get(position) );
        ((User) user).getToDos().remove(position);
    }

    @Override
    public void update(Object user, String toDoID) {
        int position = searchToDo( (User) user, toDoID);

        if (position < 0){
            JOptionPane.showMessageDialog(null, "The ToDo doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.toDoManagement.update( ((User) user).getToDos().get(position) );
    }

    private int searchToDo(User user, String toDoID){
        for (int i = 0; i < user.getToDos().size(); i++) {
            if ( user.getToDos().get(i).getId() == toDoID ){
                return i;
            }
        }
        return -1;
    }



}
