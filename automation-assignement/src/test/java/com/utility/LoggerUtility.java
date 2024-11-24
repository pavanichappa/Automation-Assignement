package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	private LoggerUtility() {// private constructor because a singleton class has only one object and that too it should
		//be created inside the class in a public static method so that it can be access outside the class.
		
	}
	
	public static Logger getLogger(Class<?> clazz) {
		Logger logger = null;
		if(logger == null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;
	}
	
	

}
