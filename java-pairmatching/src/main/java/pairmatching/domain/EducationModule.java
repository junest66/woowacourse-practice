package pairmatching.domain;

import java.util.Objects;

public class EducationModule {
    private Course course;
    private Level level;
    private Mission mission;

    public EducationModule(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EducationModule that = (EducationModule) o;
        return course == that.course &&
                level == that.level &&
                mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

}
