import modelS.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

public class UserProfileForm extends JFrame {
    private JPanel MainPanel;
    private JPanel TopPanel;
    private JPanel LeftPanel;
    private JButton updateProfileButton;
    private JButton deleteAccountButton;
    private JButton GoBackButton;
    private JLabel nameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel genderLabel;
    private JLabel emailLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;


    //creating and setting up JFrame
    public UserProfileForm(JFrame parent, User user) throws SQLException {

        setContentPane(MainPanel);
        setTitle("User Profile");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ResultSet rs = getUserInfo(user);
        while (rs.next()){

            nameLabel.setText(rs.getString("name"));
            emailLabel.setText(rs.getString("email"));
            genderLabel.setText(rs.getString("gender"));
            heightLabel.setText(rs.getString("height"));
            weightLabel.setText(rs.getString("weight"));
            dateOfBirthLabel.setText(rs.getString("dateOfBirth"));

        }

        //assigning the column to values


        //when clicking on this button it should open the updateProfileForm
        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProfile updateProfile = new UpdateProfile(null, user);
                dispose();

            }
        });
        //when clicking on this button, a popup should show up with choices.
        // The user get deleted if confermed. (still need to fix this part)
        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Are you sure that you want to delete your profile?",
                        "Confirm",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION){
                    deletAccount(user);
                    JOptionPane.showMessageDialog(null,
                            "Your account was deleted sucessfully!");
                    dispose();
                    StartMenu startMenu = new StartMenu(null);

                }else if (response == JOptionPane.NO_OPTION){
                    dispose();
                    try {
                        UserProfileForm userProfileForm = new UserProfileForm(null, user);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }else {
                    dispose();
                    try {
                        UserProfileForm userProfileForm = new UserProfileForm(null, user);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });
        //when clicking this button it calls the Userform.
        GoBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserForm userForm = new UserForm(user);
            }
        });
        setVisible(true);
    }

    public ResultSet getUserInfo(User user){

        ResultSet res = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "Select name, email, gender, height, weight, dateOfBirth From users where name = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user.getName());
            res = stm.executeQuery();


        }catch (Exception e) {
            e.printStackTrace();
        }


        return res;
    }

    public void deletAccount(User user){

        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";


        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql =  "Delete  from workout where users_id = ?" ;
            String sql1 =  "Delete  from food where users_id = ?";
            String sql2 =  "Delete from users where id = ?";
            //"Delete  from food where users_id = ?" +
            //"Delete from users where id = ?" ;
            PreparedStatement stm = conn.prepareStatement(sql);
            PreparedStatement stm1 = conn.prepareStatement(sql1);
            PreparedStatement stm2 = conn.prepareStatement(sql2);
            stm.setInt(1, user.getUserId());
            stm1.setInt(1, user.getUserId());
            stm2.setInt(1, user.getUserId());
            //stm.setInt(2, user.getUserId());
            // stm.setInt(3, user.getUserId());
            stm.executeUpdate();
            stm1.executeUpdate();
            stm2.executeUpdate();


        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //UserProfileForm userProfileForm = new UserProfileForm(null,null);

    }


}
