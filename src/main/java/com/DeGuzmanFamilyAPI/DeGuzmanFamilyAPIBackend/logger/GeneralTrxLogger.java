package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.apache.tomcat.util.descriptor.web.SecurityCollection;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class GeneralTrxLogger {

	private final static Logger GeneralTrxLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException {
		
		String path = "C:\\EJ-Projec/ts\\DeGUzmanFamilyAPI-Backend\\log\\general-transaction.log";
		
		File file = new File(path);
		
		if (file.isDirectory()) {
			System.out.println("This is the directory" + file);
		}
//		FileHandler generalTrxFileHandler;
//		generalTrxFileHandler = new FileHandler(path);
	}
}
