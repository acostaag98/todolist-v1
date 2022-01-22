package entitiesGUIForms;

import entities.ToDo;
import entities.User;
import enums.actionType;
import interfaces.showGUIForm;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserGUIForm implements showGUIForm {

    JPanel panel;
    JTextField DNI_Input;
    JTextField NameInput;
    JTextField EmailInput;

    @Override
    public boolean show(Object user, actionType action) {

        createGuiForm( user );
        return sendForm( user, action );
    }

    @Override
    public void createGuiForm(Object user) {

        this.panel = new JPanel(new GridLayout(0,1));
        this.DNI_Input = new JTextField();
        this.NameInput = new JTextField();
        this.EmailInput = new JTextField();

        this.panel.add(new JLabel("DNI"));
        this.panel.add(this.DNI_Input);
        this.DNI_Input.setText( ((User) user).getDNI() );

        this.panel.add(new JLabel("Name"));
        this.panel.add(this.NameInput);
        this.NameInput.setText( ((User) user).getName() );

        this.panel.add(new JLabel("Email"));
        this.panel.add(this.EmailInput);
        this.EmailInput.setText( ((User) user).getEmail() );
    }

    @Override
    public boolean sendForm(Object user, actionType action) {

        int result = JOptionPane.showConfirmDialog(null, this.panel, action.getValue()+" "+ "User",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {

            try {

                String DNItmp = this.DNI_Input.getText();
                String NameTmp = this.NameInput.getText();
                String EmailTmp = this.EmailInput.getText();
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher matcher = pattern.matcher(EmailTmp);

                if ( DNItmp.length() == 0 || NameTmp.length() == 0 || EmailTmp.length() == 0 ){
                    JOptionPane.showMessageDialog(null, "You must fill all the fields", "Warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

                else if (matcher.find() == false){
                    JOptionPane.showMessageDialog(null, "\n" + "the mail format is invalid", "Warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

                ( (User) user ).setDNI( DNItmp );
                ( (User) user ).setName( NameTmp );
                ( (User) user ).setEmail( EmailTmp );


                JOptionPane.showMessageDialog(null, "The User has been saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                return true;

            }catch ( Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }if (result == JOptionPane.CLOSED_OPTION && action == actionType.NEW){

            int input = JOptionPane.showConfirmDialog(null,"Do you want to Exit?", "Select an Option...",JOptionPane.YES_NO_CANCEL_OPTION);
            if ( input == 0){
                System.exit(0);
            }

        }

        return false;

    }
}
