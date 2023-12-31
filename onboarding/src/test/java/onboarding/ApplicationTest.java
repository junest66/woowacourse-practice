package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        void case1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void cas3() {
            String cryptogram = "zyelleyz";
            assertThat(Problem2.checkDuplicate(cryptogram)).isEqualTo(false);
        }

        @Test
        void case4() {
            String cryptogram = "zyelleyz";
            for(int i = 0; i<cryptogram.length(); i++) {
                System.out.println(cryptogram.charAt(i) + " " + Problem2.indexCheckDuplicates(cryptogram,i));
            }
        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void 이메일형식테스트() {
            String email1 = "asb123@email.com";
            String email2 = "asb";
            String email3 = "asn@gmail.com";
            String email4 = "@gmail.com";
            String email5 = "111231231231231213@gmailcom";
            String email6 = "a@email.com";

            assertThat(Problem6.isVaildEmail(email1)).isEqualTo(true);
            assertThat(Problem6.isVaildEmail(email2)).isEqualTo(false);
            assertThat(Problem6.isVaildEmail(email3)).isEqualTo(false);
            assertThat(Problem6.isVaildEmail(email4)).isEqualTo(false);
            assertThat(Problem6.isVaildEmail(email5)).isEqualTo(false);
            assertThat(Problem6.isVaildEmail(email6)).isEqualTo(true);
        }

        @Test
        @DisplayName("닉네임검증테스트")
        void testNickName() {
            String nickName1 = "abc";
            String nickName2 = "한글";
            String nickName3 = "";
            String nickName4 = "한글123";
            String nickName5 = "한글이이이이이이이이이이이이이이잉이이이이한글이이이이이이이이이이이이이이잉이이이이";

            assertThat(Problem6.isVaildNickName(nickName1)).isEqualTo(false);
            assertThat(Problem6.isVaildNickName(nickName2)).isEqualTo(true);
            assertThat(Problem6.isVaildNickName(nickName3)).isEqualTo(false);
            assertThat(Problem6.isVaildNickName(nickName4)).isEqualTo(false);
            assertThat(Problem6.isVaildNickName(nickName5)).isEqualTo(false);
        }

        @Test
        @DisplayName("중복되는 닉네임 검사하는 함수")
        void testDuplicateNickName() {
            List<List<String>> forms = new ArrayList<>();
            forms.add(List.of("jm@email.com", "제이엠"));
            forms.add(List.of("jason@email.com", "제이슨"));
            forms.add(List.of("woniee@email.com", "워니"));
            forms.add(List.of("mj@email.com", "엠제이"));
            forms.add(List.of("nowm@email.com", "이제엠"));
            Problem6.solution(forms);
        }
    }

    @Nested
    class Problem7Test {
        @Test
        void case1() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
