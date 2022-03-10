package team.se.ae2.ui.page;

import team.se.ae2.model.User;
import team.se.ae2.ui.IMenuItem;
import team.se.ae2.ui.IMenuPage;
import team.se.ae2.ui.IPermissionControl;

public class TeacherEnrollPage extends BasePage implements IPermissionControl {
    protected InfoEntryPage infoEntryPage;

    public TeacherEnrollPage(){}

    public TeacherEnrollPage(IMenuPage parent) {
        super(parent);
    }

    @Override
    public void resolve(String input) {

    }

    @Override
    public String getMenuItemDescription() {
        return "TeacherEnroll Module";
    }

    @Override
    public void init() {

        infoEntryPage = new InfoEntryPage(this);

        this.menuItems.add(infoEntryPage);
    }

    @Override
    public User.Role[] getPermittedRoles() {
        return new User.Role[] { User.Role.ADMINISTRATOR };
    }
}
