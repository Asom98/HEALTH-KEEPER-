package modelS;

import java.util.Date;

public class Workout {

    private String workOutTyp;
    private int duration;


    public Workout(String workOutTyp,int duration) {
        this.workOutTyp = workOutTyp;
        this.duration = duration;


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

    @Override
    public String toString() {
        return "Workout{"+ workOutTyp + "}";
    }
}
