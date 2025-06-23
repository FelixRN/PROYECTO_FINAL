package com.pfrñfe.model.auth;

import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.model.dtos.UserLoginDto;
import com.pfrñfe.model.dtos.UserRegisterDto;
//import com.sun.jdi.connect.spi.Connection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;



public class AuthModel implements IAuthModel{
    private Connection connection;
	
	public AuthModel() throws ClassNotFoundException, SQLException, IOException {
		
		this.connection = DatabaseConnection.getConnection();
	}
	
	public boolean register(UserRegisterDto userCreateDto) {
		try {
			String query = "INSERT INTO usuario (nombre, password, id_rol) value (?, ?, ?)";
			PreparedStatement ps1 = connection.prepareStatement(query);
			
			ps1.setString(1, userCreateDto.getUserName());
			ps1.setString(2, userCreateDto.getUserPassword());
			ps1.setInt(3, userCreateDto.getRolId());
			
			ps1.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public UserLoginDto byName(String name) {
		String query = "SELECT nombre, password FROM usuario WHERE nombre like ?";
		
		try {
			PreparedStatement ps2 = connection.prepareStatement(query);

			ps2.setString(1, name);
			
			ResultSet rs = ps2.executeQuery();
			
			if (rs.next()) {
	            System.out.println("Si encontrado");
				String nameDb = rs.getString(1);
				String password = rs.getString(2);

				UserLoginDto user = new UserLoginDto(nameDb, password);
				return user;
			} else {
	            return null;
	        }
		} catch (Exception e) {
            return null;
		}
	}
}
