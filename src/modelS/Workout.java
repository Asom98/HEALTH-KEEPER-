package modelS;

import java.util.Date;

public class Workout {

    private String workOutTyp;
    private int duration;
    private Date date;


    public Workout(String workOutTyp,int duration,Date date) {
        this.workOutTyp = workOutTyp;
        this.duration = duration;
        this.date = date;

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String getWorkOutTyp() {
        return workOutTyp;
    }

    public void setWorkOutTyp(String workOutTyp) {
        this.workOutTyp = workOutTyp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Workout{"+ workOutTyp + "}";
    }
}
