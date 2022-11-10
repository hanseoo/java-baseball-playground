package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"50 - 10 + 10"})
    public void constructor(String word) {
        Assertions.assertThat(new StringCalculator(word))
                .isInstanceOf(StringCalculator.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 - 3 2 3"})
    public void validSymbol(String word) {
        assertThatThrownBy(() -> {
            new StringCalculator(word);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 - 3 + +"})
    public void validNumber(String word) {
        assertThatThrownBy(() -> {
            new StringCalculator(word);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 - 3 + 5 * 2 / 4, 6", "10 - 5 * 5, 25"}, delimiter = ',')
    void calculation(String word, String result) {
        StringCalculator stringCalculator = new StringCalculator(word);
        assertThat(stringCalculator.toString()).isEqualTo(result);
    }
}