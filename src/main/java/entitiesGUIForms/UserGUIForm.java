package entitiesGUIForms;

import enums.actionType;
import interfaces.showGUIForm;

public class UserGUIForm implements showGUIForm {

    @Override
    public boolean show(Object user, actionType action) {
        return false;
    }
}
