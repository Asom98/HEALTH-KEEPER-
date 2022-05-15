import modelS.User;
import modelS.UserProfile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpdateProfile extends JFrame {
    private JPanel panel1;
    private JPanel mainPanel;
    private JButton UPDATEButton;
    private JButton goBackButton;
    private JPanel TopPanel;
    private JPanel InfoPanel;
    private JTextField nameTf;
    private JTextField dateOfBirthTf;
    private JTextField genderTf;
    private JTextField emailTf;
    private JTextField heightTf;
    private JTextField weightTf;


    public UpdateProfile(JFrame parent) {

        setContentPane(mainPanel);
        setTitle("Update Profile");
        setSize(520, 476);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserProfile userProfile = new UserProfile();
                dispose();
            }
        });

        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void UpdateUser() {
        String name = nameTf.getText();
        int dateOfBirth = Integer.parseInt(dateOfBirthTf.getText());
        String gender = genderTf.getText();
        String email = emailTf.getText();
        int height = Integer.parseInt(heightTf.getText());
        float weight = Float.parseFloat(weightTf.getText());
    }


    private UpdateProfile updateUserDataBase (String name, int dateOfBirth, String Gender,String email, int height, float weight) {
        UpdateProfile UpdateProfile = null;
        User user = new User(name,email, null);
        UserProfile userProfile = new UserProfile(dateOfBirth, Gender, height, weight);

        final String DB_URL = "jdbc:mysql://eu-cdbr-west-02.cleardb.net/heroku_b7a2d484b13ad29";
        final String USERNAME = "b9ff1b68e68067";
        final String PASSWORD = "a4162bab";

        try {

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql1 = "INSERT INTO userProfile (dateOfBirth, gender, lenght, weight)" +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement prepStatement = conn.prepareStatement(sql1);
            prepStatement.setInt(1, dateOfBirth);
            prepStatement.setString(2, Gender);
            prepStatement.setInt(3, height);
            prepStatement.setFloat(4, weight);

            int addedRows = prepStatement.executeUpdate();

            String sql2 = "Update users set (name, email) where userId=?";
            PreparedStatement prepStatement2 = conn.prepareStatement(sql2);
            prepStatement2.setString(1,name);
            prepStatement2.setString(2,email);


            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return UpdateProfile;
    }

}
