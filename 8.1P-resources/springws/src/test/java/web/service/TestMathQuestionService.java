package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
	public void testAdditionValid() {
		Assert.assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0);
	}

	@Test
	public void testAdditionInvalid() {
		Assert.assertNull(MathQuestionService.q1Addition("a", "3"));
	}

	@Test
	public void testSubtractionValid() {
		Assert.assertEquals(2.0, MathQuestionService.q2Subtraction("5", "3"), 0);
	}

	@Test
	public void testSubtractionInvalid() {
		Assert.assertNull(MathQuestionService.q2Subtraction("", "3"));
	}

	@Test
	public void testMultiplicationValid() {
		Assert.assertEquals(15.0, MathQuestionService.q3Multiplication("5", "3"), 0);
	}

	@Test
	public void testMultiplicationInvalid() {
		Assert.assertNull(MathQuestionService.q3Multiplication("5", ""));
	}
}