package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     * @param username
     * @param password
     * @param dob
     * @return
     */
    public static boolean login(String username, String password, String dob) {
        // Match a fixed user name, password, and date of birth
        return "ahsan".equals(username) &&
               "ahsan_pass".equals(password) &&
               "2000-01-01".equals(dob);
    }
}
