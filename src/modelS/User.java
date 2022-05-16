package modelS;

public class User {
    public String name;
    public String email;
    public String password;

    private String dateOfBirth;
    private String Gender;
    private int height;
    private int weight;


    //private ArrayList<> days;


    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User (String dateOfBirth, String gender, int height, int weight){
        this.dateOfBirth = dateOfBirth;
        this.Gender = gender;
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
        return Gender;
    }

    public void setGender (String gender){
        this.Gender = Gender;
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
}
