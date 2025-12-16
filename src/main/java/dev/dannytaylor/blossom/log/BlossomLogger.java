/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.log;

import dev.dannytaylor.blossom.logger.log.handler.handlers.ConsoleHandler;
import dev.dannytaylor.blossom.util.StaticVariables;
import dev.dannytaylor.blossom.logger.log.Logger;

public class BlossomLogger extends Logger {
	private static final BlossomLogger instance;

	public BlossomLogger() {
		super(StaticVariables::isDebug);
	}

	public static void bootstrap() {
		instance.registerHandler(addConsoleHandler());
	}
	private static ConsoleHandler addConsoleHandler() {
		ConsoleHandler handler = new ConsoleHandler();
		handler.addStyle(Logger.Type.warn.name(), new ConsoleHandler.Color(255, 176, 32));
		handler.addStyle(Logger.Type.error.name(), new ConsoleHandler.Color(255, 107, 107));
		handler.addStyle(Logger.Type.debug.name(), new ConsoleHandler.Color(244, 114, 192));
		return handler;
	}
	public static BlossomLogger get() {
		return instance;
	}
	static {
		instance = new BlossomLogger();
	}
}
