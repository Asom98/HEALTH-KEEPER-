import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class UserForm extends JDialog {

    private JPanel userPanel;
    private JLabel nameLabel;
    private JButton profileBtn;
    private JButton workOutBtn;
    private JButton healthBtn;
    private JLabel profileIcon;
    private JLabel workOutIcon;
    private JLabel healthIcon;
    private JLabel dateLabel;


    public LocalDate dateNow = LocalDate.now();


    //LoginForm loginForm = new LoginForm(null);
    //model.User user = loginForm.user;
    public User user = new User("kassem", "User@", "123");


    public  UserForm(JFrame parent) {
        super(parent);
        setTitle("User form");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        dateLabel.setText(dateNow.toString());

        healthBtn.setBackground(new Color(255,215,0));
        healthBtn.setBorderPainted(false);

        workOutBtn.setBackground(new Color(255,215,0));
        workOutBtn.setBorderPainted(false);

        profileBtn.setBackground(new Color(255,215,0));
        profileBtn.setBorderPainted(false);

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

        //model.User user = new model.User("kassem", "kassem@", "123");

        UserForm userForm = new UserForm(null);
        /*
        if(user != null){



        }else {
            System.out.printf("try agin");
        }*/



    }

}



