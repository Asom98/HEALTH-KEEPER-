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
    private JList dayList;
    private JLabel showLabel;
    private JLabel monthDayChooser;
    private JButton logoutButton;
    private String dateInChooseDay;


    public  UserForm(User user) {
        setTitle("User form");
        setContentPane(userPanel);
        setMinimumSize(new Dimension(1100, 600));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        LocalDate dateNow = LocalDate.now();
        Month monthText = dateNow.getMonth();
        Integer monthValue = dateNow.getMonthValue();
        Integer yearValue = dateNow.getYear();
        monthDayChooser.setText(String.valueOf(monthText));
        dateLabel.setText(monthText+ " " + dateNow.toString()); //date in the right upper corner
        ArrayList<String> matchDateForWorkOut = new ArrayList<>();
        ArrayList<String> matchDateForFood = new ArrayList<>();


        mealsBtn.setBackground(new Color(255,215,0));
        mealsBtn.setBorderPainted(false);

        workOutBtn.setBackground(new Color(255,215,0));
        workOutBtn.setBorderPainted(false);

        profileBtn.setBackground(new Color(255,215,0));
        profileBtn.setBorderPainted(false);
        nameLabel.setText("Welcome " + user.getName() + "!"); //welcoming the user
        ArrayList<Workout> workoutsFromDataBase = getWorkoutToList(user);

        ArrayList<Food> foodsFromDataBase = getFoodToList(user);
        for (Food food: foodsFromDataBase) {
            //System.out.println(food.getFoodName());
        }


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
                WorkoutForm workoutForm = new WorkoutForm(null, user);

            }
        });

        mealsBtn.addActionListener(new ActionListener() {
            //this method will be performed when you click on the health button

            @Override
            public void actionPerformed(ActionEvent e) {
                MealsForm mealsForm = new MealsForm(null, user);
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
                //SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");

                String date = String.valueOf(yearValue + "-" + "0" + monthValue + "-" + dayChooser.getDay());
                //dayLabel.setText(date);
                //Day day = new Day(Date.valueOf(date));
                setDateInChooseDay(date);
                //System.out.println(getDateInChooseDay());
                dayLabel.setText(date);
                for (Workout w: workoutsFromDataBase) {
                    //System.out.println(String.valueOf(w.getDate()));
                    //System.out.println(String.valueOf(getDateInChooseDay()));
                    String first = String.valueOf(w.getDate());
                    String sec = String.valueOf(date);
                    if (first.contains(sec) ){
                        System.out.println(String.valueOf(w.getWorkOutTyp()));
                        //System.out.println(String.valueOf(getDateInChooseDay()));
                        matchDateForWorkOut.add(w.getWorkOutTyp());
                    }
                }
                

            }
        });
        setVisible(true);

    }

    public static void main(String[] args) {

        //UserForm userForm = new UserForm(null); // calling the user form. notice that loginForm well be executed befor userForm
    }

    public ArrayList getWorkoutToList(User user){

        ArrayList<Workout> workouts = new ArrayList<>();
        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        ResultSet res = null;

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "select workOutTyp, duration, workOutDate from workout where users_id = ?";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, String.valueOf(user.getUserId()));

            res =  prepStatement.executeQuery();
            while (res.next()){

                String workOutTyp = res.getString("workOutTyp");
                int duration = res.getInt("duration");
                Date date = res.getDate("workOutDate");
                Workout workout = new Workout(workOutTyp, duration, date);
                workouts.add(workout);
            }


            stmt.close();
            conn.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return workouts;
    }

    public ArrayList getFoodToList(User user){

        ArrayList<Food> foods = new ArrayList<>();
        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        ResultSet res = null;

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "select foodName, foodCal, foodDate from food where users_id = ?";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, String.valueOf(user.getUserId()));

            res =  prepStatement.executeQuery();
            while (res.next()){

                String workOutTyp = res.getString("foodName");
                int duration = res.getInt("foodCal");
                Date date = res.getDate("foodDate");
                Food food = new Food(workOutTyp, duration, date);
                foods.add(food);
            }


            stmt.close();
            conn.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return foods;
    }
    public void setDateInChooseDay(String dateInChooseDay){
        this.dateInChooseDay = dateInChooseDay;
    }
    public String getDateInChooseDay(){
        return dateInChooseDay;
    }

}



