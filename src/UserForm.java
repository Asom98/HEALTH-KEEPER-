import model.Day;
import model.Food;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;

import static model.Day.days.*;

public class UserForm extends JDialog {
    private JButton btnAdd;
    private JButton btnCancel;
    private JPanel userPanel;
    private JLabel Welcome;
    private JComboBox comboBox1;


    public  UserForm(JFrame parent) {
        super(parent);
        setTitle("Create new account");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(520, 476));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //  buttons

        btnAdd.addActionListener(new ActionListener() {
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

        Day day1 = new Day(Monday);
        Day day2 = new Day(Tuesday);
        Day day3 = new Day(Wednesday);
        Day day4 = new Day(Thursday);
        Day day5 = new Day(Friday);
        Day day6 = new Day(Saturday);
        Day day7 = new Day(Sunday);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        JComboBox comboBox = new JComboBox(days);
        this.add(comboBox1);
        this.pack();
        this.setVisible(true);
        setVisible(true);

    }

    public static void main(String[] args) {

        UserForm userForm = new UserForm(null);

    }

}



