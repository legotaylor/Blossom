/*
    Spore
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/spore_src
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.spore.identifier;

public class InvalidIdentifierException extends RuntimeException {
	public InvalidIdentifierException(String message) {
		super(message);
	}
	public InvalidIdentifierException(String message, Throwable throwable) {
		super(message, throwable);
	}
}