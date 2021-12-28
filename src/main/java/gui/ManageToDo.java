package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageToDo extends JFrame {
    private JPanel pnlMain;
    private JLabel lblTitle;
    private JTable tableToDo;
    private JPanel pnlTable;
    private JPanel pnlUserInfo;
    private JScrollPane scrollPane;
    private JTable tableMail;
    private JPanel pnlIcon;
    private JPanel pnlInfo;
    private JLabel lblNameUser;
    private JLabel lblDNI;
    private JLabel lblEmail;


    public static void main(String[] args) {
        JFrame frame = new ManageToDo("Gestionar ToDo");
        frame.setSize(1000, 500);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public ManageToDo(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();

        tableToDo();
        popupMenuTable();
    }

    String[] columnsNamesToDo = {"# ToDo:", "Título:", "Descripción:", "Prioridad:", "Fecha de Inicio:", "Fecha de Finalización:", "Estado del ToDo:"};
    Object[][] cellsToDo = {
            {1, "Tarea #1", "Estudiar JAVA", "Alta","24 de Diciembre del 2021", "25 de Diciembre del 2021", "En Curso"}
    };

    public void tableToDo() {
        tableToDo.setModel(new DefaultTableModel(
                cellsToDo,
                columnsNamesToDo
        ));
    }

    public void popupMenuTable(){
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuOptionAdd = new JMenuItem("Agregar Tarea");
        JMenuItem menuOptionUpdate = new JMenuItem("Modificar Tarea");
        JMenuItem menuOptionDelete = new JMenuItem("Eliminar Tarea");

        menuOptionAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aquí va la programación para agregar
            }
        });

        menuOptionUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aquí va la programación para Modificar

            }
        });

        menuOptionDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aquí va la programación para Eliminar

            }
        });

        popupMenu.add(menuOptionAdd);
        popupMenu.add(menuOptionUpdate);
        popupMenu.add(menuOptionDelete);
        tableToDo.setComponentPopupMenu(popupMenu);
    }


}


