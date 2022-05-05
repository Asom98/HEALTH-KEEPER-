import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.MonthDay;

public class UserForm extends JDialog {

    private JPanel userPanel;
    private JLabel label;
    private JButton closebtn;
    private JComboBox comboBox1;
    private JLabel ChoiseLabel;


    public  UserForm(JFrame parent) {
        super(parent);
        setTitle("User Form");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        /*
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        comboBox1 = new JComboBox(days);
        this.add(comboBox1);*/

        setVisible(true);
        //label.setText();


        closebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(comboBox1.getSelectedItem());

            }
        });
    }

    public static void main(String[] args) {
        LocalDateTime myObj = LocalDateTime.now();
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;
        if(user != null){
            UserForm userForm = new UserForm(null);


        }else {
            System.out.printf("try agin");
        }



    }

}



