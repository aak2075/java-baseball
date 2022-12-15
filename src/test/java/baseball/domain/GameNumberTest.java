package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameNumberTest {
    GameNumber answer;

    @BeforeEach
    void setUp() {
        answer = new GameNumber(List.of(1,2,3));
    }

    @DisplayName("equals 테스트")
    @Test
    void case1() {
        GameNumber input = new GameNumber(List.of(4,2,5));

        assertThat(answer.equals(input, 1)).isFalse();
        assertThat(answer.equals(input, 2)).isTrue();
        assertThat(answer.equals(input, 3)).isFalse();
    }

    @DisplayName("containsOnly 테스트")
    @Test
    void case2() {
        GameNumber input = new GameNumber(List.of(4,2,1));

        assertThat(answer.containsOnly(input, 1)).isFalse();
        assertThat(answer.containsOnly(input, 2)).isFalse();
        assertThat(answer.containsOnly(input, 3)).isTrue();
    }

    @Nested
    class expected {
        @DisplayName("숫자의 사이즈가 3이 아닌 경우")
        @Test
        void size() {
            assertThatThrownBy(() -> new GameNumber(List.of(1,2,3,4)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자의 범위가 1~9가 아닌 경우")
        @Test
        void range() {
            assertThatThrownBy(() -> new GameNumber(List.of(0,1,2)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자에 중복이 포함된 경우")
        @Test
        void duplicate() {
            assertThatThrownBy(() -> new GameNumber(List.of(1,2,2)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
