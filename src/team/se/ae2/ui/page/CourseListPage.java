package team.se.ae2.ui.page;

import team.se.ae2.controller.CourseController;
import team.se.ae2.model.Course;
import team.se.ae2.model.CourseRequirement;
import team.se.ae2.model.User;
import team.se.ae2.ui.IMenuPage;
import team.se.ae2.ui.IPermissionControl;
import team.se.ae2.ui.MenuFuncs;

import java.util.List;

public class CourseListPage extends BasePage implements IPermissionControl {
    protected CourseController controller = new CourseController();

    public CourseListPage() {}

    public CourseListPage(IMenuPage parent) {
        super(parent);
    }

    @Override
    public void resolve(String input) {

    }

    @Override
    public String getMenuItemDescription() {
        return "Course List";
    }

    @Override
    public User.Role[] getPermittedRoles() {
        return new User.Role[] {User.Role.CLASS_DIRECTOR, User.Role.ADMINISTRATOR};
    }

    @Override
    public void init() {
        printTable();
    }

    protected void printTable() {
        StringBuilder tableTextBuilder = new StringBuilder();

        List<Course> courses = controller.getAllCourse();
        for (Course course:
             courses) {
            List<CourseRequirement> requirements = controller.getCourseReqsByCourse(course);

            tableTextBuilder.append(course.toString());
            if (requirements.isEmpty()) {
                tableTextBuilder.append("\n\tNo course requirement exists");
            }
            else {
                for (CourseRequirement req :
                        requirements) {
                    tableTextBuilder.append("\n\t")
                            .append(req.toString());
                }
            }

            tableTextBuilder.append("\n");
        }

        this.ui.setContentText(tableTextBuilder.toString());
    }
}
