import model.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PositiveCalculatorTest {
    @DataProvider(name = "positiveData")
    public Object[][] positiveData() {
        return new Object[][]{
                {"+", "1", "1", 2.0},
                {"-", "2", "1", 1.0},
                {"*", "2", "2", 4.0},
                {"/", "4", "2", 2.0},
                {"+", "-1", "0", -1.0},
                {"+", "-1", "-1", -2.0},
                {"+", "1.0", "2.0", 3.0},
                {"+", Integer.toString(Integer.MAX_VALUE - 1), "1", Integer.MAX_VALUE},
                {"+", Integer.toString(Integer.MAX_VALUE), Integer.toString(Integer.MIN_VALUE), -1.0},
                {"-", Integer.toString(Integer.MIN_VALUE+1), "1", Integer.MIN_VALUE},
        };
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String operator, String value1, String value2, double expectedResult) {
        String result = Calculator.execute(new String[]{operator, value1, value2});
        assertEquals(Double.parseDouble(result), expectedResult, 0.001);
    }
}