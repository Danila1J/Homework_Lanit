import model.Calculator;
import model.CalculatorException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider(name = "negativeData")
    public Object[][] negativeData() {
        return new Object[][]{
                {" ", "2", "1"},//оператор является пробелом
                {"", "2", "1"},//оператор является пустой строкой
                {"-", "", "1"},//один из операндов является пустой строкой
                {"-", " ", "2"},//один из операндов является пробелом
                {"-", null, "3"},//один из операндов является null
                {null, "2", "1"},//оператор является null
                {"*+", "2", "2"},// оператор содержит два символа
                {"/", "4", "0"},//операция деления на ноль
                {"+", "notANumber", "2"},//один из операндов не является числом
                {"-", "5", "notANumber"},//один из операндов не является числом
                {"*", "notANumber", "notANumber"},//оба операнда не являются числами
                {"unknownOperator", "10", "5"},//оператор не является допустимой математической операцией
                {"*", Integer.toString(Integer.MAX_VALUE), "2"},//результат операции превышает максимальное значение типа int
                {"+", "99999999999999999999", "2"},//один из операндов превышает максимальное значение int
                {"+",Integer.toString(Integer.MIN_VALUE-1),"1"},//один из операндов находится за гарницей минимального значения int
                {"/", "1", "0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"},
        };
    }

    @Test(dataProvider = "negativeData", expectedExceptions = CalculatorException.class)
    public void negativeTest(String operator, String value1, String value2) {
        Calculator.execute(new String[]{operator, value1, value2});
    }
}
