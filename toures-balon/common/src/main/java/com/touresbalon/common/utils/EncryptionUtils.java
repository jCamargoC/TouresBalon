package com.touresbalon.common.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionUtils {

	private static final String ALGO = "AES";
	private static final byte[] keyValue =new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

	/**
	 * Encrypt a string with AES algorithm.
	 *
	 * @param data
	 *            is a string
	 * @return the encrypted string
	 */
	public static String encrypt(String data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(data.getBytes());
		System.out.println("SAVED======>"+encVal);
		return new String(encVal,"UTF-8");
	}

	/**
	 * Decrypt a string with AES algorithm.
	 *
	 * @param encryptedData
	 *            is a string
	 * @return the decrypted string
	 */
	public static String decrypt(byte[] encryptedData) throws Exception {
		System.out.println("LOADED =====>"+encryptedData);
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);		
		byte[] decValue = c.doFinal(encryptedData);
		return new String(decValue);
	}

	private static Key generateKey() throws Exception {
		return new SecretKeySpec(keyValue, ALGO);
	}
	
	 public static String encodePassword(String password) {
	        String hashedPassword = null;
	        int i = 0;
	        while (i < 10) {
	            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	            hashedPassword = passwordEncoder.encode(password);	            
	            i++;
	        }
	        return hashedPassword;
	    }

	    public static boolean checkPassword(String password_plaintext, String stored_hash) {
	        boolean password_verified = false;
	        if (null == stored_hash || !stored_hash.startsWith("$2a$")) {
	            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
	        }
	        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
	        return (password_verified);
	    }
}
