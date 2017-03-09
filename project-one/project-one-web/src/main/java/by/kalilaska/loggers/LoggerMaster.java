package by.kalilaska.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerMaster {

	private static Logger logger = null;// LoggerFactory.getLogger(LogbackMaster.class);

	public static <T> void setupClass(Class<T> kind) {
		logger = LoggerFactory.getLogger(kind);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void info(String message) {
		logger.info(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

}
