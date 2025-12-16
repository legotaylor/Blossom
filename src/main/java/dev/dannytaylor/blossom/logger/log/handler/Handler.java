/*
    logger
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/logger
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.logger.log.handler;

import dev.dannytaylor.blossom.logger.log.Logger;
import dev.dannytaylor.blossom.logger.util.Timestamp;

import java.time.format.DateTimeFormatter;

public abstract class Handler {
	public DateTimeFormatter dateTimeFormatter;
	public Handler() {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	}
	public Handler setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
		return this;
	}
	public abstract void log(Logger.Type type, String log);
	public abstract void log(String log, String style);
	public String format(Logger.Type type, String log) {
		return String.format("[%s] [%s] %s", Timestamp.get(dateTimeFormatter), type.getPrefix(), log);
	}
	public void close() {
	}
}
