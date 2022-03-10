package team.se.ae2.ui.page;

import team.se.ae2.DataCollection;
import team.se.ae2.controller.CourseController;
import team.se.ae2.model.ClassDirector;
import team.se.ae2.model.Course;
import team.se.ae2.model.User;
import team.se.ae2.ui.IMenuPage;
import team.se.ae2.ui.IPermissionControl;

public class CourseReqAddPage extends BasePage implements IPermissionControl {
    protected CourseController controller = new CourseController();
    protected DataCollection dc = DataCollection.getInstance();

    public CourseReqAddPage() {}

    public CourseReqAddPage(IMenuPage parent) {
        super(parent);
    }

    @Override
    public void resolve(String courseName) {
        Course course = controller.getCourseByCourseName(courseName);
        if (course == null) {
            ui.setContentText("No such course"); return;
        }

        String courseRequirement = this.ui.getInput("Please input course requirement");

        if (controller.addCourseRequirement(course, courseRequirement, dc.getLoginUser())) {
            ui.setContentText("add course requirement success");
        }
        else ui.setContentText("add course requirement fails");
    }

    @Override
    public String getMenuItemDescription() {
        return "Add a new course requirement";
    }

    @Override
    public User.Role[] getPermittedRoles() {
        return new User.Role[] {User.Role.CLASS_DIRECTOR};
    }

    @Override
    public void init() {
        this.ui.setDefaultHint("Please input course name");
    }
}
