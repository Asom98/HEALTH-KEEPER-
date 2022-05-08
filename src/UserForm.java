import model.User;

import javax.swing.*;
import java.awt.*;

public class UserForm extends JDialog {

    private JPanel userPanel;
    private JLabel nameLabel;
    private JButton profileBtn;
    private JButton workOutBtn;
    private JButton healthBtn;
    private JLabel profileIcon;
    private JLabel workOutIcon;
    private JLabel healthIcon;


    //LoginForm loginForm = new LoginForm(null);
    //model.User user = loginForm.user;
    public User user = new User("User", "model.User@", "123");


    public  UserForm(JFrame parent) {
        super(parent);
        setTitle("model.User Form");
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
        //model.User user = new model.User("kassem", "kassem@", "123");

        UserForm userForm = new UserForm(null);
        /*
        if(user != null){



        }else {
            System.out.printf("try agin");
        }*/



    }

}



