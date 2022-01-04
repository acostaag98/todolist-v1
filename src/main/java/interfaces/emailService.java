package interfaces;

import entities.ToDo;
import entities.User;

public interface emailService {

    void send_Email(User user , ToDo toDo );
}
