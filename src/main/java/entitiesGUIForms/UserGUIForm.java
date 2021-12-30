package entitiesGUIForms;

import entities.ToDo;
import entities.User;
import enums.actionType;
import interfaces.showGUIForm;

import javax.swing.*;
import java.awt.*;

public class UserGUIForm implements showGUIForm {

    @Override
    public boolean show(Object user, actionType action) {

        JPanel panel = new JPanel(new GridLayout(0,1));
        JTextField DNI_Input = new JTextField();
        JTextField NameInput = new JTextField();
        JTextField EmailInput = new JTextField();

        panel.add(new JLabel("DNI"));
        panel.add(DNI_Input);
        DNI_Input.setText( ((User) user).getDNI() );

        panel.add(new JLabel("Name"));
        panel.add(NameInput);
        NameInput.setText( ((User) user).getName() );

        panel.add(new JLabel("Email"));
        panel.add(EmailInput);
        EmailInput.setText( ((User) user).getEmail() );

        int result = JOptionPane.showConfirmDialog(null, panel, action.getValue()+" "+ "User",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {

            try {

                String DNItmp = DNI_Input.getText();
                String NameTmp = NameInput.getText();
                String EmailTmp = EmailInput.getText();

                if ( DNItmp.length() == 0 || NameTmp.length() == 0 || EmailTmp.length() == 0 ){
                    JOptionPane.showMessageDialog(null, "You must fill all the fields", "Warning", JOptionPane.WARNING_MESSAGE);
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

        }if (result == JOptionPane.CLOSED_OPTION){
            System.exit(0);
        }

        return false;
    }
}
