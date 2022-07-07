import org.testng.Assert;
import org.testng.annotations.*;


public class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeClass
    public void taskLaunch() {
        System.out.println("######## 1.uzdevums! ########");
    }

    @BeforeMethod
    public void testLaunch(){
        System.out.println("Starting test!");
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(calculator.add(20, 11), 31);
    }

    @Test
    public void testSubtract(){
        Assert.assertEquals(calculator.subtract(20, 11), 9);
    }

    @Test
    public void testMultiply(){
        Assert.assertEquals(calculator.multiply(20, 2), 40);
    }

    @Test
    public void testDivide(){
        Assert.assertEquals(calculator.divide(20, 2), 10);
    }

    @AfterMethod
    public void testCompletion(){
        System.out.println("Test completed!");
    }
}
