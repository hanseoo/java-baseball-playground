package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void getOperation(String symbol) {
        assertThat(Operator.getOperation(symbol).getSymbol()).isEqualTo(symbol);
    }
    @ParameterizedTest
    @CsvSource(value = {"+, 2, 4, 6", "-, 6, 2, 4", "*, 5, 5, 25", "/, 10, 2, 5"}, delimiter = ',')
    void calculate(String symbol, int p1, int p2, int result) {
        assertThat(Operator.getOperation(symbol).calculate(p1, p2))
                .isEqualTo(result);
    }
}