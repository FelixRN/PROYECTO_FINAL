/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pfrñfe.model.auth;

import com.pfrñfe.model.dtos.UserLoginDto;
import com.pfrñfe.model.dtos.UserRegisterDto;


public interface IAuthModel {
    public boolean register(UserRegisterDto user);

	public UserLoginDto byName(String name);
}
