package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.IOException;
import java.util.logging.FileHandler;

import org.jboss.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class PersonInfoLogger {

	private final static Logger personInfoLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException {
		FileHandler personInfoFileHandler;
		String path = "C:\\EJ-Projects\\DeGUzmanFamilyAPI-Backend\\log\\person-info.log";
		personInfoFileHandler = new FileHandler(path);
	}
}
