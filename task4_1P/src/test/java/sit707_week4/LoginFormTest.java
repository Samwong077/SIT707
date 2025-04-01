package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
    public void testStudentIdentity() {
        String studentId = "s224078886"; // Your student ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Fuk Sang Wong"; // Your name
        Assert.assertNotNull("Student name is null", studentName);
    }

    // TC1: Empty username and password
    @Test
    public void testFailEmptyUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    // TC2: Correct username, wrong password
    @Test
    public void testFailCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // TC3: Correct username and password, but validation code not supplied (null)
    @Test
    public void testFailCorrectUsernameCorrectPasswordButNoValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean codeValid = LoginForm.validateCode(null);
        Assert.assertFalse(codeValid);
    }

    // TC4: Correct username and password, wrong validation code
    @Test
    public void testFailCorrectUsernameCorrectPasswordWrongValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean codeValid = LoginForm.validateCode("wrongcode");
        Assert.assertFalse(codeValid);
    }

    // TC5: Correct username, password, and correct validation code
    @Test
    public void testSuccessCorrectUsernamePasswordValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        // Extract validation code from errorMsg field (as per Main.java logic)
        String code = status.getErrorMsg();
        boolean codeValid = LoginForm.validateCode(code);
        Assert.assertTrue(codeValid);
    }
}
