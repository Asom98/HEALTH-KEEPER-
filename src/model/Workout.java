package model;

public class Workout {

    private int duration;
    private boolean usedWeights;

    public Workout(int duration, boolean usedWeights) {
        this.duration = duration;
        this.usedWeights = usedWeights;
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

}
