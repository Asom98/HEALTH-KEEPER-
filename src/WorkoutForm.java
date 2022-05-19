import modelS.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class WorkoutForm extends JDialog{
    private JComboBox cbWorkoutType;
    private JComboBox cbWeight;
    private JComboBox cbWorkoutMinutes;
    private JButton btnAddWorkout;
    private JButton btnCancel;
    private JPanel WorkoutFormPanel;
    private JLabel dateLabel;
    private JTextField dateTextBox;

    public WorkoutForm(JFrame parent, User user) {
        super(parent);
        setTitle("Add Workout");
        setContentPane(WorkoutFormPanel);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnAddWorkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWorkOutToDataBase(user);
                //JDayChooser dayChooser = new JDayChooser();
                //int myDay = dayChooser.get();
                //System.out.println(myDay);
                // call addWorkout method
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserForm userForm = new UserForm(null);
            }
        });
        setVisible(true);
    }

    // Add workout to day selected on calendar
    public void addWorkOutToDataBase(User user){

        // get selected day from calendar

        // get values from form input
        String workoutType = cbWorkoutType.getSelectedItem().toString();
        //String weight = cbWeight.getSelectedItem().toString();
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


/*
    public void fetchWorkout(){

        /*
        retrieve values from db

        sql =
            select type, duration, kcalUsed
            from workout
            where workout.user_id = user.id
         */


    public void displayWorkout(){
        /*
        display workout with proper formatting
        use this for output on userForm
         */
    }

    /*
     Calculate calorie consumption, based on chosen workout and duration.
     Display value on WorkoutForm label and also on UserForm once workout has been added
     Maybe add space under UserForm calendar for displaying workouts?
     */
    public void calorieCalc(){
        /*
        leaving this for now, getting a decent estimation needs some time
         */

    }

    public static void main(String[] args) {
        //WorkoutForm workoutForm = new WorkoutForm(null,UserForm.);


    }
}
