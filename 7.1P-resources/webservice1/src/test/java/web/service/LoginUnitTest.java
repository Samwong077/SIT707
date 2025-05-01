package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginUnitTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("wronguser", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("ahsan", "wrongpass", "2000-01-01"));
    }

    @Test
    public void testInvalidDob() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "1999-12-31"));
    }

    @Test
    public void testEmptyFields() {
        assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testNullFields() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testBoundaryDobFormat() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "01-01-2000")); // wrong format
    }

    @Test
    public void testWhitespaceInFields() {
        assertFalse(LoginService.login(" ahsan ", "ahsan_pass", "2000-01-01"));
    }
}