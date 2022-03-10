package team.se.ae2.ui.page;

import team.se.ae2.model.User;
import team.se.ae2.ui.IMenuPage;
import team.se.ae2.ui.IPermissionControl;

public class TrainingPage extends BasePage implements IPermissionControl {
    protected TraineeAddPage traineeAddPage;
    protected TrainingAddPage trainingAddPage;

    public TrainingPage() {}

    public TrainingPage(IMenuPage parent) {
        super(parent);
    }

    @Override
    public void resolve(String input) {

    }

    @Override
    public String getMenuItemDescription() {
        return "Training Module";
    }

    @Override
    public void init() {
        traineeAddPage = new TraineeAddPage();
        trainingAddPage = new TrainingAddPage(this);

        this.menuItems.add(traineeAddPage);
        this.menuItems.add(trainingAddPage);
    }

    @Override
    public User.Role[] getPermittedRoles() {
        return new User.Role[] { User.Role.ADMINISTRATOR };
    }
}