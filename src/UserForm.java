import com.toedter.calendar.JDayChooser;
import modelS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

public class UserForm extends JDialog {

    private JPanel userPanel;
    private JLabel nameLabel;
    private JButton profileBtn;
    private JButton workOutBtn;
    private JButton mealsBtn;
    private JLabel profileIcon;
    private JLabel workOutIcon;
    private JLabel healthIcon;
    private JDayChooser dayChooser;
    private JLabel dateLabel;

    LoginForm loginForm = new LoginForm(null); //calling the loginFrom when the app starts
    User user = loginForm.user;



     // making a user each time someone want to log in


    public  UserForm(JFrame parent) {
        super(parent);
        setTitle("User form");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        LocalDate dateNow = LocalDate.now();
        Month month = dateNow.getMonth();
        dateLabel.setText(month+ " " + dateNow.toString()); //date in the right upper corner

        mealsBtn.setBackground(new Color(255,215,0));
        mealsBtn.setBorderPainted(false);

        workOutBtn.setBackground(new Color(255,215,0));
        workOutBtn.setBorderPainted(false);

        profileBtn.setBackground(new Color(255,215,0));
        profileBtn.setBorderPainted(false);

        nameLabel.setText("Welcome " + user.getName()); //welcoming the user


        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    UserProfileForm userprofile = new UserProfileForm(null, user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


                //this method will be performed when you click on the profile button
                /*JOptionPane.showMessageDialog(UserForm.this,
                        "welcome to your profile: " ,
                        "Profile",
                        JOptionPane.INFORMATION_MESSAGE);*/

            }
        });

        workOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //this method will be performed when you click on the workout button
                /*
                JOptionPane.showMessageDialog(UserForm.this,
                        "here we add a new work out",
                        "Work out",
                        JOptionPane.INFORMATION_MESSAGE);
                 */
                dispose();
                WorkoutForm workoutForm = new WorkoutForm(null);

            }
        });

        mealsBtn.addActionListener(new ActionListener() {
            //this method will be performed when you click on the health button

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


        
        UserForm userForm = new UserForm(null); // calling the user form. notice that loginForm well be executed befor userForm
        /*
        if(user != null){



        }else {
            System.out.printf("try agin");
        }*/



    }

}



