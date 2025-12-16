/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.util;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;

import java.util.Optional;

public class StaticVariables {
	private static final String id = "blossom";

	public static String getId() {
		return id;
	}
	public static Optional<ModMetadata> getMetadata() {
		Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(id);
		return container.map(ModContainer::getMetadata);
	}

	public static void bootstrap() {
	}

	public static boolean isDebug() {
		return false; // TODO: Add a debug config option.
	}
}
