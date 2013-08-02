package hid.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

abstract public class HashUtils {
	public static String md5(String input) {
		if (input == null) {
			return null;
		}
		String md5 = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] stringBytes = input.getBytes();
			md5 = new String(digest.digest(stringBytes));
		} catch (NoSuchAlgorithmException e) {}
		return md5;
	}
}
