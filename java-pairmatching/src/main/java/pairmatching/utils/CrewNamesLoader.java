package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;

public class CrewNamesLoader {

    private static final String CREW_FILE_PATH = "src/main/resources/";
    private static final String BACKEND_CREW_FILE_NAME = "backend-crew.md";
    private static final String FRONTEND_CREW_FILE_NAME = "frontend-crew.md";

    public static List<String> loadCrewNamesFromFile(Course course) {
        List<String> crewNames = new ArrayList<>();
        String fileName = FRONTEND_CREW_FILE_NAME;
        if (course == Course.BACKEND) {
            fileName = BACKEND_CREW_FILE_NAME;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(CREW_FILE_PATH + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                crewNames.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crewNames;
    }
}
