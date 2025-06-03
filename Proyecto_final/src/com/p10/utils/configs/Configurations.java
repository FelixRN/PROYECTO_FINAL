package com.p10.utils.configs;

import com.p10.utils.FileUtils;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Configurations {

	private DatabaseConfigurations databaseConfigurations;

	public Configurations() {
	}
	
	public DatabaseConfigurations getDatabaseConfigurations() {
		return this.databaseConfigurations;
	}

	public void setDatabaseConfigurations(DatabaseConfigurations databaseConfigurations) {
		this.databaseConfigurations = databaseConfigurations;
	}

	private static Configurations configurations;
	
	public static Configurations getInstance() throws IOException {
		if(configurations != null) {
			return configurations;
		}
		Path envPath = FileUtils.getFolderPath().resolve(".env").toAbsolutePath();		
		
		List<String> configLines = FileUtils.readLines(envPath.toString());
		Map<String, String> configMap = new HashMap<String, String>();
		for(String line : configLines) {
			if(!line.trim().equals("")) {
				String[] args = line.split("=");
				configMap.put(args[0].trim(), args[1].trim());
			}
		}
		
		DatabaseConfigurations dbConfigs = new DatabaseConfigurations();
		dbConfigs.setHost(configMap.get("DB_HOST"));
		dbConfigs.setPort(configMap.get("DB_PORT"));
		dbConfigs.setUsername(configMap.get("DB_USERNAME"));
		dbConfigs.setPassword(configMap.get("DB_PASSWORD"));
		dbConfigs.setDatabase(configMap.get("DB_DATABASE"));
		
		configurations = new Configurations();
		configurations.setDatabaseConfigurations(dbConfigs);
		
		return configurations;
	}
}