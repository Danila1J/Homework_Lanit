import model.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] params = readParams();
        System.out.println(Calculator.execute(params));
    }

    private static String[] readParams() {
        Scanner scanner = new Scanner(System.in);
        String operator = scanner.nextLine();
        String value1 = scanner.nextLine();
        String value2 = scanner.nextLine();
        return new String[]{operator, value1, value2};
    }
}
