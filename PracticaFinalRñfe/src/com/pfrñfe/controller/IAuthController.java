
package com.pfrñfe.controller;

import com.pfrñfe.model.dtos.UserLoginDto;
import com.pfrñfe.model.dtos.UserRegisterDto;

public interface IAuthController {
    public boolean register(UserRegisterDto user);

	public boolean login(UserLoginDto user);
}
