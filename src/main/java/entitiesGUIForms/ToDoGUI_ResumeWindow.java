package entitiesGUIForms;

import entities.ToDo;


import helpers.DateFormatter;
import interfaces.showGUIResume;

import javax.swing.*;



public class ToDoGUI_ResumeWindow implements showGUIResume {

    DateFormatter dateFormatter = new DateFormatter();

    @Override
    public void show(Object toDo) {


        String lineSep = System.lineSeparator();
        StringBuilder result = new StringBuilder();
        result.append("ToDo information is: ").append(lineSep).append(lineSep);
        result.append("Title: ").append( ((ToDo) toDo).getTitle() ).append(lineSep);
        result.append("Description: ").append( ((ToDo) toDo).getDescription() ).append(lineSep);
        result.append("Priority: ").append( ((ToDo) toDo).getPriority().getValue() ).append(lineSep);
        result.append("Start Date: ").append( dateFormatter.Formatter( ((ToDo) toDo).getInitDate(), "EEE, d MMM yyyy h:mm a" ) ).append(lineSep);
        result.append("End Date: ").append( dateFormatter.Formatter( ((ToDo) toDo).getEndDate(), "EEE, d MMM yyyy h:mm a" ) ).append(lineSep);
        result.append("Status: ").append( ((ToDo) toDo).getState().getValue() );

        JOptionPane.showMessageDialog(null, result.toString(), "ToDo Detail", JOptionPane.INFORMATION_MESSAGE);
    }

}
