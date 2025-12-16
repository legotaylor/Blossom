/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom;

import dev.dannytaylor.blossom.block.Blocks;
import dev.dannytaylor.blossom.config.BlossomConfig;
import dev.dannytaylor.blossom.log.BlossomLogger;
import dev.dannytaylor.blossom.util.StaticVariables;

public class BlossomMain {
	private static void logs() {
		BlossomLogger.bootstrap();
	}

	private static void configs() {
		BlossomConfig.bootstrap();
	}

	public static void onInitializeClient() {
		StaticVariables.bootstrap();
		logs();
		BlossomLogger.get().info("Initializing Blossom!");
		configs();
		Blocks.bootstrap();
	}
}
