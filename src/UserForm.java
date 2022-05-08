import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public User user = new User("kassem", "model.User@", "123");


    public  UserForm(JFrame parent) {
        super(parent);
        setTitle("model.User Form");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        healthBtn.setBackground(Color.orange);

        workOutBtn.setBackground(Color.orange);
        profileBtn.setBackground(Color.orange);
        String name = user.getName();
        nameLabel.setText("Welcome " + name);



        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(UserForm.this,
                        "welcome to your profile: " + user.getName(),
                        "Profile",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        });

        workOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(UserForm.this,
                        "here we add a new work out",
                        "Work out",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        healthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(UserForm.this,
                        "health status...",
                        "Health",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
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



