/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pfrñfe.controller;

import com.pfrñfe.model.auth.AuthModel;
import com.pfrñfe.model.auth.IAuthModel;
import com.pfrñfe.model.dtos.UserLoginDto;
import com.pfrñfe.model.dtos.UserRegisterDto;
import java.io.IOException;
import java.sql.SQLException;
import org.jasypt.util.password.StrongPasswordEncryptor;


public class AuthController implements IAuthController{
    private StrongPasswordEncryptor passwordEncryptor;
	private IAuthModel authModel;
	
	public AuthController() throws ClassNotFoundException, SQLException, IOException {
		this.passwordEncryptor = new StrongPasswordEncryptor();
		this.authModel = new AuthModel();
	}
	
	public boolean register(UserRegisterDto user) {
		
		String encrypted = this.passwordEncryptor.encryptPassword(user.getUserPassword());

		user.setUserPassword(encrypted);
		
		boolean result = this.authModel.register(user);
		
		return result;
	}

	public boolean login(UserLoginDto user) {
		
		UserLoginDto userDb = this.authModel.byName(user.getName());
		
                System.out.println("Password en BD: " + userDb.getPassword());
                System.out.println("Comparación con Jasypt: " + passwordEncryptor.checkPassword(user.getPassword(), userDb.getPassword()));

                
		if(userDb == null) {
			return false;
		}
		boolean result = this.passwordEncryptor.checkPassword(user.getPassword(), userDb.getPassword());
		
		return result;
                
	}
}
