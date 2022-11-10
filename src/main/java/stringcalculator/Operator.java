package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLICATION("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator getOperation(String symbol) {
        return Arrays.stream(values())
                .filter(value -> value.symbol.equals(symbol))
                .findFirst()
                .get();
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Integer calculate(int x, int y) {
        return this.operation.apply(x, y);
    }
}
