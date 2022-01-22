package entitiesGUIForms;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import entities.DateRange;
import entities.ToDo;
import enums.actionType;
import enums.priorityType;
import enums.stateType;
import helpers.DateConverter;
import helpers.EnumsManagement;
import interfaces.showGUIForm;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;


public class ToDoGUIForm implements showGUIForm {

    @Override
    public boolean show(Object toDo, actionType action) {

        DateConverter dateConverter = new DateConverter();
        EnumsManagement enumsManagement = new EnumsManagement();
        DateRange dateRange_tmp = new DateRange();

        String[] priorityItems =  { priorityType.LOW.getValue(), priorityType.MEDIUM.getValue(), priorityType.HIGH.getValue() };
        String[] stateItems =  { stateType.IN_PROCESS.getValue(), stateType.NOT_STARTED.getValue(), stateType.FINISHED.getValue() };

        JPanel panel = new JPanel(new GridLayout(0,1));
        JTextField titleInput = new JTextField();
        JTextArea desInput = new JTextArea();
        JComboBox priorityCombo = new JComboBox(priorityItems);
        JComboBox stateCombo = new JComboBox(stateItems);
        DatePickerSettings InitDate_Settings = new DatePickerSettings();
        DatePickerSettings EndDate_Settings = new DatePickerSettings();
        InitDate_Settings.setLocale(Locale.ENGLISH);
        EndDate_Settings.setLocale(Locale.ENGLISH);
        DateTimePicker InitDate_input = new DateTimePicker(InitDate_Settings,null);
        DateTimePicker EndDate_input = new DateTimePicker(EndDate_Settings,null);

        panel.add(new JLabel("Title"));
        panel.add(titleInput);
        titleInput.setText( ((ToDo) toDo).getTitle() );

        panel.add(new JLabel("Description"));
        panel.add(desInput);
        desInput.setText( ((ToDo) toDo).getDescription() );

        panel.add(new JLabel("Priority"));
        panel.add(priorityCombo);
        priorityCombo.setSelectedIndex(Arrays.asList(priorityItems).indexOf( ( (ToDo) toDo ).getPriority().getValue() ) );

        panel.add(new JLabel("Start Date"));
        panel.add(InitDate_input);
        InitDate_input.setDateTimeStrict( dateConverter.convertDateToLocalDateTimeViaMilisecond( ( (ToDo) toDo ).getDate_range().getInitDate() ) );

        panel.add(new JLabel("End Date"));
        panel.add(EndDate_input);
        EndDate_input.setDateTimeStrict( dateConverter.convertDateToLocalDateTimeViaMilisecond( ( (ToDo) toDo ).getDate_range().getEndDate() ) );

        panel.add(new JLabel("State"));
        panel.add(stateCombo);
        stateCombo.setSelectedIndex( Arrays.asList( stateItems ).indexOf( ( (ToDo) toDo ).getState().getValue() ) );



        int result = JOptionPane.showConfirmDialog(null, panel, action.getValue()+" "+ "ToDo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {

            try {

                dateRange_tmp.setInitDate( dateConverter.convertLocalDateTimeToDate(InitDate_input.getDateTimeStrict()) );
                dateRange_tmp.setEndDate( dateConverter.convertLocalDateTimeToDate(EndDate_input.getDateTimeStrict()) );

                ( (ToDo) toDo ).setTitle( titleInput.getText() );
                ( (ToDo) toDo ).setDescription( desInput.getText() );

                ( (ToDo) toDo ).setPriority( enumsManagement.findPriorityByValue( priorityCombo.getSelectedItem().toString() ) );

                ( (ToDo) toDo ).setDate_range(dateRange_tmp);

                ( (ToDo) toDo ).setState( enumsManagement.findStateByValue( stateCombo.getSelectedItem().toString() ) );

                return true;

            }catch ( Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                return false;
            }

        }

        return false;

    }


}



