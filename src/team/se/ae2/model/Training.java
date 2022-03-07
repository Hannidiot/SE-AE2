package team.se.ae2.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Training {
    protected String trainingCode;
    protected String trainingName;
    protected User trainer;
    protected Administrator owner;

    public Training() {}

    public Training(String trainingCode, String trainingName, User trainer, Administrator owner) {
        this.trainingCode = trainingCode;
        this.trainingName = trainingName;
        this.trainer = trainer;
        this.owner = owner;
    }

    public String getTrainingCode() {
        return trainingCode;
    }

    public void setTrainingCode(String trainingCode) {
        this.trainingCode = trainingCode;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
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

    @Override
    public String toString() {
        return "trainingCode=" + trainingCode +
                "\ttrainingName=" + trainingName +
                "\ttrainer=" + trainer.id +
                "\towner=" + owner.id +
                "" ;
    }
}
