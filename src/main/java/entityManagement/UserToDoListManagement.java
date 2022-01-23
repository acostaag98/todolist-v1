package entityManagement;

import entities.ToDo;
import entities.User;
import interfaces.*;
import service.SendToDoEmailByGmail;
import service.SendToDoEmailByGmailDOS;
import service.ToDoCommit;

import javax.swing.*;

public class UserToDoListManagement implements addObject, updateObjectIntoObject, deleteObjectIntoObject, showObjectDetail_IntoObject {


    private ToDoManagement toDoManagement = new ToDoManagement();

    @Override
    public void showDetail(Object user, String toDoID) {

        try {
            int position = searchToDo( (User) user, toDoID);

            this.toDoManagement.showDetail( ((User) user).getToDos().get(position) );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    public void add( Object user ) {
        Object obj = this.toDoManagement.create();

        if (obj != null){
            ( (User) user ).getToDos().add( (ToDo) obj );

            ToDoCommit toDoCommit = new ToDoCommit((User) user, (ToDo) obj, new SendToDoEmailByGmailDOS() );
            toDoCommit.sendCommit();
        }
    }

    @Override
    public void delete( Object user, String toDoID ) {

        try {
            int position = searchToDo( (User) user, toDoID);

            this.toDoManagement.delete( ((User) user).getToDos().get(position) );
            ((User) user).getToDos().remove(position);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void update(Object user, String toDoID) {

        try {
            int position = searchToDo( (User) user, toDoID);

            this.toDoManagement.update( ((User) user).getToDos().get(position) );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private int searchToDo(User user, String toDoID) throws Exception {

        for (int i = 0; i < user.getToDos().size(); i++) {
            if ( user.getToDos().get(i).getId() == toDoID ){
                return i;
            }
        }

        throw new Exception("The ToDo doesn't exist");
    }



}