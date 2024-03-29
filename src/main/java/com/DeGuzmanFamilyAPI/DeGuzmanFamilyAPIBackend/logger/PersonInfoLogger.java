package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class PersonInfoLogger {

	static boolean append = true;
	
	public final static Logger personInfoLogger = Logger.getLogger(ClassName.class.getName());
	
	public static final String path = "C:\\EJ-Projects\\DeGuzmanFamilyAPI-Backend\\log\\person-info-logs\\person-info.log";
	
	public static FileHandler personInfoFileHandler;
	
	public static void createLog() throws SecurityException, IOException {
		personInfoLogger.setLevel(Level.SEVERE);
		File logDirectory = new File("./log/person-info-logs");
		if(!logDirectory.exists()) {
			logDirectory.mkdirs();
			System.out.println("created directory" + " " + logDirectory);
		}
		personInfoFileHandler = new FileHandler(path, append);
		personInfoLogger.addHandler(personInfoFileHandler);
		
		System.out.println("Created Directory " + logDirectory);
	}
}
