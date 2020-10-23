package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class CarInfoLogger {

	static boolean append = true;
	
	public final static Logger carInfoLogger = Logger.getLogger(ClassName.class.getName(), null);
	
	public final static String path = "C:\\EJ-Projects\\Web-Applications\\DeGUzmanFamilyAPI-Backend\\log\\car-info-logs\\car-info.log";
	
	public static FileHandler carInfoFileHandler;
	
	public static void createLog() throws SecurityException, IOException {
		File logDirectory = new File("C:\\\\EJ-Projects\\\\Web-Applications\\\\DeGUzmanFamilyAPI-Backend\\\\log\\\\car-info-logs");
		
		if (!logDirectory.exists()) {
			logDirectory.mkdirs();
			System.out.println("Created directory: " + logDirectory);
		}
		
		carInfoFileHandler = new FileHandler(path,append);
		
		carInfoLogger.addHandler(carInfoFileHandler);
		
		System.out.println("Created log directory " + logDirectory);
	}
}
