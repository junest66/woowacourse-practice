package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("입력 검증 메서드")
    @Test
    void validation() {
        User user = new User();
        String input1 = "123";
        String input2 = "asd";
        String input3 = "113";
        String input4 = "1234";

        assertDoesNotThrow(() -> user.validation(input1));
        assertThrows(IllegalArgumentException.class, () -> user.validation(input2));
        assertThrows(IllegalArgumentException.class, () -> user.validation(input3));
        assertThrows(IllegalArgumentException.class, () -> user.validation(input4));
    }
}