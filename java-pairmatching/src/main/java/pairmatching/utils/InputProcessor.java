package pairmatching.utils;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.EducationModule;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class InputProcessor {
    public EducationModule processCourseInfo(String input) {
        List<String> info = Arrays.asList(input.split(", "));
        Course course = Course.getConstants(info.get(0));
        Level level = Level.getConstants(info.get(1));
        Mission mission = Mission.getConstants(info.get(2));
        return new EducationModule(course, level, mission);
    }
}
