package com.synchrony.synchronyapp.logger;

import org.apache.logging.log4j.Level;

public final class Logger {

	private static org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger("fileLogger");

	public static void info(String msg) {
		if (LOG.isInfoEnabled()) {
			StackTraceElement stElement = Thread.currentThread().getStackTrace()[2];
			LOG.info("[" + stElement.getFileName() + " :" + stElement.getLineNumber() + "]" + msg);
		}
	}

	public static void info(String msg, Throwable e) {
		if (LOG.isInfoEnabled()) {
			StackTraceElement stElement = Thread.currentThread().getStackTrace()[2];
			LOG.info("[" + stElement.getFileName() + " :" + stElement.getLineNumber() + "]" + msg, e);
		}
	}

	public static void error(String msg, Throwable e) {
		if (LOG.isEnabled(Level.ERROR)) {
			StackTraceElement stElement = Thread.currentThread().getStackTrace()[2];
			LOG.info("[" + stElement.getFileName() + " :" + stElement.getLineNumber() + "]" + msg, e);
		}
	}

	public static void error(String msg) {
		if (LOG.isEnabled(Level.ERROR)) {
			StackTraceElement stElement = Thread.currentThread().getStackTrace()[2];
			LOG.info("[" + stElement.getFileName() + " :" + stElement.getLineNumber() + "]" + msg);
		}
	}
}
