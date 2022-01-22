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

    DateConverter dateConverter;
    EnumsManagement enumsManagement;
    DateRange dateRange_tmp;
    String[] priorityItems;
    String[] stateItems;
    JPanel panel;
    JTextField titleInput;
    JTextArea desInput;
    JComboBox priorityCombo;
    JComboBox stateCombo;
    DatePickerSettings InitDate_Settings;
    DatePickerSettings EndDate_Settings;
    DateTimePicker InitDate_input;
    DateTimePicker EndDate_input;


    @Override
    public boolean show(Object toDo, actionType action) {

        createGuiForm(toDo);
        return sendForm(toDo, action);

    }

    @Override
    public void createGuiForm(Object toDo) {

        this.dateConverter = new DateConverter();
        this.enumsManagement = new EnumsManagement();
        this.dateRange_tmp = new DateRange();
        this.priorityItems = new String[] {priorityType.LOW.getValue(), priorityType.MEDIUM.getValue(), priorityType.HIGH.getValue()};
        this.stateItems = new String[] {stateType.IN_PROCESS.getValue(), stateType.NOT_STARTED.getValue(), stateType.FINISHED.getValue()};
        this.panel = new JPanel(new GridLayout(0,1));
        this.titleInput = new JTextField();
        this.desInput = new JTextArea();
        this.priorityCombo = new JComboBox(this.priorityItems);
        this.stateCombo = new JComboBox(this.stateItems);
        this.InitDate_Settings = new DatePickerSettings();
        this.EndDate_Settings = new DatePickerSettings();
        this.InitDate_Settings.setLocale(Locale.ENGLISH);
        this.EndDate_Settings.setLocale(Locale.ENGLISH);
        this.InitDate_input = new DateTimePicker(this.InitDate_Settings,null);
        this.EndDate_input = new DateTimePicker(this.EndDate_Settings,null);


        this.panel.add(new JLabel("Title"));
        this.panel.add(this.titleInput);
        this.titleInput.setText( ((ToDo) toDo).getTitle() );

        this.panel.add(new JLabel("Description"));
        this.panel.add(this.desInput);
        this.desInput.setText( ((ToDo) toDo).getDescription() );

        this.panel.add(new JLabel("Priority"));
        this.panel.add(this.priorityCombo);
        this.priorityCombo.setSelectedIndex(Arrays.asList( this.priorityItems).indexOf( ( (ToDo) toDo ).getPriority().getValue() ) );

        this.panel.add(new JLabel("Start Date"));
        this.panel.add(this.InitDate_input);
        this.InitDate_input.setDateTimeStrict( this.dateConverter.convertDateToLocalDateTimeViaMilisecond( ( (ToDo) toDo ).getDate_range().getInitDate() ) );

        this.panel.add(new JLabel("End Date"));
        this.panel.add(this.EndDate_input);
        this.EndDate_input.setDateTimeStrict( this.dateConverter.convertDateToLocalDateTimeViaMilisecond( ( (ToDo) toDo ).getDate_range().getEndDate() ) );

        this.panel.add(new JLabel("State"));
        this.panel.add(this.stateCombo);
        this.stateCombo.setSelectedIndex( Arrays.asList( this.stateItems ).indexOf( ( (ToDo) toDo ).getState().getValue() ) );

    }

    @Override
    public boolean sendForm(Object toDo, actionType action) {

        int result = JOptionPane.showConfirmDialog(null, panel, action.getValue()+" "+ "ToDo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {

            try {

                this.dateRange_tmp.setInitDate( this.dateConverter.convertLocalDateTimeToDate(this.InitDate_input.getDateTimeStrict()) );
                this.dateRange_tmp.setEndDate( this.dateConverter.convertLocalDateTimeToDate(this.EndDate_input.getDateTimeStrict()) );

                ( (ToDo) toDo ).setTitle( this.titleInput.getText() );
                ( (ToDo) toDo ).setDescription( this.desInput.getText() );

                ( (ToDo) toDo ).setPriority( this.enumsManagement.findPriorityByValue( this.priorityCombo.getSelectedItem().toString() ) );

                ( (ToDo) toDo ).setDate_range(this.dateRange_tmp);

                ( (ToDo) toDo ).setState( this.enumsManagement.findStateByValue( this.stateCombo.getSelectedItem().toString() ) );

                return true;

            }catch ( Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                return false;
            }

        }

        return false;

    }


}



