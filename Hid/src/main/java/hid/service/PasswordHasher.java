package hid.service;

public interface PasswordHasher {
	String generateSalt();
	String hashPassword();
	String hashPassword(String salt);
	boolean isPasswordCorrect(String hashPassword, String salt);
	String getSalt();
}
