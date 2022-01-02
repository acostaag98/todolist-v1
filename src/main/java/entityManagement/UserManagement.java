package entityManagement;



import entities.User;
import entitiesGUIForms.UserGUIForm;
import enums.actionType;
import interfaces.createObject;
import interfaces.updateObject;

public class UserManagement implements createObject, updateObject {

    private UserGUIForm GuiForm = new UserGUIForm();

    @Override
    public Object create() {
        User user = new User();
        if ( this.GuiForm.show(user, actionType.NEW) ){
            return user;
        }
        return null;
    }

    @Override
    public void update(Object user) {
        this.GuiForm.show( (User) user, actionType.UPDATE );
    }
}
