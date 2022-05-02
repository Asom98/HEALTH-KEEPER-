import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForm extends JDialog {
    private JTextField tfWater;
    private JLabel Food;
    private JTextField tfFood;
    private JTextField tfWorkout;
    private JButton btnAdd;
    private JButton btnCancel;
    private JTextField tfLabel;
    private JPanel userPanel;

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

        setVisible(true);

    }

}



