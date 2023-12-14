package pairmatching.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Course;

class CrewNamesLoaderTest {
    @Test
    void 백엔드크루_이름들을_가져오는_함수테스트() {
        List<String> strings = CrewNamesLoader.loadCrewNamesFromFile(Course.BACKEND);
        assertThat(strings.size()).isEqualTo(20);
    }

    @Test
    void 프론트크루_이름들을_가져오는_함수테스트() {
        List<String> strings = CrewNamesLoader.loadCrewNamesFromFile(Course.FRONTEND);
        assertThat(strings.size()).isEqualTo(15);
    }
}
