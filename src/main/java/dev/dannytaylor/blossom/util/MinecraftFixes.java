/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.util;

import dev.dannytaylor.blossom.log.BlossomLogger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;

public class MinecraftFixes {
	public static void exit(int status) {
		BlossomLogger.get().info("Halting with status code: " + status + "!");
		Thread.currentThread().interrupt();
		if (Mouse.isCreated()) Mouse.destroy();
		if (Keyboard.isCreated()) Keyboard.destroy();
		if (AL.isCreated()) AL.destroy();
		Runtime.getRuntime().halt(status);
	}
}
