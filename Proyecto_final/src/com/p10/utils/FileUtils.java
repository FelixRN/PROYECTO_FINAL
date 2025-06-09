package com.p10.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileUtils {
	public static List<String> readLines(String filePathString) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filePathString));
		return lines;
	}

	public static void exportText(String filePathString, String text) throws IOException {
		Files.write(Paths.get(filePathString), text.getBytes());
	}
	
	public static Path getFolderPath() {
		return Paths.get("");
	}
        //Agregado->
        //List<String> configLines= FileUtils.readLines(envPath.toString());

}
