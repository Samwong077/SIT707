package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class CustomLoopUtilsTest {

    @Test
    public void testSumFirstN_5() {
        Assert.assertEquals(15, CustomLoopUtils.sumFirstN(5)); // 1+2+3+4+5
    }

    @Test
    public void testSumFirstN_0() {
        Assert.assertEquals(0, CustomLoopUtils.sumFirstN(0));
    }

    @Test
    public void testCountEvens_10() {
        Assert.assertEquals(5, CustomLoopUtils.countEvens(10)); // 2,4,6,8,10
    }

    @Test
    public void testCountEvens_1() {
        Assert.assertEquals(0, CustomLoopUtils.countEvens(1));
    }
    
    @Test
    public void testSumFirstN_1() {
        Assert.assertEquals(1, CustomLoopUtils.sumFirstN(1));
    }

    @Test
    public void testCountEvens_OnlyEven() {
        Assert.assertEquals(1, CustomLoopUtils.countEvens(2));
    }
}