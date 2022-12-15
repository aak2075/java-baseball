package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BaseballTest {
    Baseball baseball;
    GameNumber answer;
    GameNumber input;

    @BeforeEach
    void setUp() {
        answer = mock(GameNumber.class);
        input = mock(GameNumber.class);
        baseball = new Baseball(answer);
    }

    @Test
    void countBall() {
        when(answer.containsOnly(input, 1)).thenReturn(true);
        when(answer.containsOnly(input, 2)).thenReturn(false);
        when(answer.containsOnly(input, 3)).thenReturn(false);

        assertThat(baseball.countBall(input)).isEqualTo(1);
    }

    @Test
    void countStrike() {
        when(answer.equals(input, 1)).thenReturn(true);
        when(answer.equals(input, 2)).thenReturn(false);
        when(answer.equals(input, 3)).thenReturn(true);

        assertThat(baseball.countStrike(input)).isEqualTo(2);
    }

    @Test
    void isNothing() {
        when(answer.containsOnly(input, 1)).thenReturn(false);
        when(answer.containsOnly(input, 2)).thenReturn(false);
        when(answer.containsOnly(input, 3)).thenReturn(false);

        when(answer.equals(input, 1)).thenReturn(false);
        when(answer.equals(input, 2)).thenReturn(false);
        when(answer.equals(input, 3)).thenReturn(false);

        assertThat(baseball.isNothing(input)).isTrue();
    }
}