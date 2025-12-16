/*
    logger
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/logger
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.logger.log.handler.handlers;

import dev.dannytaylor.blossom.logger.log.Logger;
import dev.dannytaylor.blossom.logger.log.handler.Handler;

import java.util.HashMap;
import java.util.Map;

public class ConsoleHandler extends Handler {
	private final Map<String, Color> styles = new HashMap<>();
	public void log(Logger.Type type, String message) {
		log(format(type, message), type.name());
	}
	public void log(String log, String style) {
		Color color = styles.get(style);
		System.out.println((color != null ? ansiColor(color) : "") + log + "\u001B[0m");
	}
	public void addStyle(String id, Color color) {
		styles.put(id, color);
	}
	public Map<String, Color> getStyles() {
		return styles;
	}
	public String ansiColor(Color color) {
		return "\u001B[38;2;" + color.red + ";" + color.green + ";" + color.blue + "m";
	}

	// This record-like class was added for blossom as we're targeting Java 8, not Java 21.
	public static class Color {
		public int red;
		public int green;
		public int blue;

		public Color(int red, int green, int blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}
	}
}
