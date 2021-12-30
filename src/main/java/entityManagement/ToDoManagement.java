package entityManagement;

import entities.ToDo;
import entitiesGUIForms.ToDoGUIForm;
import entitiesGUIForms.ToDoGUI_ResumeWindow;
import enums.actionType;
import interfaces.createObject;
import interfaces.deleteObject;
import interfaces.showObjectDetail;
import interfaces.updateObject;

public class ToDoManagement implements createObject, updateObject, deleteObject, showObjectDetail {


    private ToDoGUIForm GuiForm = new ToDoGUIForm();
    private ToDoGUI_ResumeWindow toDoGUI_resumeWindow = new ToDoGUI_ResumeWindow();

    @Override
    public void showDetail(Object toDo) {
        toDoGUI_resumeWindow.show( (ToDo) toDo );
    }

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
