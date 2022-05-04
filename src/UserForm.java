import model.Week;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class UserForm extends JDialog {
    private JButton btnAdd;
    private JButton btnCancel;
    private JPanel userPanel;
    private JLabel Welcome;
    private JToolBar WeekTolbar;


    public void UserForm(JFrame parent) {

        setTitle("User information");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //  buttons

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Week week = new Week();
        JComboBox comboBox = new JComboBox();

        setVisible(true);

        WeekTolbar.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
            }
        });


    }

    public static void main(String[] args) {

        UserForm userForm = new UserForm();

    }

}



