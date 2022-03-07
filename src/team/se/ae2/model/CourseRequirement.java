package team.se.ae2.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CourseRequirement {
    protected String requirementText;
    protected User creator;
    protected LocalDateTime createTime;

    public CourseRequirement(String requirementText, User creator, LocalDateTime createTime) {
        this.requirementText = requirementText;
        this.creator = creator;
        this.createTime = createTime;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }
}
