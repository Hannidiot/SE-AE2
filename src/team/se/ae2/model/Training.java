package team.se.ae2.model;

import java.util.ArrayList;
import java.util.Date;

public class Training {
    protected String trainingName;
    protected Date trainingTime;
    protected ArrayList<Teacher> trainees;
    protected User trainer;
    protected Administrator owner;

    public Training(String trainingName, Date trainingTime, User trainer, Administrator owner) {
        this.trainingName = trainingName;
        this.trainingTime = trainingTime;
        this.trainees = new ArrayList<>();
        this.trainer = trainer;
        this.owner = owner;
    }

    // todo: refactor the parameter with String
    public boolean addTrainee(Teacher trainee) {
        if (trainees.contains(trainee)) return false;

        trainees.add(trainee);
        return true;
    }

    // todo: refactor the parameter with String
    public boolean removeTrainee(Teacher trainee) {
        if (!trainees.contains(trainee)) return false;

        trainees.remove(trainee);
        return true;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public Date getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(Date trainingTime) {
        this.trainingTime = trainingTime;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public Administrator getOwner() {
        return owner;
    }

    public void setOwner(Administrator owner) {
        this.owner = owner;
    }
}
