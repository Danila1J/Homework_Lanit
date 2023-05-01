import model.Calculator;
import model.CalculatorException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider(name = "negativeData")
    public Object[][] negativeData() {
        return new Object[][]{
                {" ", "2", "1"},
                {"", "2", "1"},
                {"-", "", "1"},
                {"-", " ", "2"},
                {"-", null, "3"},
                {null, "2", "1"},
                {"*+", "2", "2"},
                {"/", "4", "0"},
                {"+", "notANumber", "2"},
                {"-", "5", "notANumber"},
                {"*", "notANumber", "notANumber"},
                {"/", "10", "0"},
                {"unknownOperator", "10", "5"},
                {"*", Integer.toString(Integer.MAX_VALUE), "2"},
                {"+", "9999999999999999999999999", "2"},
                {"/", "1", "0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"},
        };
    }

    @Test(dataProvider = "negativeData", expectedExceptions = CalculatorException.class)
    public void negativeTest(String operator, String value1, String value2) {
        Calculator.execute(new String[]{operator, value1, value2});
    }
}
