/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pfrñfe.model.dtos;


public class UserRegisterDto {
    private String userName;
	private String userPassword;
	private int rolId;
        
        public UserRegisterDto(String userName, String userPassword, int rolId) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.rolId = rolId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public int getRolId() {
		return rolId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
