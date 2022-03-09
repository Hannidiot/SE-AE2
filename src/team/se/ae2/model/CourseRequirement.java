package team.se.ae2.model;

public class CourseRequirement implements IDbModel {
    protected String requirementText;
    protected User creator;
    protected Course course;

    public CourseRequirement() {}

    public CourseRequirement(String requirementText, User creator, Course course) {
        this.requirementText = requirementText;
        this.creator = creator;
        this.course = course;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setRequirementText(String requirementText) {
        this.requirementText = requirementText;
    }

    public String getRequirementText() {
        return requirementText;
    }

    public User getCreator() {
        return creator;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "requirementText=" + requirementText +
                "\tcreator=" + creator.id +
                "\tcourse=" + course.courseCode +
                "" ;
    }

    @Override
    public String getText() {
        return toString();
    }
}
