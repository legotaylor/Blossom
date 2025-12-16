/*
    logger
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/logger
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.logger.log;

import dev.dannytaylor.blossom.logger.log.handler.Handler;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Logger {
	public final DateTimeFormatter dateTimeFormatter;
	private final List<Handler> handlers;
	private final Callable<Boolean> isDebug;
	public Logger(Callable<Boolean> isDebug) {
		dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.handlers = new ArrayList<>();
		this.isDebug = isDebug;
	}
	public List<Handler> getHandlers() {
		return this.handlers;
	}
	public void registerHandler(Handler handler) {
		this.handlers.add(handler.setDateTimeFormatter(dateTimeFormatter));
	}
	private void log(dev.dannytaylor.blossom.logger.log.Logger.Type type, String message) {
		for (Handler handler : this.handlers) handler.log(type, message);
	}
	public void log(String message, String style) {
		for (Handler handler : this.handlers) handler.log(message, style);
	}
	public void log(StringBuilder message, String style) {
		for (Handler handler : this.handlers) handler.log(message.toString(), style);
	}
	public void unformatted(String message) {
		log(message, dev.dannytaylor.blossom.logger.log.Logger.Type.unformatted.name());
	}
	public void unformatted(StringBuilder message) {
		log(message, dev.dannytaylor.blossom.logger.log.Logger.Type.unformatted.name());
	}
	public void info(String message) {
		log(dev.dannytaylor.blossom.logger.log.Logger.Type.info, message);
	}
	public void info(StringBuilder message) {
		log(dev.dannytaylor.blossom.logger.log.Logger.Type.info, message.toString());
	}
	public void warn(String message) {
		log(dev.dannytaylor.blossom.logger.log.Logger.Type.warn, message);
	}
	public void warn(StringBuilder message) {
		log(dev.dannytaylor.blossom.logger.log.Logger.Type.warn, message.toString());
	}
	public void error(String message) {
		log(dev.dannytaylor.blossom.logger.log.Logger.Type.error, message);
	}
	public void error(StringBuilder message) {
		log(dev.dannytaylor.blossom.logger.log.Logger.Type.error, message.toString());
	}
	// I updated this for blossom, but I might actually update logger because this is nicer imo.
	public void debug(String message) {
		try {
			if (this.isDebug.call()) log(dev.dannytaylor.blossom.logger.log.Logger.Type.debug, message);
		} catch (Exception error) {
			debugError(error, message);
		}
	}
	public void debug(StringBuilder message) {
		try {
			if (this.isDebug.call()) log(dev.dannytaylor.blossom.logger.log.Logger.Type.debug, message.toString());
		} catch (Exception error) {
			debugError(error, message.toString());
		}
	}
	private void debugError(Exception error, String debugMessage) {
		log(Type.error, "Failed to log debug message: \"" + debugMessage + "\", caught exception: " + error);
	}
	public void close() {
		for (Handler handler : this.handlers) handler.close();
	}
	public enum Type {
		unformatted(""),
		info("INFO"),
		warn("WARNING"),
		error("ERROR"),
		debug("DEBUG");
		private final String prefix;
		Type(String prefix) {
			this.prefix = prefix;
		}
		public String getPrefix() {
			return this.prefix;
		}
	}
}

