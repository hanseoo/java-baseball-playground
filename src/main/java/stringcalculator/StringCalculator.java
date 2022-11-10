package stringcalculator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {
    private final Calculator calculator = new Calculator();

    private static final String SPLIT_SYMBOL = " ";

    private static final int NUMBER_RESULT_VALUE = 1;

    private static final int SYMBOL_RESULT_VALUE = 0;

    public StringCalculator(String inputString) {
        String[] arrString = splitString(inputString);
        validWord(arrString);
        calculation(arrString);
    }

    private String[] splitString(String inputString) {
        return inputString.split(SPLIT_SYMBOL);
    }

    private void validWord(String[] arrString) {
        validNumber(getWord(arrString, NUMBER_RESULT_VALUE));
        validSymbol(getWord(arrString, SYMBOL_RESULT_VALUE));
    }

    private String[] getWord(String[] arrString, int resultValue) {
        return IntStream.range(0, arrString.length)
                .filter(value -> (value + 1) % 2 == resultValue)
                .mapToObj(operand -> arrString[operand])
                .toArray(String[]::new);
    }

    private void validNumber(String[] arrNumber) {
        Arrays.stream(arrNumber)
                .forEach(this::isNumber);
    }

    private void validSymbol(String[] arrSymbol) {
        Arrays.stream(arrSymbol)
                .forEach(this::isSymbol);
    }

    private void isNumber(String word) {
        if (! word.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 존재합니다.");
        }
    }

    private void isSymbol(String word) {
        if (! Arrays.stream(Operator.values())
                .anyMatch(value -> value.getSymbol().equals(word))) {
            throw new IllegalArgumentException("심볼이 아닌 값이 존재합니다.");
        }
    }

    private void calculation(String[] arrString) {
        String[] arrNumber = getWord(arrString, NUMBER_RESULT_VALUE);
        String[] arrSymbol = getWord(arrString, SYMBOL_RESULT_VALUE);

        firstCalculation(arrNumber[0], arrNumber[1], arrSymbol[0]);
        for (int i = 1, len = arrSymbol.length; i < len; i++) {
            remainderCalculation(arrNumber[i + 1], arrSymbol[i]);
        }
    }

    private void firstCalculation(String prevNum, String nextNum, String symbol) {
        calculator.calculate(Integer.parseInt(prevNum), Integer.parseInt(nextNum), symbol);
    }

    private void remainderCalculation(String nextNum, String symbol) {
        calculator.calculate(Integer.parseInt(nextNum), symbol);
    }

    @Override
    public String toString() {
        return String.valueOf(calculator.getTotal());
    }
}
