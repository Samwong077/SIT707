package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224078886";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Fuk Sang Wong";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // weatherAdvice tests
    @Test
    public void testCancelDueToHighWind() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(75.0, 2.0));
    }

    @Test
    public void testCancelDueToHeavyRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(40.0, 6.5));
    }

    @Test
    public void testCancelDueToCombinedModerateConditions() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 5.0));
    }

    @Test
    public void testWarnDueToWind() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 2.0));
    }

    @Test
    public void testWarnDueToRain() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(30.0, 4.5));
    }

    @Test
    public void testAllClear() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 1.0));
    }

    // isEven tests
    @Test
    public void testTrueNumberIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(7));
    }

    // isPrime tests
    @Test
    public void testIsPrimeWithEvenNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testIsPrimeOne() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1)); // According to this logic
    }

    @Test
    public void testIsPrimeWithPrimeOddNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(5));
    }
}