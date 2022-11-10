package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void each() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 5, *, 5", "5, 3, -, 2"}, delimiterString = ",")
    void equalToCalculate(int param1, int param2, String symbol, int result) {
        calculator.calculate(param1, param2, symbol);
        assertThat(calculator.getTotal()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 5, *, 4", "5, 3, -, 1"}, delimiterString = ",")
    void notEqualToCalculate(int param1, int param2, String symbol, int result) {
        calculator.calculate(param1, param2, symbol);
        assertThat(calculator.getTotal()).isNotEqualTo(result);
    }


    @ParameterizedTest
    @CsvSource(value = {"1, 5, *, 0", "5, 3, -, 0"}, delimiterString = ",")
    void reset(int param1, int param2, String symbol, int result) {
        calculator.calculate(param1, param2, symbol);
        calculator.reset();
        assertThat(calculator.getTotal()).isEqualTo(result);
    }

    @Test
    void getTotal() {
        assertThat(calculator.getTotal()).isEqualTo(0);
    }
}