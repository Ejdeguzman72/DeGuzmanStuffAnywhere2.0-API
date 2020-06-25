package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.IOException;
import java.util.logging.FileHandler;

import org.jboss.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class MedicalTrxLogger {

	private final static Logger medicalTrxLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException {
		FileHandler medicalTrxFileHandler;
		String path = "C:\\EJ-Projects\\DeGUzmanFamilyAPI-Backend\\log\\medical-transaction.log";
		medicalTrxFileHandler = new FileHandler(path);
	}
}
