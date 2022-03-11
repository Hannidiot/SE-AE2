package team.se.ae2.controller;

import team.se.ae2.DataCollection;
import team.se.ae2.Util;
import team.se.ae2.model.*;

public class TrainingController {
    protected DataCollection dc = DataCollection.getInstance();

    public boolean addTraining(String trainingName, User trainer, User owner) {
        if (!owner.getRole().equals(User.Role.ADMINISTRATOR)) return false;

        String trainingCode = Util.generateTrainingId();

        Training newTraining = new Training(trainingCode, trainingName, trainer, (Administrator) owner);
        dc.addTraining(newTraining);
        return true;
    }

    public boolean addTrainee(Training training, Teacher trainee) {

        dc.addTrainee(new Trainee(trainee, training));

        return true;
    }


    public Training getTrainingByTrainingName(String code)  { return dc.getTrainingByName(code); }

}
