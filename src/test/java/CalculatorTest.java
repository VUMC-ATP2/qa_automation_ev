import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void testSum(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sum(20, 11), 31);
    }

    @Test
    public void testSubtract(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.subtract(20, 11), 9);
    }

    @Test
    public void testMultiply(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(20, 2), 40);
    }

    @Test
    public void testDivide(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(20, 2), 10);
    }
}
