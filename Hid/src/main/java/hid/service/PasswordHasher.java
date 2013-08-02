package hid.service;

public interface PasswordHasher {
	String getSalt();
	String hashPassword();
	String hashPassword(String salt);
	boolean isPasswordCorrect(String hashPassword, String salt);
}
