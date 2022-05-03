import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Base64;

public class LoginForm extends JDialog{
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnRegistration;
    private JPanel loginPanel;
    public User user;

    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                User user = getAuthenticatedUser(email, password);

                if (user != null){
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Invalid email or password",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistrationForm registrationForm = new RegistrationForm(new JFrame());
            }
        });

        setVisible(true);
    }

    private User getAuthenticatedUser(String email, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/loginam?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, email);
            String encodedString = encode(password);
            prepStatement.setString(2, encodedString);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

    private String encode(String password){

        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));
        return encodedString;
    }


    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;
        if (user != null) {
            System.out.printf("Login successful. \nWelcome " + user.getName());
            System.out.printf("\nEmail: " + user.getEmail());
        }
        else{
            System.out.println("Login cancelled");
        }
    }
}
