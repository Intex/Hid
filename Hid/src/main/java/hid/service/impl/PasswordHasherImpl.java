package hid.service.impl;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static hid.utils.HashUtils.md5;
import hid.service.PasswordHasher;



public class PasswordHasherImpl implements PasswordHasher {
	
	private int saltLength;
	private String password;
	
	public PasswordHasherImpl(String password, int saltLength) {
		super();
		this.password = password;
		this.saltLength = saltLength;
	}
	
	@Override
	public String getSalt() {
		return randomAlphanumeric(saltLength);
	}
	
	@Override
	public String hashPassword(String salt) {
		return md5(salt + md5(password + salt));
	}
	
	@Override
	public String hashPassword() {
		return hashPassword(getSalt());		
	}
	
	@Override	
	public boolean isPasswordCorrect(String hashPassword, String salt) {
		return hashPassword(salt).equals(hashPassword);
	}

	public int getSaltLength() {
		return saltLength;
	}

	public String getPassword() {
		return password;
	}	
	
}
