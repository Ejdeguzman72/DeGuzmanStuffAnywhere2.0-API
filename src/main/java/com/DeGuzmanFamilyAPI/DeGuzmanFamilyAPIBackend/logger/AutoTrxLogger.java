package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class AutoTrxLogger {

	static boolean append = true;
	public final static Logger autoTrxLogger = Logger.getLogger(ClassName.class.getName());
	
	public static void log(String logMessage) throws SecurityException, IOException {
		File logDirectory = new File("./log");
		if(!logDirectory.exists()) {
			logDirectory.mkdirs();
			System.out.println("created directory" + " " + logDirectory);
		}
		FileHandler autoTrxHandler;
		String path = "C:\\EJ-Projects\\DeGUzmanFamilyAPI-Backend\\log\\genearl-transaction.log";
		autoTrxHandler = new FileHandler(path, append);
	}
}
