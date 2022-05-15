import com.toedter.calendar.JDayChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnAddWorkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    public void fetchWorkout(){
        /*
        SQL query fetching data from table, displaying it in GUI
         */
    }

    // Add workout to day selected on calendar
    public void addWorkout(){
        JDayChooser dayChooser = new JDayChooser();
        dayChooser.getDay(); // get selected day from calendar
        // add day fetched by getDay to db and correlate it's id to the added workout(s)
        /*
        SQL query to add workout data to table
         */
    }

    /*
     Calculate calorie consumption, based on chosen workout and duration.
     Display value on WorkoutForm label and also on UserForm once workout has been added
     Maybe add space under UserForm calendar for displaying workouts?
     */
    public int calorieCalc(){
        return 0; // <- placeholder value to prevent syntax error
    }

    public static void main(String[] args) {
        WorkoutForm workoutForm = new WorkoutForm(null);
    }
}