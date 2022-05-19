package modelS;

import java.sql.*;

public class User {
    public String name;
    public String email;
    public String password;
    private String dateOfBirth;

    private String gender;
    private int height;
    private int weight;


    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User (String dateOfBirth, String gender, int height, int weight){
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender (String gender){
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }


    public int getUserId() throws SQLException {

        final String DB_URL = "jdbc:mysql://localhost:3306/agileMethodsDB";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        ResultSet res = null;
        int id = 0;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "Select id From users where name = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, this.name);
            res = stm.executeQuery();

            while (res.next()){
                id = res.getInt(1);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }
}
