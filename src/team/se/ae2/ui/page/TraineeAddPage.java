package team.se.ae2.ui.page;

import team.se.ae2.DataCollection;
import team.se.ae2.controller.TrainingController;
import team.se.ae2.model.Teacher;
import team.se.ae2.model.Training;
import team.se.ae2.model.User;
import team.se.ae2.ui.IPermissionControl;

public class TraineeAddPage extends BasePage implements IPermissionControl {
    protected DataCollection dc = DataCollection.getInstance();
    protected TrainingController controller = new TrainingController();

    public TraineeAddPage() {
    }

    @Override
    public void init() {
        this.ui.setDefaultHint("Please input training name");
    }

    @Override
    public void resolve(String trainingName) {
        String teacherName = this.ui.getInput("Please input teacher name");

        Training training = dc.getTrainingByName(trainingName);
        User teacher = dc.getUserByName(teacherName);

        if (controller.addTrainee(training, (Teacher) teacher)) {
            this.ui.setContentText("Add trainee success");
        }
        this.ui.setContentText("Add trainee failed");
    }

    @Override
    public String getMenuItemDescription() {
        return null;
    }

    @Override
    public User.Role[] getPermittedRoles() {
        return new User.Role[] { User.Role.ADMINISTRATOR };
    }
}
