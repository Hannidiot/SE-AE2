package team.se.ae2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Training {
    protected String trainingName;
    protected LocalDateTime trainingTime;
    protected ArrayList<Teacher> trainees;
    protected User trainer;
    protected Administrator owner;

    public Training(String trainingName, LocalDateTime trainingTime, User trainer, Administrator owner) {
        this.trainingName = trainingName;
        this.trainingTime = trainingTime;
        this.trainees = new ArrayList<>();
        this.trainer = trainer;
        this.owner = owner;
    }

    public void addTrainee(Teacher trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Teacher trainee) {
        trainees.remove(trainee);
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public LocalDateTime getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(LocalDateTime trainingTime) {
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
