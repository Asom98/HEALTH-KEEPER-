import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.MonthDay;

public class UserForm extends JDialog {

    private JPanel userPanel;
    private JLabel nameLabel;
    private JButton profileBtn;
    private JButton workOutBtn;
    private JButton healthBtn;


    //LoginForm loginForm = new LoginForm(null);
    //User user = loginForm.user;
    public User user = new User("kassem", "kassem@", "123");


    public  UserForm(JFrame parent) {
        super(parent);
        setTitle("User Form");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String name = user.getName();
        nameLabel.setText("Welcome " + name);








        setVisible(true);

    }

    public static void main(String[] args) {
        //LocalDateTime myObj = LocalDateTime.now();
        User user = new User("kassem", "kassem@", "123");

        UserForm userForm = new UserForm(null);
        /*
        if(user != null){



        }else {
            System.out.printf("try agin");
        }*/



    }

}



