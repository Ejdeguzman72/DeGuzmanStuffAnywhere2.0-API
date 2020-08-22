package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger;

import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class AuthenticationLogger {

	static boolean append = true;
	
	public final static Logger authenticationLogger = Logger.getLogger(ClassName.class.getName());
	
	
}
