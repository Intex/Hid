package hid.service.impl;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static hid.utils.HashUtils.md5;

import org.springframework.stereotype.Service;

import hid.service.PasswordHasher;

@Service
public class PasswordHasherImpl implements PasswordHasher {
	
	private int saltLength = 5;
	private String salt;
	
	public PasswordHasherImpl() {}
	
	public PasswordHasherImpl(int saltLength) {
		this.saltLength = saltLength;
	}

	public String generateSalt() {
		return randomAlphanumeric(saltLength);
	}
	
	public String hashPassword(String password) {
		return hashPassword(password, getSalt());
	}
	
	@Override
	public String hashPassword(String password, String salt) {
		return md5(salt + md5(password + md5(salt)));
	}

	@Override	
	public boolean isPasswordCorrect(String password, String hashPassword, String salt) {
		return hashPassword(password, salt).equals(hashPassword);
	}

	@Override
	public String getSalt() {
		if (salt == null) {
			salt = generateSalt();
		}
		return salt;
	}

	public int getSaltLength() {
		return saltLength;
	}
	
	public void setSaltLength(int saltLength) {
		this.saltLength = saltLength;
	}
}
