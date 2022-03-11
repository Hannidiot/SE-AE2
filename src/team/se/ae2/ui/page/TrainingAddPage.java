package team.se.ae2.ui.page;

import team.se.ae2.DataCollection;
import team.se.ae2.controller.CourseController;
import team.se.ae2.controller.TrainingController;
import team.se.ae2.model.ClassDirector;
import team.se.ae2.model.Course;
import team.se.ae2.model.Training;
import team.se.ae2.model.User;
import team.se.ae2.ui.IMenuPage;
import team.se.ae2.ui.IPermissionControl;

public class TrainingAddPage extends BasePage implements IPermissionControl {
    protected TrainingController controller = new TrainingController();
    protected DataCollection dc = DataCollection.getInstance();

    public TrainingAddPage() {}

    public TrainingAddPage(IMenuPage parent) {
        super(parent);
    }

    @Override
    public void resolve(String trainingName) {
        String trainerName = this.ui.getInput("Please input the trainer name");
        User trainer = dc.getUserByName(trainerName);
        if (controller.addTraining(trainingName, trainer, dc.getLoginUser())) {
            ui.setContentText("add training  success");
        }
        else ui.setContentText("add training failed");
    }

    @Override
    public String getMenuItemDescription() {
        return "Add a new training";
    }

    @Override
    public User.Role[] getPermittedRoles() {
        return new User.Role[] {User.Role.ADMINISTRATOR};
    }

    @Override
    public void init() {
        this.ui.setDefaultHint("Please input training name");
    }
}
