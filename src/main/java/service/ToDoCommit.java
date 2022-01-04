package service;

import entities.ToDo;
import entities.User;
import interfaces.Commit;
import interfaces.emailService;

import javax.swing.*;

public class ToDoCommit implements Commit {
    private User user;
    private ToDo toDo;
    private emailService emailService;

    public ToDoCommit(User user, ToDo toDo , emailService Service) {
        this.user = user;
        this.toDo = toDo;
        this.emailService = Service;
    }

    @Override
    public void sendCommit() {

        //new SendToDoEmailByGmail(recipient, subjet, description);
        this.emailService.send_Email( this.user , this.toDo );
        JOptionPane.showMessageDialog(null, "We sent you a confirmation email to " + this.user.getEmail(), "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
