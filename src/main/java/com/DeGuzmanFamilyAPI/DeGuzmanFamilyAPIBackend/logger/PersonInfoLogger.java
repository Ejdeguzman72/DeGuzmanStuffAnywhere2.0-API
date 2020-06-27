package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class PersonInfoLogger {

	static boolean append = true;
	public final static Logger personInfoLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException {
		personInfoLogger.setLevel(Level.SEVERE);
		String path = "C:\\EJ-Projects\\DeGuzmanFamilyAPI-Backend\\log\\person-info.log";
		FileHandler personInfoFileHandler;
		personInfoFileHandler = new FileHandler(path, append);
		personInfoLogger.addHandler(personInfoFileHandler);
	}
}
