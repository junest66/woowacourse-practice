package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    @DisplayName("스트라이크와 볼 갯수 세는 함수")
    void judge() {
        List<Integer> user = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> user1 = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
        Referee referee = new Referee();
        referee.judge(user1,computer);
        assertThat(referee.getBolNum()).isEqualTo(2);
        assertThat(referee.getStrikeNum()).isEqualTo(1);
    }
}