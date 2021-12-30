package entityManagement;


import entities.User;
import entitiesGUIForms.UserGUIForm;
import enums.actionType;
import interfaces.createObject;

public class UserManagement implements createObject {

    private UserGUIForm GuiForm = new UserGUIForm();

    @Override
    public Object create() {
        User user = new User();
        if ( this.GuiForm.show(user, actionType.NEW) ){
            return user;
        }
        return null;
    }
}
