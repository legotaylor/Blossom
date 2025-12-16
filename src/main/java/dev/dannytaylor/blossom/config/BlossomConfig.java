/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.config;

import dev.dannytaylor.blossom.log.BlossomLogger;
import dev.dannytaylor.blossom.util.StaticVariables;
import folk.sisby.kaleido.api.ReflectiveConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.serializers.TomlSerializer;
import folk.sisby.kaleido.lib.quiltconfig.api.values.TrackedValue;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.nio.file.Files;

public class BlossomConfig extends ReflectiveConfig {
	public static BlossomConfig instance = createToml(FabricLoader.getInstance().getConfigDir(), StaticVariables.getId(), "config", BlossomConfig.class);

	public static void bootstrap() {}

	public final TrackedValue<Boolean> skipToDirectConnectScreen = this.value(false);

	public final TrackedValue<String> reconnect = this.value("");

	public static void reload() {
		try {
			TomlSerializer.INSTANCE.deserialize(instance, Files.newInputStream(new File("config/" + StaticVariables.getId() + "/" + "config.toml").toPath()));
		} catch (Exception error) {
			BlossomLogger.get().error("Error occurred whilst reloading config: " + error);
		}
	}
}
