package modelS;

public class UserProfile {

    private int dateOfBirth;
    private String Gender;
    private int height;
    private float weight;

    public UserProfile() {
    }

    public UserProfile (int dateOfBirth, String gender, int height, float weight){
        this.dateOfBirth = dateOfBirth;
        this.Gender = gender;
        this.height = height;
        this.weight = weight;
    }


    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(){
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender (){
        this.Gender = Gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(){
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(){
        this.weight = weight;
    }



}
