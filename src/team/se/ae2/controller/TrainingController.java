package team.se.ae2.controller;

import team.se.ae2.io.DataCollection;
import team.se.ae2.model.Administrator;
import team.se.ae2.model.Teacher;
import team.se.ae2.model.Training;
import team.se.ae2.model.User;

import java.time.LocalDateTime;

public class TrainingController {
    protected DataCollection dc = DataCollection.getInstance();

    public boolean addTraining(String trainingName, LocalDateTime trainingTime,
                               User trainer, User owner) {
        if (!owner.getRole().equals(User.Role.ADMINISTRATOR)) return false;

        Training newTraining = new Training(trainingName, trainingTime, trainer, (Administrator) owner);
        dc.addTraining(newTraining);
        return true;
    }

    public boolean addTrainee2Training(Training training, Teacher trainee) {
        // todo: add check here

        training.addTrainee(trainee);
        return true;
    }
}
