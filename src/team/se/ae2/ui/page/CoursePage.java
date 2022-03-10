package team.se.ae2.ui.page;

import team.se.ae2.model.User;
import team.se.ae2.ui.IMenuPage;
import team.se.ae2.ui.IPermissionControl;

public class CoursePage extends BasePage implements IPermissionControl {
    protected CourseListPage courseListPage;
    protected CourseReqAddPage courseReqAddPage;

    public CoursePage() {}

    public CoursePage(IMenuPage parent) {
        super(parent);
    }

    @Override
    public void resolve(String input) {

    }

    @Override
    public String getMenuItemDescription() {
        return "Course Module";
    }

    @Override
    public void init() {
        courseListPage = new CourseListPage(this);
        courseReqAddPage = new CourseReqAddPage(this);

        this.menuItems.add(courseListPage);
        this.menuItems.add(courseReqAddPage);
    }

    @Override
    public User.Role[] getPermittedRoles() {
        return new User.Role[] { User.Role.CLASS_DIRECTOR, User.Role.ADMINISTRATOR };
    }
}
