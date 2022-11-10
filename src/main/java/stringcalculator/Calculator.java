package stringcalculator;

public class Calculator {
    private int total;

    public Calculator() {
        this.total = 0;
    }

    public void calculate(int prevNum, int nextNum, String operator) {
        this.total = Operator.getOperation(operator).calculate(prevNum, nextNum);
    }

    public void calculate(int nextNum, String operator) {
        calculate(getTotal(), nextNum, operator);
    }

    public void reset() {
        this.total = 0;
    }

    public int getTotal() {
        return total;
    }
}
