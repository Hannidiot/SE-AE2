package team.se.ae2.model;

public class Trainee {
    protected Teacher trainee;
    protected Training training;

    public Trainee(Teacher trainee, Training training) {
        this.trainee = trainee;
        this.training = training;
    }

    public Teacher getTrainee() {
        return trainee;
    }

    public void setTrainee(Teacher trainee) {
        this.trainee = trainee;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public String toString() {
        return "trainee=" + trainee.id +
                "\ttraining=" + training.trainingCode +
                "" ;
    }
}
