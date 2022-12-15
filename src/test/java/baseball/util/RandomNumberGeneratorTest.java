package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomNumberGeneratorTest {
    NumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @DisplayName("랜덤 숫자가 1~9 사이의 숫자인지 테스트")
    @RepeatedTest(100)
    void create() {
        int number = randomNumberGenerator.create(1).get(0);
        assertThat(number).isBetween(1, 9);
    }


    @DisplayName("랜덤 숫자의 사이즈가 맞는지 테스트")
    @Test
    void size_test() {
        List<Integer> generated = randomNumberGenerator.create(3);
        assertThat(generated.size()).isEqualTo(3);
    }
}