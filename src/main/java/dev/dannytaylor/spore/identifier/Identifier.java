/*
    Spore
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/spore_src
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.spore.identifier;

public class Identifier {
	public String namespace;
	public String path;
	private Identifier(String namespace, String path) {
		this.namespace = namespace;
		this.path = path;
	}
	public static Identifier of(String path) {
		return splitOn(path, ':');
	}
	public static Identifier of(String namespace, String path) {
		return ofValidated(namespace, path);
	}
	public static Identifier splitOn(String id, char delimiter) {
		int i = id.indexOf(delimiter);
		if (i >= 0) {
			String string = id.substring(i + 1);
			if (i != 0) {
				String string2 = id.substring(0, i);
				return ofValidated(string2, string);
			} else {
				return ofSporeBlossom(string);
			}
		} else {
			return ofSporeBlossom(id);
		}
	}
	public static Identifier ofSporeBlossom(String path) {
		return of("sporeblossom", path);
	}
	private static Identifier ofValidated(String namespace, String path) {
		return new Identifier(validateNamespace(namespace), validatePath(path));
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		else if (obj instanceof Identifier) {
			Identifier identifier = (Identifier) obj;
			return this.namespace.equals(identifier.namespace) && this.path.equals(identifier.path);
		}
		return false;
	}
	public int hashCode() {
		return 31 * this.namespace.hashCode() + this.path.hashCode();
	}
	public String toString() {
		return this.namespace + ":" + this.path;
	}
	private static boolean isValidNamespaceCharacter(char character) {
		return character == '_' || character == '-' || character >= 'a' && character <= 'z' || character >= '0' && character <= '9' || character == '.';
	}
	public static boolean isValidPathCharacter(char character) {
		return character == '_' || character == '-' || character >= 'a' && character <= 'z' || character >= '0' && character <= '9' || character == '/' || character == '.';
	}
	private static String validateNamespace(String namespace) {
		if (isInvalidLength(namespace)) {
			throw new InvalidIdentifierException("Namespace of identifier exceeds 64 characters: " + namespace);
		} else if (!isNamespaceValid(namespace)) {
			throw new InvalidIdentifierException("Non [a-z0-9_.-] character in namespace of identifier: " + namespace);
		} else return namespace;
	}
	private static String validatePath(String path) {
		if (isInvalidLength(path)) {
			throw new InvalidIdentifierException("Path of identifier exceeds 64 characters: " + path);
		} else if (!isPathValid(path)) {
			throw new InvalidIdentifierException("Non [a-z0-9/._-] character in path of identifier: " + path);
		} else return path;
	}
	public static boolean isPathValid(String path) {
		for (int index = 0; index < path.length(); ++index) {
			if (!isValidPathCharacter(path.charAt(index))) return false;
		}
		return true;
	}
	public static boolean isNamespaceValid(String namespace) {
		for (int index = 0; index < namespace.length(); ++index) {
			if (!isValidNamespaceCharacter(namespace.charAt(index))) return false;
		}
		return true;
	}
	public static boolean isInvalidLength(String string) {
		return string.length() > 64;
	}
	public static Identifier append(Identifier identifier, String addToPath) {
		return of(identifier.namespace, identifier.path + addToPath);
	}
}
