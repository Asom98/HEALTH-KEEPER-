import com.toedter.calendar.JDayChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class WorkoutForm extends JDialog{
    private JComboBox cbWorkoutType;
    private JComboBox cbWorkoutHours;
    private JComboBox cbWorkoutMinutes;
    private JButton btnAddWorkout;
    private JButton btnCancel;
    private JPanel WorkoutFormPanel;

    public WorkoutForm(JFrame parent) {
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
                JDayChooser dayChooser = new JDayChooser();
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
    public void addWorkout(){

        // get selected day from calendar


       /*
        // get values from form input
        ComboBoxModel workoutType = cbWorkoutType.getModel();
        ComboBoxModel workoutHours = cbWorkoutHours.getModel();
        ComboBoxModel workoutMinutes = cbWorkoutMinutes.getModel();

        final String DB_URL = "jdbc:mysql://eu-cdbr-west-02.cleardb.net/heroku_b7a2d484b13ad29";
        final String USERNAME = "b9ff1b68e68067";
        final String PASSWORD = "a4162bab";

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO workout" +
                    "VALUES (?, ?, ?);";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, String.valueOf(workoutType));
            prepStatement.setString(2, String.valueOf(workoutHours));
            prepStatement.setString(3, String.valueOf(workoutMinutes));

            int addedRows = prepStatement.executeUpdate();

            // If the write operation was successful
            if (addedRows > 0) {
                // Probably don't need to do anything
            }

            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

        */
/*
    public void fetchWorkout(){

        /*
        retrieve values from db

        sql =
            select type, duration, kcalUsed
            from workout
            where workout.user_id = user.id
         */
    }


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
       WorkoutForm workoutForm = new WorkoutForm(null);


    }
}
