
package com.pfrñfe.model.dtos;


public class UserLoginDto {
    private String name;
    private String password;
        
        public UserLoginDto(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public void setPassword(String encrypted) {
		this.password = encrypted;
	}

	public String getPassword() {
		return this.password;
	}

	public String getName() {
		return this.name;
	}
}
