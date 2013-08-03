package hid.test;

import hid.service.PasswordHasher;
import hid.service.impl.PasswordHasherImpl;

import org.junit.Test;
import org.junit.Assert;

public class TestPasswordHashing {
	@Test
	public void testPasswordHashing() {
		String password = "password";
		PasswordHasher hasher = new PasswordHasherImpl(password, 1000);
		String salt = hasher.getSalt();
		
		Assert.assertTrue(hasher.isPasswordCorrect(hasher.hashPassword(), salt));
	}
}
