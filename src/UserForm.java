import com.toedter.calendar.JDayChooser;
import modelS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
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
    private JLabel dayLabel;
    private JList dayList;
    private JLabel showLabel;



    public UserForm(User user) {
        setTitle("User form");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        LocalDate dateNow = LocalDate.now();
        Month monthText = dateNow.getMonth();
        Integer monthValue = dateNow.getMonthValue();
        Integer yearValue = dateNow.getYear();
        dateLabel.setText(monthText+ " " + dateNow.toString()); //date in the right upper corner

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
                try {

                    UserProfileForm userprofile = new UserProfileForm(null, user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

        workOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WorkoutForm workoutForm = new WorkoutForm(null, user);

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

        dayChooser.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");

                String date = String.valueOf(yearValue + "-" + monthValue + "-" + dayChooser.getDay()) ;
                //dayLabel.setText(date);
                Day day = new Day(Date.valueOf(date));
                dayLabel.setText(String.valueOf(day.getDate()));


            }
        });
        setVisible(true);


    }

    public static void main(String[] args) {

        //UserForm userForm = new UserForm(null); // calling the user form. notice that loginForm well be executed befor userForm
    }

}



