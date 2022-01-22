package interfaces;

import enums.actionType;

import javax.swing.*;

public interface showGUIForm {

    boolean show(Object obj, actionType action);
    void createGuiForm(Object obj);
    boolean sendForm(Object obj, actionType action);
}
