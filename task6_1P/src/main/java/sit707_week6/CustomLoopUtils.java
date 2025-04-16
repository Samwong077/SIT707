package sit707_week6;

public class CustomLoopUtils {

    // (a) Simple loop: sum of first N numbers
    public static int sumFirstN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // (b) Loop with conditional: count even numbers in range 1 to N
    public static int countEvens(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (WeatherAndMathUtils.isEven(i)) {
                count++;
            }
        }
        return count;
    }
}