package stringcalculator;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("문자열 게산기");
        System.out.println("계산식을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringCalculator stringCalculator = new StringCalculator(input);
        System.out.println("total: " + stringCalculator.toString());
    }
}
