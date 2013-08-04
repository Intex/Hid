package hid.service;

public interface PasswordHasher {
	String hashPassword(String password);
	String hashPassword(String password, String salt);
	boolean isPasswordCorrect(String password, String hashPassword, String salt);
	String getSalt();
}
