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
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Accept test credentials
		if ("testuser".equals(username) && "12345".equals(password) && "2000-01-01".equals(dob)) {
			return true;
		}
		return false;
	}
	
	
}
