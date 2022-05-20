import modelS.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

public class MealsForm extends JDialog{
    private JTextField FoodTf;
    private JTextField CaloriesTf;
    private JButton addMealsButton;
    private JButton cancelButton;
    private JPanel TopPanel;
    private JTextField DateTf;
    private JPanel mealPanel;
    private JPanel jPanel;

    public MealsForm(JFrame parent, User user) {

        super(parent);
        setTitle("Add Meals");
        setContentPane(jPanel);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
/*
        DateTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                DateTf.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        FoodTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                FoodTf.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        CaloriesTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                CaloriesTf.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });*/


        addMealsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFoodToDataBase(user);
                dispose();
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //UserForm userForm = new UserForm(user);
            }
        });

        setVisible(true);
    }

    public void addFoodToDataBase(User user){


        String foodName = FoodTf.getText();
        int foodCal = Integer.parseInt(CaloriesTf.getText());
        Date date = Date.valueOf(DateTf.getText());

        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO food (foodName, foodCal, foodDate, users_id)" +
                    "VALUES (?, ?, ?, ?);";

            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, String.valueOf(foodName));
            prepStatement.setInt(2, foodCal);
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
