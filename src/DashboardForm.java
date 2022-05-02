import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DashboardForm extends JFrame{
    private JPanel dashboardPanel;
    private JButton btnRegister;
    private JLabel lbDashboard;


    public DashboardForm(){
        setTitle("Dashboard");
        setContentPane(dashboardPanel);
        setMinimumSize(new Dimension(500, 430));
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        boolean hasRegisteredUsers = connectToDatabase();
        if (hasRegisteredUsers){
            //show login form
            LoginForm loginForm = new LoginForm(this);
            UserForm user = loginForm.user;

            if (user != null) {
                lbDashboard.setText("User: " + user.name);
                setLocationRelativeTo(null);
                setVisible(true);
            }
            else {
                dispose();
            }
        }
        else {
            // display registration
            RegistrationForm registrationForm = new RegistrationForm(this);
            UserForm user = registrationForm.user;

            if (user != null){
                lbDashboard.setText("User: " + user.name);
                setLocationRelativeTo(null);
                setVisible(true);
            }
            else {
                dispose();
            }
        }
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationForm registrationForm = new RegistrationForm(DashboardForm.this);
                UserForm userForm = registrationForm.user;

                if (userForm != null){
                    JOptionPane.showMessageDialog(DashboardForm.this,
                            "New user: " + userForm.name,
                            "Registration successful",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private boolean connectToDatabase(){
        boolean hasRegisteredUsers = false;

        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/loginam?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "root";



        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            //statement.executeUpdate("CREATE DATABASE IF NOT EXISTS agileMethods");
            //statement.close();
            //conn.close();

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users("
                    + "id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "email VARCHAR(50) NOT NULL UNIQUE,"
                    + "password VARCHAR(50) NOT NULL"
                    +")";
            statement.executeUpdate(sql);

            // check for users
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");

            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0){
                    hasRegisteredUsers = true;
                }
            }

            statement.close();
            conn.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
        return hasRegisteredUsers;
    }

    public static void main(String[] args) {
        DashboardForm myForm = new DashboardForm();
    }
}