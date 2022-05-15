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

    // Add workout to day selected on calendar
    public void addWorkout(){
        // Probably need some fancy sql query magic here
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
