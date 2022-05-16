import modelS.User;
import modelS.UserProfile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UserProfileForm extends JFrame {
    private JPanel MainPanel;
    private JPanel TopPanel;
    private JPanel LeftPanel;
    private JButton updateProfileButton;
    private JButton deleteProfileButton;
    private JButton GoBackButton;
    private JLabel nameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel genderLabel;
    private JLabel emailLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;

    User user = new User();
    UserProfile userProfile = new UserProfile();


    //creating and setting up JFrame
    public UserProfileForm(JFrame parent){

        setContentPane(MainPanel);
        setTitle("User Profile");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //assigning the column to values
        nameLabel.setText(user.getName());
        dateOfBirthLabel.setText(String.valueOf(userProfile.getDateOfBirth()));
        genderLabel.setText(userProfile.getGender());
        emailLabel.setText(user.getEmail());
        heightLabel.setText(String.valueOf(userProfile.getHeight()));
        weightLabel.setText(String.valueOf(userProfile.getHeight()));

        //when clicking on this button it should open the updateProfileForm
        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProfile updateProfile = new UpdateProfile(null);
            }
        });
        //when clicking on this button, a popup should show up with choices.
        // The user get deleted if confermed. (still need to fix this part)
        deleteProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Are you sure that you want to delete your profile?",
                        "Confirm",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,
                            "Your account was deleted sucessfully!");
                    dispose();
                    StartMenu startMenu = new StartMenu(null);

                }else if (response == JOptionPane.NO_OPTION){
                    dispose();
                    UserProfileForm userProfileForm = new UserProfileForm(null);

                }else {
                    dispose();
                    UserProfileForm userProfileForm = new UserProfileForm(null);

                }
            }
        });
        //when clicking this button it calls the Userform.
        GoBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserForm userForm = new UserForm(null);
            }
        });
        setVisible(true);
    }


    public static void main(String[] args) {
        UserProfileForm userProfileForm = new UserProfileForm(null);

    }


}
