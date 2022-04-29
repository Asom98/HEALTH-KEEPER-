import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Encoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Base64;

public class RegistrationForm extends JDialog{
    private JPanel registerPanel;
    private JTextField tfName;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;

    public RegistrationForm(JFrame parent){
        super(parent);
        setTitle("Create new account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /*
            Action event listeners for the buttons.
            Calls function inside when button is pressed
        */

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    /*
        register function with error handling, making sure all fields are filled in
     */


    private void registerUser() {
         String name = tfName.getText();
         String email = tfEmail.getText();
         String password = String.valueOf(pfPassword.getPassword());

         Base64.Encoder encoder = Base64.getEncoder();
         String encodedString = encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all the fields",
                    "Try again", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        user = addUserToDatabase(name, email, encodedString);
        if (user != null) {
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public User user;
    private User addUserToDatabase(String name, String email, String password) {
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost/loginam?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (name, email, password)" +
                    "VALUES (?, ?, ?)";
            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, name);
            prepStatement.setString(2, email);
            prepStatement.setString(3, password);

            int addedRows = prepStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.name = name;
                user.email = email;
                user.password = password;
            }

            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return user;
    }

    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
        User user = myForm.user;
        if (user != null) {
            System.out.println("Successfully registered as user: " + user.name);
        }
        else{
            System.out.println("Registration cancelled");
        }
    }
}
