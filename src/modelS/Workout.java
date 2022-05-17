package modelS;

import java.util.Date;

public class Workout {

    private int duration;
    private boolean usedWeights;
    private Date workOutDate;

    public Workout(int duration, boolean usedWeights, Date workOutDate) {
        this.duration = duration;
        this.usedWeights = usedWeights;
        this.workOutDate = workOutDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isUsedWeights() {
        return usedWeights;
    }

    public void setUsedWeights(boolean usedWeights) {
        this.usedWeights = usedWeights;
    }

    public Date getWorkOutDate() {
        return workOutDate;
    }

    public void setWorkOutDate(Date workOutDate) {
        this.workOutDate = workOutDate;
    }
}
