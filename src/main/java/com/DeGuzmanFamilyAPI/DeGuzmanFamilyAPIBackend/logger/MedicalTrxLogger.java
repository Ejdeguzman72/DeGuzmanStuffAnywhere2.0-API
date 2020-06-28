package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class MedicalTrxLogger {

	public static final boolean append = true;
	public final static Logger medicalTrxLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException {
		File logDirectory = new File("./log");
		if(!logDirectory.exists()) {
			logDirectory.mkdirs();
			System.out.println("created directory" + " " + logDirectory);
		}
		FileHandler medicalTrxFileHandler;
		String path = "C:\\EJ-Projects\\DeGUzmanFamilyAPI-Backend\\log\\medical-transaction.log";
		medicalTrxFileHandler = new FileHandler(path,append);
		medicalTrxLogger.addHandler(medicalTrxFileHandler);
	}
}
