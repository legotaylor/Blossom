/*
    logger
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/logger
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.logger.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamp {
	public static String get(DateTimeFormatter formatter) {
		return LocalDateTime.now().format(formatter);
	}
}
