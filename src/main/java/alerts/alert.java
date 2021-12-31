package alerts;


import javax.swing.*;


public class alert extends JFrame {
    public String msg1;
    public String msg2;
    public alert() {
        setSize(400, 200);
        setTitle("Export");
        setLocationRelativeTo(null);
        initializeComponents();
    }
    private void initializeComponents() {
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel msg = new JLabel();
        msg.setText("Se ha creado correctamente el archivo");
        msg.setBounds(20, 20, 400, 100);
        panel.add(msg);

    }
}
