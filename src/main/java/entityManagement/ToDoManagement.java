package entityManagement;

import entities.ToDo;
import entitiesGUIForms.ToDoGUIForm;
import enums.actionType;
import interfaces.createObject;
import interfaces.deleteObject;
import interfaces.updateObject;

public class ToDoManagement implements createObject, updateObject, deleteObject {


    private ToDoGUIForm GuiForm = new ToDoGUIForm();


    @Override
    public Object create() {
        ToDo toDo = new ToDo();
        if ( this.GuiForm.show(toDo, actionType.NEW) ){
            return toDo;
        }
        return null;
    }

    @Override
    public void delete( Object toDo ) {
        toDo = null;
    }

    @Override
    public void update( Object toDo ) {
       this.GuiForm.show( (ToDo) toDo, actionType.UPDATE );
    }
}
