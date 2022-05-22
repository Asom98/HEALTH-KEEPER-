import com.toedter.calendar.JDayChooser;
import modelS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class UserForm extends JDialog {

    private JPanel userPanel;
    private JLabel nameLabel;
    private JButton profileBtn;
    private JButton workOutBtn;
    private JButton mealsBtn;
    private JLabel profileIcon;
    private JLabel workOutIcon;
    private JLabel healthIcon;
    private JDayChooser dayChooser;
    private JLabel dateLabel;
    private JLabel dayLabel;
    private JList workoutList;
    private JLabel showLabel;
    private JLabel monthDayChooser;
    private JButton logoutButton;
    private JList foodList;
    private String dateInChooseDay;


    public UserForm(User user) {
        setTitle("User form");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(1100, 600));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        LocalDate dateNow = LocalDate.now();
        Month monthText = dateNow.getMonth();
        var monthValue = (dateNow.getMonthValue() <10 ? "0" : "") + dateNow.getMonthValue();
        Integer yearValue = dateNow.getYear();
        monthDayChooser.setText(String.valueOf(monthText));
        dateLabel.setText(monthText + " " + dateNow.toString()); //date in the right upper corner
        ArrayList<String> matchDateForWorkOut = new ArrayList<>();
        ArrayList<String> matchDateForFood = new ArrayList<>();


        mealsBtn.setBackground(new Color(255, 215, 0));
        mealsBtn.setBorderPainted(false);

        workOutBtn.setBackground(new Color(255, 215, 0));
        workOutBtn.setBorderPainted(false);

        profileBtn.setBackground(new Color(255, 215, 0));
        profileBtn.setBorderPainted(false);
        nameLabel.setText("Welcome " + user.getName() + "!"); //welcoming the user

        ArrayList<Workout> workoutsFromDataBase = getWorkoutToList(user);
        ArrayList<Food> foodsFromDataBase = getFoodToList(user);


        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    UserProfileForm userprofile = new UserProfileForm(null, user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

        workOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WorkoutForm workoutForm = new WorkoutForm(user);

            }
        });

        mealsBtn.addActionListener(new ActionListener() {
            //this method will be performed when you click on the health button

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MealsForm mealsForm = new MealsForm(user);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StartMenu startMenu = new StartMenu(null);

            }
        });

        dayChooser.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                var day = (dayChooser.getDay() <10 ? "0" : "") + dayChooser.getDay();


                //Getting values of chosen date on calender
                String date = String.valueOf(yearValue + "-" + monthValue + "-" + day);
                System.out.println(date);
                setDateInChooseDay(date);
                dayLabel.setText(date);

                for (Workout w : workoutsFromDataBase) {
                    //Displaying workouts in workoutList (Jlist)

                    String first = String.valueOf(w.getDate());
                    String sec = String.valueOf(date);

                    //Comparing the dates of chosen day and the one stored in database
                    if (first.contains(sec)) {
                        matchDateForWorkOut.add("Date: " + w.getDate());
                        matchDateForWorkOut.add("Name: " + w.getWorkOutTyp());
                        matchDateForWorkOut.add("Duration: " + String.valueOf(w.getDuration()) + " min");
                        DefaultComboBoxModel model=
                                new DefaultComboBoxModel(matchDateForWorkOut.toArray(new String[matchDateForWorkOut.size()]));
                        workoutList.setModel(model);

                    } else {
                        //empty jlist when clicking another date with no values.
                        DefaultComboBoxModel model=
                                new DefaultComboBoxModel(matchDateForWorkOut.toArray(new String[matchDateForWorkOut.size()]));
                        matchDateForWorkOut.clear();
                        workoutList.setModel(model);
                    }
                }

                for (Food f : foodsFromDataBase) {
                    //Displaying Food in foodList (Jlist)

                    String first = String.valueOf(f.getDate());
                    String sec = String.valueOf(date);

                    //Comparing the dates of chosen day and the one stored in database
                    if (first.contains(sec) ){
                        matchDateForFood.add("Date: " + f.getDate());
                        matchDateForFood.add("Name: " + f.getFoodName());
                        matchDateForFood.add("Calories: " + String.valueOf(f.getCalories()) + " Kcal");
                        DefaultComboBoxModel model1=
                                new DefaultComboBoxModel(matchDateForFood.toArray(new String[matchDateForFood.size()]));
                        foodList.setModel(model1);
                    } else {
                        //empty jlist when clicking another date with no values.
                        DefaultComboBoxModel model1=
                                new DefaultComboBoxModel(matchDateForFood.toArray(new String[matchDateForFood.size()]));
                        matchDateForFood.clear();
                        foodList.setModel(model1);
                    }
                }
            }
        });
        setVisible(true);
    }


    public ArrayList getWorkoutToList(User user) {

        //getting data from database of workouts and return values

        ArrayList<Workout> workouts = new ArrayList<>();
        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        ResultSet res = null;

        //Connecting to database
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "select workOutTyp, duration, workOutDate from workout where users_id = ?";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, String.valueOf(user.getUserId()));

            res = prepStatement.executeQuery();
            while (res.next()) {

                String workOutTyp = res.getString("workOutTyp");
                int duration = res.getInt("duration");
                Date date = res.getDate("workOutDate");
                Workout workout = new Workout(workOutTyp, duration, date);
                workouts.add(workout);
            }


            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return workouts;
    }

    public ArrayList getFoodToList(User user) {

        //getting data from database of foods and return values

        ArrayList<Food> foods = new ArrayList<>();
        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        ResultSet res = null;

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "select foodName, foodCal, foodDate from food where users_id = ?";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, String.valueOf(user.getUserId()));

            res = prepStatement.executeQuery();
            while (res.next()) {

                String workOutTyp = res.getString("foodName");
                int duration = res.getInt("foodCal");
                Date date = res.getDate("foodDate");
                Food food = new Food(workOutTyp, duration, date);
                foods.add(food);
            }


            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return foods;
    }

    public String setDateInChooseDay(String dateInChooseDay) {
        this.dateInChooseDay = dateInChooseDay;
        return dateInChooseDay;
    }

    public String getDateInChooseDay() {
        return dateInChooseDay;
    }

    public static void main(String[] args) {

    }
}

