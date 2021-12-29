package service;

import entities.ToDo;
import entities.User;
import interfaces.Commit;

public class ToDoCommit implements Commit {
    private User user;
    private ToDo toDo;

    public ToDoCommit(User user, ToDo toDo) {
        this.user = user;
        this.toDo = toDo;
        sendCommit();
    }

    @Override
    public void sendCommit() {
        String recipient = user.getEmail();
        String id = String.valueOf(toDo.getId());
        String subjet = toDo.getTitle();
        String description = "Estimado usuario: "+ user.getName() + " se le informa que se ha agregado un nuevo " +
                "ToDo a su lista. \n\nToDo: " + toDo.getTitle() + "\nDescripción: " + toDo.getDescription();
        new SendToDoEmail(recipient, subjet, description);
    }
}
