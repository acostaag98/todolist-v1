package gui;

import entities.User;
import entityManagement.UserManagement;
import entityManagement.UserToDoListManagement;
import export.toExcel;
import export.toPdf;
import export.toTxt;
import file.LoadFile;
import file.SaveFile;
import helpers.DateFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ManageToDo extends JFrame {
    private JPanel pnlMain;
    private JLabel lblTitle;
    private JTable tableToDo;
    private DefaultTableModel tableModel;
    private JPanel pnlTable;
    private JScrollPane scrollPane;
    private JTable tableMail;
    private JButton txtButton;
    private JButton PDFButton;
    private JButton excelButton;
    private JButton actualizarButton;
    private JButton newToDo_button;
    private JLabel UserName_Label;
    private JLabel UserEmail_Label;
    private JLabel UserDNI_Label;

    private User user;

    private DateFormatter dateFormatter = new DateFormatter();
    private LoadFile loadFile = new LoadFile();
    private SaveFile saveFile = new SaveFile();
    private UserToDoListManagement userToDoListManagement = new UserToDoListManagement();
    private UserManagement userManagement = new UserManagement();


    public static void main(String[] args) {
        JFrame frame = new ManageToDo("ToDo-app");
        frame.setSize(803, 670);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
        frame.setResizable(true);

    }

    public ManageToDo() {

    }

    public ManageToDo(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        //Load some GUI components
        loadGUIComponents();


        //EVENTS
        newToDo_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                addToDoToUser();
            }
        });

        actualizarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                UpdateUser();
            }
        });
        excelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                exportToExcel();

            }
        });
        PDFButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                exportToPdf();
            }
        });


        txtButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    exportToTxt();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void exportToPdf() {
        toPdf topdf = new toPdf(this.user);
        topdf.export();
    }
    public void exportToTxt() throws IOException {
        toTxt totxt = new toTxt(this.user);
        totxt.export();
    }
    public void exportToExcel() {
        toExcel toexcel = new toExcel(this.user);
        toexcel.export();
    }

    public void loadGUIComponents(){
        LoadUser();

        String[] columnsNamesToDo = { "ID", "Title:", "Priority:", "DeadLine", "Status" };
        tableModel = new DefaultTableModel(columnsNamesToDo, this.user.getToDos().size());

        LoadTableToDo( this.user );

        popupMenuTable();
    }

    public void addToDoToUser(){
        userToDoListManagement.add( this.user );
        LoadTableToDo( this.user );
        SaveUser();
    }

    public void showToDoDetail(String ID){
        this.userToDoListManagement.showDetail( this.user, ID );
    }

    public void updateToDo(String ID){
        this.userToDoListManagement.update( this.user, ID );
        LoadTableToDo( this.user );
        SaveUser();
    }

    public void deleteToDo(String ID){
        this.userToDoListManagement.delete( this.user, ID );
        LoadTableToDo( this.user );
        SaveUser();
    }

    public void LoadUser(){
        User tmpUser = loadFile.Cargar();
        Object obj;

        if (tmpUser == null) {
            do{
                obj = this.userManagement.create();
            }
            while (obj == null);

            this.user = (User) obj;
            SaveUser();
        }else{
            this.user = tmpUser;
        }

        printUserInfoInDashboard();
    }

    public void SaveUser(){
        this.saveFile.Guardar(this.user);

    }

    public void UpdateUser(){
        this.userManagement.update( this.user );
        printUserInfoInDashboard();
        SaveUser();
    }

    public void printUserInfoInDashboard(){
        this.UserName_Label.setText(this.user.getName());
        this.UserEmail_Label.setText(this.user.getEmail());
        this.UserDNI_Label.setText(this.user.getDNI());
    }

    public void LoadTableToDo( User user) {

        tableModel.getDataVector().removeAllElements();

        for (int i = 0; i < user.getToDos().size(); i++) {
            String ID = user.getToDos().get(i).getId();
            String Title = user.getToDos().get(i).getTitle();
            String Priority = user.getToDos().get(i).getPriority().getValue();
            String DeadLine = dateFormatter.Formatter(user.getToDos().get(i).getEndDate(), "EEE, d MMM yyyy h:mm a");
            String Status = user.getToDos().get(i).getState().getValue();

            Object[] data = { ID, Title, Priority, DeadLine, Status };

            tableModel.addRow(data);

        }

        tableToDo.setModel(tableModel);
        tableToDo.getColumnModel().getColumn(0).setWidth(0);
        tableToDo.getColumnModel().getColumn(0).setMaxWidth(0);
        tableToDo.getColumnModel().getColumn(0).setMinWidth(0);
        tableToDo.getTableHeader().getColumnModel().getColumn(0).setWidth(0);
        tableToDo.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tableToDo.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    public JTable ReturnTable() {
        return this.tableToDo;
    };

    public void popupMenuTable(){
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuOptionView = new JMenuItem("View");
        JMenuItem menuOptionUpdate = new JMenuItem("Update");
        JMenuItem menuOptionDelete = new JMenuItem("Delete");

        menuOptionView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = String.valueOf( tableToDo.getValueAt(tableToDo.getSelectedRow(), 0) ) ;
                showToDoDetail( id );
            }
        });

        menuOptionUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = String.valueOf( tableToDo.getValueAt(tableToDo.getSelectedRow(), 0) ) ;
                updateToDo(id);
            }
        });

        menuOptionDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = String.valueOf( tableToDo.getValueAt(tableToDo.getSelectedRow(), 0) ) ;
                int input = JOptionPane.showConfirmDialog(null,"Do you want to proceed?", "Select an Option...",JOptionPane.YES_NO_CANCEL_OPTION);

                if ( input == 0){
                    deleteToDo( id );
                }

            }
        });

        popupMenu.add(menuOptionView);
        popupMenu.add(menuOptionUpdate);
        popupMenu.add(menuOptionDelete);
        tableToDo.setComponentPopupMenu(popupMenu);
    }



}