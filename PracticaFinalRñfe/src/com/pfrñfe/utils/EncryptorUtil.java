package com.pfrñfe.utils;

import org.jasypt.util.password.StrongPasswordEncryptor;


public class EncryptorUtil {
    private StrongPasswordEncryptor passwordEncryptor;
	
	public EncryptorUtil() {
		this.passwordEncryptor = new StrongPasswordEncryptor();
	}

	public String encrypt(String password) {
		return passwordEncryptor.encryptPassword(password);
	}
	
	public boolean verify(String encryptedPassword, String passwordToVerify) {
		return passwordEncryptor.checkPassword(passwordToVerify, encryptedPassword);
	}
}
