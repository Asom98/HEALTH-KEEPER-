import com.toedter.calendar.JDayChooser;
import modelS.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;

public class WorkoutForm extends JDialog{
    private JComboBox cbWorkoutType;
    private JComboBox cbWeight;
    private JComboBox cbWorkoutMinutes;
    private JButton btnAddWorkout;
    private JButton btnCancel;
    private JPanel WorkoutFormPanel;
    private JLabel dateLabel;
    private JTextField dateTextBox;

    public WorkoutForm(User user) {

        LocalDate dateNow = LocalDate.now();
        Month monthText = dateNow.getMonth();
        Integer yearValue = dateNow.getYear();

        setTitle("Add Workout");
        setContentPane(WorkoutFormPanel);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /*dateTextBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                dateTextBox.setText(yearValue + "-" + monthText + "-");
            }
        });*/

        btnAddWorkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addWorkOutToDataBase(user);
                dispose();
                UserForm userForm = new UserForm(user);                //JDayChooser dayChooser = new JDayChooser();
                //int myDay = dayChooser.get();
                //System.out.println(myDay);

                // call addWorkout method
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserForm userForm = new UserForm(user);
            }
        });
        setVisible(true);

    }

    // Add workout to day selected on calendar
    public void addWorkOutToDataBase(User user){

        String workoutType = cbWorkoutType.getSelectedItem().toString();
        int workoutMinutes = Integer.parseInt(cbWorkoutMinutes.getSelectedItem().toString());
        Date date = Date.valueOf(dateTextBox.getText());

        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO workout(workOutTyp, duration, workOutDate, users_id)" +
                    "VALUES (?, ?, ?, ?);";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, String.valueOf(workoutType));
            prepStatement.setInt(2, workoutMinutes);
            prepStatement.setDate(3, date);
            prepStatement.setString(4, String.valueOf(user.getUserId()));


            prepStatement.executeUpdate();

            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
