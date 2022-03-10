package team.se.ae2.ui.page;

import team.se.ae2.DataCollection;
import team.se.ae2.Util;
import team.se.ae2.controller.EnrollController;
import team.se.ae2.model.Course;
import team.se.ae2.model.Teacher;
import team.se.ae2.model.User;
import team.se.ae2.ui.IMenuPage;
import team.se.ae2.ui.IPermissionControl;

public class InfoEntryPage extends BasePage implements IPermissionControl {
    protected EnrollController controller = new EnrollController();
    protected DataCollection dc = DataCollection.getInstance();

    public InfoEntryPage() {}

    public InfoEntryPage(IMenuPage parent) { super(parent); }

    @Override
    public void init() {this.ui.setDefaultHint("Please input teacher name");}

    @Override
    public void resolve(String userName) {
        String password = this.ui.getInput("Please input password");

        if (controller.enrollNewTeacher(Util.generateUserId(), userName, password)) {
            ui.setContentText("add teacher Information success");
        }
        else ui.setContentText("add teacher information failed");
    }


    @Override
    public String getMenuItemDescription() { return "Add a new teacher information";}

    @Override
    public User.Role[] getPermittedRoles() {
        return new User.Role[] {User.Role.ADMINISTRATOR};
    }

}

