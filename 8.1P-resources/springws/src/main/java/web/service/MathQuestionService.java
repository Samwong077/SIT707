package web.service;

public class MathQuestionService {

	public static Double q1Addition(String number1, String number2) {
		try {
			double result = Double.valueOf(number1) + Double.valueOf(number2);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public static Double q2Subtraction(String number1, String number2) {
		try {
			double result = Double.valueOf(number1) - Double.valueOf(number2);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public static Double q3Multiplication(String number1, String number2) {
		try {
			double result = Double.valueOf(number1) * Double.valueOf(number2);
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}